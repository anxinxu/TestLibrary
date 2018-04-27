package com.anxin.annotation.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by anxin on 2018/2/8.
 * <p>
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface ModuleRouter {
}
