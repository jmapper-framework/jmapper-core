/**
 * Copyright (C) 2012 - 2013 Alessandro Vurro.
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

package com.googlecode.jmapper.operations;

import static com.googlecode.jmapper.util.ClassesManager.areEqual;
import static com.googlecode.jmapper.util.ClassesManager.areMappedObjects;
import static com.googlecode.jmapper.util.ClassesManager.isAssignableFrom;
import static com.googlecode.jmapper.util.GeneralUtility.collectionIsAssignableFrom;
import static com.googlecode.jmapper.util.GeneralUtility.isBasic;
import static com.googlecode.jmapper.util.GeneralUtility.isStructure;
import static com.googlecode.jmapper.util.GeneralUtility.mapIsAssignableFrom;
import java.lang.reflect.Field;
import com.googlecode.jmapper.conversions.explicit.ConversionAnalyzer;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.operations.analyzer.ArrayAnalyzer;
import com.googlecode.jmapper.operations.analyzer.ArrayListAnalyzer;
import com.googlecode.jmapper.operations.analyzer.BasicAnalyzer;
import com.googlecode.jmapper.operations.analyzer.CollectionAnalyzer;
import com.googlecode.jmapper.operations.analyzer.MapAnalyzer;
import com.googlecode.jmapper.operations.analyzer.ObjectAnalyzer;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.xml.XML;

/**
 * OperationAnalyzer analyzes the fields and returns the informations relating the operation to be performed.
 * @author Alessandro Vurro
 *
 */
public final class OperationAnalyzer {
	
	/** xml object */
	private XML xml;
	
	private BasicAnalyzer basicAnalyzer;
	private ArrayAnalyzer arrayAnalyzer;
	private ObjectAnalyzer objectAnalyzer;
	private CollectionAnalyzer collectionAnalyzer;
	private MapAnalyzer mapAnalyzer;
	private ArrayListAnalyzer arrayListAnalyzer;
	private ConversionAnalyzer conversionAnalyzer;
	private InfoOperation info;
	
	public OperationAnalyzer(XML aXml, ConversionAnalyzer conversionAnalyzer) {
		xml = aXml;
		basicAnalyzer      = new BasicAnalyzer();
		arrayAnalyzer      = new ArrayAnalyzer(xml);
		objectAnalyzer     = new ObjectAnalyzer(xml);
		collectionAnalyzer = new CollectionAnalyzer(xml);
		mapAnalyzer        = new MapAnalyzer(xml);
		arrayListAnalyzer  = new ArrayListAnalyzer(xml);
		this.conversionAnalyzer = conversionAnalyzer;
	}
	
	/**
	 * This method analyzes the fields and returns the informations relating the operation to be performed.
	 * @param destination
	 * @param source
	 * @return returns the informations relating the operation to be performed
	 * @see InfoOperation
	 */
	public boolean isUndefined(final Field destination,final Field source) {
		
		info = null;
		Class<?> dClass = destination.getType();
		Class<?> sClass = source.getType();
		
		// 	BASIC OPERATION
		if(areBasic(destination,source))   	        info = basicAnalyzer     .getInfoOperation(destination, source);
		// ARRAYS OPERATION
		else if(areArrays(dClass,sClass)) 	   	    info = arrayAnalyzer	 .getInfoOperation(destination, source);
		// OBJECTS OPERATION
		else if(areMappedObjects(dClass,sClass,xml))info = objectAnalyzer	 .getInfoOperation(destination, source);
		// COLLECTIONS OPERATION
		else if(areCollections(dClass,sClass))  	info = collectionAnalyzer.getInfoOperation(destination, source);
		// MAPS OPERATION
		else if(areMaps(dClass,sClass))		        info = mapAnalyzer		 .getInfoOperation(destination, source);
		// ARRAY <-> LIST OPERATION
		else if(areArrayAndList(dClass, sClass))    info = arrayListAnalyzer .getInfoOperation(destination, source);
		// if the operation has not been identified
		else info = new InfoOperation().setInstructionType(OperationType.UNDEFINED);
		
		boolean conversionMethodExists = conversionAnalyzer.fieldsToCheck(destination,source);
		
		OperationType operationType = info.getInstructionType(); 
			
		if(operationType.isUndefined() && !conversionMethodExists)return true;
		
		if(conversionMethodExists)                  // explicit conversion between primitive types
			info.setInstructionType(operationType.isBasic()?OperationType.BASIC_CONVERSION
													// explicit conversion between complex types
			                         			   :OperationType.CONVERSION);
		return false;
	}
	
	public InfoOperation getInfo(){
		return info;
	}
	
	private boolean areBasic(Field destination,Field source){
		Class<?> dClass = destination.getType();
		Class<?> sClass = source.getType();
		// if the fields aren't structure or mapped objects
		return  (!isStructure(dClass) && !isStructure(sClass) && !areMappedObjects(dClass,sClass,xml)
				 // and destination is equal or assignable from source
				 && (areEqual(destination,source) || isAssignableFrom(destination,source))
				) 
				// or are both basic classes
				||	(isBasic(dClass) && isBasic(sClass));
	}
	
	private boolean areArrays(Class<?> dClass, Class<?> sClass){
		return dClass.isArray() && sClass.isArray();
	}
	private boolean areCollections(Class<?> dClass, Class<?> sClass){
		return collectionIsAssignableFrom(dClass) && collectionIsAssignableFrom(sClass);
	}
	private boolean areMaps(Class<?> dClass, Class<?> sClass){
		return mapIsAssignableFrom(dClass) &&  mapIsAssignableFrom(sClass);
	}
	private boolean areArrayAndList(Class<?> dClass, Class<?> sClass){
		return (dClass.isArray() && collectionIsAssignableFrom(sClass)) 
			|| (sClass.isArray() && collectionIsAssignableFrom(dClass));
	}
}