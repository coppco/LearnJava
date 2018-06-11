package com.coppco.aspect;

import java.lang.annotation.*;

/**
 * 自定义拦截规则的注解
 */

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface HJAction {
    String name();
}
