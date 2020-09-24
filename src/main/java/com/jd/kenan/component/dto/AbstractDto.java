package com.jd.kenan.component.dto;

import com.jd.kenan.component.util.JackSonUtil;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public abstract class AbstractDto implements Serializable {

    private static final long serialVersionUID = -3697794894140344403L;

    protected static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String toString(){
        return JackSonUtil.objectToJson(this);
    }
}
