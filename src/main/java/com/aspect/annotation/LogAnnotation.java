package com.aspect.annotation;

import java.lang.annotation.*;

/**
 * Created by carlwang on 5/14/16.
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String description() default "";
}
