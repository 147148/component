package com.jd.kenan.component.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HeaderName {

    /**
     * 列的名字
     */
    String name() default "";

}
