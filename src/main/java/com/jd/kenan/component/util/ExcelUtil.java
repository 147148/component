package com.jd.kenan.component.util;

import com.jd.kenan.component.annotation.HeaderName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class ExcelUtil<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);

    private Class<T> clazz;

    private InputStream in;

    private List<Header> headers;


    private List<Header> initHeader(){
        Method[] methods = clazz.getMethods();
        List<Header> list=new ArrayList<>(methods.length);

        for (Method m :methods){
            HeaderName headerName = AnnotationUtils.findAnnotation(m, HeaderName.class);
            if (headerName==null){
                continue;
            }



        }
    }



    class Header {

        private HeaderName name;

        private Field field;

        Header (){

        }



    }
}
