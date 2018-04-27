package com.anxin.annotation.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by anxin on 2018/2/8.
 * <p>
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface BindView {
}
