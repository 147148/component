package com.jd.kenan.component.util;

import com.jd.kenan.component.annotation.HeaderName;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public final class ImportExcelUtil<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportExcelUtil.class);

    private final Class<T> clazz;

    private final File file;

    private List<Header> headers;


    public ImportExcelUtil(Class<T> clazz, File file) throws Exception {
        this.clazz = clazz;
        this.file = file;
        this.headers = initHeader();
    }


    private List<Header> initHeader() {
        final Set<String> indexSet = new HashSet<>();
        List<Header> list = new ArrayList<>();
        ReflectionUtils.doWithFields(clazz, fc -> {
            HeaderName headerName = AnnotationUtils.findAnnotation(fc, HeaderName.class);
            if (headerName == null) {
                return;
            }

            if (indexSet.contains(headerName.name())) {
                throw new RuntimeException(String.format("%s.index() duplicate", HeaderName.class.getName()));
            }
            list.add(
                    new Header(headerName.name(), fc.getName())
            );
            indexSet.add(headerName.name());
        });

        return Collections.unmodifiableList(list);
    }

    public List<T> convert(int start, int count) throws Exception {
        return convert(0,start,count);
    }

    public List<T> convert(int index, int start, int count) throws Exception {


        if (file == null) {
            return null;
        }

        List<T> resultList = new ArrayList<>((int) (count / 0.75f));

        int end = start + count - 1;


        Workbook workbook;
        try (InputStream in = new FileInputStream(file)) {
            if (file.getName().endsWith(".xls")) {
                workbook = new HSSFWorkbook(in);
            } else if (file.getName().endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(in);
            } else {
                throw new RuntimeException("不能解析此文件！");
            }

            Sheet sheet = workbook.getSheetAt(0);
            if (sheet == null) return resultList;

            Row row = sheet.getRow(index);
            if (row == null) return resultList;

            List<String> sort = sort(row);
            if (CollectionUtils.isEmpty(sort)) {
                return resultList;
            }

            int sheetNum = sheet.getLastRowNum();

            if (end > sheetNum) {
                end = sheetNum;
            }

            for (int i = start; i <= end; i++) {
                Row textRow = sheet.getRow(i);
                T t = clazz.newInstance();

                for (int j = 0; j < sort.size(); j++) {
                    Cell cell = textRow.getCell(j);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue().trim();
                    Field field = clazz.getDeclaredField(sort.get(j));
                    field.setAccessible(true);
                    field.set(t, value);
                }
                resultList.add(t);
            }
        }

        return resultList;
    }


    private List<String> sort(Row row) {
        List<String> sortList = new ArrayList<>();
        for (int i = 0; ; i++) {
            if (row.getCell(i) != null) {
                String value = row.getCell(i).getStringCellValue();
                for (Header header : headers) {
                    if (header.name.equals(value)) {
                        sortList.add(header.fieldName);
                    }
                }
            } else {
                break;
            }
        }
        return sortList;
    }


    class Header {

        private final String name;

        private final String fieldName;


        public Header(String name, String fieldName) {
            this.name = name;
            this.fieldName = fieldName;
        }


    }
}

