package com.jd.kenan.component.business;

import com.jd.kenan.component.ComponentApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@SpringBootTest(classes = ComponentApplication.class)
@RunWith(SpringRunner.class)
public class ImportExcelBusinessTest {

    private static final String DRIVER_FILE_SOURCE_PATH = "D:\\duanhaojie\\work\\test\\76929250.xls";

    private static final String DRIVER_FILE_TARGET_PATH = "D:\\duanhaojie\\work\\test\\driver.sql";

    private static final String CARRIER_FILE_SOURCE__PATH = "D:\\duanhaojie\\work\\test\\76929251.xls";

    private static final String CARRIER_FILE_TARGET_PATH = "D:\\duanhaojie\\work\\test\\carrier.sql";

    private ImportExcelBusiness importExcelBusiness;

    @Test
    public void createDriverSql() {
        File sourceFile = new File(DRIVER_FILE_SOURCE_PATH);
        File targetFile = new File(DRIVER_FILE_TARGET_PATH);
        importExcelBusiness.createDriverSql(sourceFile, targetFile);
    }

    @Test
    public void createCarrierSql() {

        File sourceFile = new File(CARRIER_FILE_SOURCE__PATH);
        File targetFile = new File(CARRIER_FILE_TARGET_PATH);
        importExcelBusiness.createCarrierSql(sourceFile, targetFile);
    }

    @Autowired
    @Qualifier("importExcelBusiness")
    public void setImportExcelBusiness(ImportExcelBusiness importExcelBusiness) {
        this.importExcelBusiness = importExcelBusiness;
    }
}
