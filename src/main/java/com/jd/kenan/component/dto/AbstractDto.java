package com.jd.kenan.component.dto;

import com.jd.kenan.component.util.JackSonUtil;

import java.io.Serializable;

public abstract class AbstractDto implements Serializable {

    private static final long serialVersionUID = -3697794894140344403L;

    @Override
    public String toString(){
        return JackSonUtil.objectToJson(this);
    }
}
