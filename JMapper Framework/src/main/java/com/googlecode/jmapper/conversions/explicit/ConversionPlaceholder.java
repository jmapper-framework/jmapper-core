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
package com.googlecode.jmapper.conversions.explicit;

import java.util.regex.Pattern;

/**
 * This Class contains all the placeholders used in the dynamic conversions.
 * @author Alessandro Vurro
 *
 */
public class ConversionPlaceholder {

	/** a reference to source */
	public static final String source = "${source}";
	/** a reference to destination */
	public static final String destination = "${destination}";
	
	// This variables are used for the replace
	
	/** a reference to source */
	public static final String sourcePattern = Pattern.quote(source);
	/** a reference to destination */
	public static final String destinationPattern = Pattern.quote(destination);
	/** indicates the type of source field */
	public static final String sourceTypePattern = Pattern.quote("${source.type}");
	/** indicates the name of source field */
	public static final String sourceNamePattern = Pattern.quote("${source.name}");
	/** indicates the type of destination field */
	public static final String destinationTypePattern = Pattern.quote("${destination.type}");
	/** indicates the name of destination field */
	public static final String destinationNamePattern = Pattern.quote("${destination.name}");
	/** indicates the get method of source field */
	public static final String sourceGetPattern = Pattern.quote("${source.get}");
	/** indicates the set method of source field */
	public static final String sourceSetPattern = Pattern.quote("${source.set}");
	/** indicates the get method of destination field */
	public static final String destinationGetPattern = Pattern.quote("${destination.get}");
	/** indicates the set method of destination field */
	public static final String destinationSetPattern = Pattern.quote("${destination.set}");
	
	/** the source reference value */
	public static final String sourceValue = "source";
	/** the destination reference value */
	public static final String destinationValue = "destination";
}
