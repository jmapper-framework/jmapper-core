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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.googlecode.jmapper.config.Constants;

/**
 * JMapAccessor is the annotation that allows you to specify getter and setter of a field, 
 * it has three fields: name, get and set.<br>
 * <b>name</b> identifies the field name.<br>
 * <b>get</b> the get method name.<br>
 * <b>set</b> the set method name.
 * @author Alessandro Vurro
 *
 */
@Retention(RUNTIME)
@Target({FIELD,TYPE})
public @interface JMapAccessor {
	String name() default Constants.DEFAULT_FIELD_VALUE;
	String get() default Constants.DEFAULT_ACCESSOR_VALUE;
	String set() default Constants.DEFAULT_ACCESSOR_VALUE;
}
