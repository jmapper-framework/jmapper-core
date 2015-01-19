/**
 * Copyright (C) 2012 - 2015 Alessandro Vurro.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.jmapper.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.googlecode.jmapper.config.Constants;

/**
 * JGlobalMap is the annotation that allows you to apply a mapping to all fields, 
 * it has four fields: value, attributes, classes and excluded.<br>
 * Value identifies the target field name.<br>
 * Attributes identifies a list of target fields name.<br>
 * Classes represents the classes to which the attributes belong.<br>
 * Excluded identifies che attributes excluded from global mapping.
 * 
 * @author Alessandro Vurro
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface JGlobalMap {
	String value() default Constants.DEFAULT_FIELD_VALUE;
	String[] attributes() default {};
	Class<?>[] classes() default {};
	String[] excluded() default {};
}
