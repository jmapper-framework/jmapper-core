package com.googlecode.jmapper.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.googlecode.jmapper.config.Constants;

//TODO JGlobalMap --> javaDoc
@Retention(RUNTIME)
@Target(TYPE)
public @interface JGlobalMap {
	String value() default Constants.DEFAULT_FIELD_VALUE;
	String[] attributes() default {};
	Class<?>[] classes() default {};
	String[] excluded() default {};
}
