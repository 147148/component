package com.jd.kenan.component.annotation;

import java.lang.annotation.*;

/**
 * @author kenan
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ColumnName {

    /**
     * 对应数据库字段名字
     */
    String name() default "";
}
