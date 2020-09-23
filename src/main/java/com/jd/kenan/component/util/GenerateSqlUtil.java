package com.jd.kenan.component.util;

import org.springframework.util.Assert;

import java.io.File;
import java.util.List;

/**
 * @author kenan
 */
public final class GenerateSqlUtil<T> {

    private static final String SQL="INSERT INTO %s";

    private static final String NAMES="(%s)";

    private static final String VALUES="(%s)";

    private final List<String> names;

    private final Class<T> clazz;

    private final String tableName;

    //记录
    private final StringBuilder sb;

    //输出的sql文件
    private final File file;


    public GenerateSqlUtil(List<String> names,Class<T> clazz,File file,String tableName) {
        this.names = names;
        this.clazz=clazz;
        this.tableName=tableName;
        this.file=file;
        this.sb = init();
    }



    private StringBuilder init(String tableName) {
        Assert.notEmpty(names, "名字不能为空");
        StringBuilder sb = new StringBuilder(String.format(SQL,tableName));
        for (String name:names){

        }
        sb.append(String.format(NAMES,));

        return sb;
    }
}
