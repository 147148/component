package com.jd.kenan.component.util;

import com.jd.kenan.component.annotation.ColumnName;
import com.jd.kenan.component.annotation.TableName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author kenan
 */
public final class GenerateSqlUtil<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateSqlUtil.class);

    private static final String GET = "get";

    private static final String SQL = "INSERT INTO %s";

    private static final String NAMES = "(%s)";

    private static final String VALUES = " VALUES(%s)";

    private static final String VALUE = "'%s'";

    private static final String SPLIT = ",";

    private static final String END = ";";

    private final List<String> names;

    private final Class<T> clazz;

    private final String tableName;

    //记录
    private final StringBuilder sb;

    //输出的sql文件
    private final File file;


    public GenerateSqlUtil(Class<T> clazz, File file) {
        this.clazz = clazz;
        this.names = initNames();
        this.tableName = initTableName();
        this.file = file;
        this.sb = init(tableName);
    }

    private String initTableName() {
        TableName tableName = AnnotationUtils.findAnnotation(clazz, TableName.class);
        Assert.notNull(tableName, String.format("%s类上未找到@TableName注解", clazz.getName()));

        String name = tableName.name();
        Assert.hasText(name, String.format("%s类上未找到表名", clazz.getName()));

        return name;

    }

    private StringBuilder init(String tableName) {
        Assert.notEmpty(names, "名字不能为空");
        StringBuilder sb = new StringBuilder(String.format(SQL, tableName));
        StringBuilder b = new StringBuilder();
        for (String name : names) {
            b.append(name).append(SPLIT);
        }
        sb.append(String.format(NAMES, b.substring(0, b.length() - 1)));

        return sb;
    }

    private List<String> initNames() {

        List<String> nameList = new ArrayList<>();

        ReflectionUtils.doWithFields(clazz, fc -> {
            ColumnName columnName = AnnotationUtils.findAnnotation(fc, ColumnName.class);
            if (columnName == null) {
                return;
            }

            if (nameList.contains(columnName.name())) {
                throw new RuntimeException(String.format("%s.name() duplicate", ColumnName.class.getName()));
            }
            nameList.add(columnName.name());
        });


        return nameList;
    }


    public void appendList(List<T> list) {
        for (T t : list) {
            appendValue(t);
        }
    }


    public void appendValue(T t) {

        List<Column> list = new ArrayList<>();

        final Set<String> nameSet = new HashSet<>();

        ReflectionUtils.doWithFields(clazz, fc -> {
            ColumnName columnName = AnnotationUtils.findAnnotation(fc, ColumnName.class);
            if (columnName == null) {
                return;
            }

            if (nameSet.contains(columnName.name())) {
                throw new RuntimeException(String.format("%s.name() duplicate", ColumnName.class.getName()));
            }
            list.add(
                    new Column(columnName.name(), fc.getName())
            );
            nameSet.add(columnName.name());
        });

        StringBuilder builder = new StringBuilder();

        for (String name : names) {
            for (Column column : list) {
                if (name.equals(column.name)) {
                    Method m = ClassUtils.getMethod(t.getClass(), getMethodName(column.name));
                    String result = (String) ReflectionUtils.invokeMethod(m, t);
                    if (StringUtils.hasText(result)) {
                        builder.append(String.format(VALUE, result)).append(SPLIT);
                    } else {
                        builder.append("null").append(SPLIT);
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(String.format(VALUES, builder.substring(0, builder.length() - 1))).append(END);

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file, true))) {
            bf.write(stringBuilder.toString());
            bf.newLine();
        } catch (Exception e) {
            LOGGER.info("追加写入文件错误", e);
        }

    }

    private String getMethodName(String name) {

        return GET.concat(
                name.substring(0, 1).toUpperCase().concat(name.substring(1))
        );

    }

    class Column {

        final String name;

        final String value;

        public Column(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

}
