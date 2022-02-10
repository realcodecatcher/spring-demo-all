package com.geek.annotation;

import java.lang.annotation.*;

/**
 * @author geek
 * @date 2022/1/24 17:31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckParam {
}
