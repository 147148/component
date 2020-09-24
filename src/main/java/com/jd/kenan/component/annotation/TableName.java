package com.jd.kenan.component.annotation;

import java.lang.annotation.*;

/**
 * @author kenan
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableName {

    String name() default "";
}
