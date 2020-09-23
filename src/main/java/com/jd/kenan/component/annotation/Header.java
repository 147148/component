package com.jd.kenan.component.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Header {

    /**
     * 列的名字
     */
    String name() default "";


    /**
     * 索引 对应列
     */
    int index() default 0;


}
