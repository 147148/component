package com.jd.kenan.component.util;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;

/**
 * 此类负责调度
 */
public final class ExportExcelUtil<T> {

    private final Class<T> clazz;

    private final File sourceFile;

    private final File targetFile;

    public ExportExcelUtil(Class<T> clazz, File sourceFile, File targetFile) {
        this.clazz = clazz;
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
    }

    public void generateSql() {

        ImportExcelUtil<T> util = new ImportExcelUtil<>(clazz, sourceFile);
        int start = 0, count = 500;

        for (; ; ) {
            List<T> list = util.convert(0, start, count);
            if (CollectionUtils.isEmpty(list)) {
                return;
            }

            generateSql(list, targetFile);
            start = start + list.size();
        }

    }

    private void generateSql(List<T> list, File targetFile) {

        GenerateSqlUtil<T> util2 = new GenerateSqlUtil<>(
                clazz, targetFile);
        util2.appendList(list);
    }
}
