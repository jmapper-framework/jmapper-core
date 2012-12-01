/**
 * Copyright (C) 2012 Alessandro Vurro.
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

package it.avutils.jmapper.annotations;

import it.avutils.jmapper.constants.Constants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * JMap is the annotation that allows you to assign the current field with others, 
 * it has three fields: value, attributes and classes.<br>
 * Value identifies the target field name.<br>
 * Attributes identifies a list of target fields name.<br>
 * Classes represents the classes to which the attributes belong.
 * @author Alessandro Vurro
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JMap {
	String value() default Constants.DEFAULT_FIELD_VALUE;
	String[] attributes() default {};
	Class<?>[] classes() default {};
}
