package com.jd.kenan.component.dto;

import com.jd.kenan.component.util.JackSonUtil;

import java.io.Serializable;

public abstract class AbstractDto implements Serializable {

    private static final long serialVersionUID = -3697794894140344403L;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString(){
        return JackSonUtil.objectToJson(this);
    }
}
