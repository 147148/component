package com.jd.kenan.component.business;

import com.jd.kenan.component.dto.CarrierDto;
import com.jd.kenan.component.dto.DriverDto;
import com.jd.kenan.component.util.ExportExcelUtil;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author kenan
 */
@Component("importExcelBusiness")
public class ImportExcelBusiness extends AbstractBusiness{


    public void createDriverSql(File sourceFile, File targetFile) {
        ExportExcelUtil<DriverDto> util = new ExportExcelUtil<>(
                DriverDto.class, sourceFile, targetFile);
        util.generateSql();
    }


    public void createCarrierSql(File sourceFile, File targetFile) {
        ExportExcelUtil<CarrierDto> util = new ExportExcelUtil<>(
                CarrierDto.class, sourceFile, targetFile);
        util.generateSql();
    }

}
