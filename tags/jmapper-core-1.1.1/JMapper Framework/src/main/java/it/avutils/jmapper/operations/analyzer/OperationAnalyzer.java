/**
 * Copyright (C) 2013 Alessandro Vurro.
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

package it.avutils.jmapper.operations.analyzer;

import static it.avutils.jmapper.util.ClassesManager.areEqual;
import static it.avutils.jmapper.util.ClassesManager.areMappedObjects;
import static it.avutils.jmapper.util.ClassesManager.isAssignableFrom;
import static it.avutils.jmapper.util.GeneralUtility.collectionIsAssignableFrom;
import static it.avutils.jmapper.util.GeneralUtility.isBasic;
import static it.avutils.jmapper.util.GeneralUtility.isStructure;
import static it.avutils.jmapper.util.GeneralUtility.mapIsAssignableFrom;
import it.avutils.jmapper.enums.OperationType;
import it.avutils.jmapper.operations.info.InfoOperation;
import it.avutils.jmapper.util.XML;
import java.lang.reflect.Field;


/**
 * OperationAnalyzer analyzes the fields and returns the informations relating the operation to be performed.
 * @author Alessandro Vurro
 *
 */
public final class OperationAnalyzer {
	
	/** xml object */
	private final XML xml;
	
	private final BasicAnalyzer basicAnalyzer;
	private final ArrayAnalyzer arrayAnalyzer;
	private final ObjectAnalyzer objectAnalyzer;
	private final CollectionAnalyzer collectionAnalyzer;
	private final MapAnalyzer mapAnalyzer;
	private final ArrayListAnalyzer arrayListAnalyzer;
	
	public OperationAnalyzer(XML aXml) {
		xml = aXml;
		basicAnalyzer = new BasicAnalyzer();
		arrayAnalyzer = new ArrayAnalyzer(xml);
		objectAnalyzer = new ObjectAnalyzer(xml);
		collectionAnalyzer = new CollectionAnalyzer(xml);
		mapAnalyzer = new MapAnalyzer(xml);
		arrayListAnalyzer = new ArrayListAnalyzer(xml);
	}
	
	/**
	 * This method analyzes the fields and returns the informations relating the operation to be performed.
	 * @param destination
	 * @param source
	 * @return returns the informations relating the operation to be performed
	 * @see InfoOperation
	 */
	public InfoOperation getInfoOperation(final Field destination,final Field source) {
		
		Class<?> dClass = destination.getType();
		Class<?> sClass = source.getType();
		
		// 	BASIC OPERATION
		if(areBasic(destination,source))   	   return basicAnalyzer      .getInfoOperation(destination, source);
		// ARRAYS OPERATION
		if(areArrays(dClass,sClass)) 	   	   return arrayAnalyzer	     .getInfoOperation(destination, source);
		// OBJECTS OPERATION
		if(areMappedObjects(dClass,sClass,xml))return objectAnalyzer	 .getInfoOperation(destination, source);
		// COLLECTIONS OPERATION
		if(areCollections(dClass,sClass))  	   return collectionAnalyzer .getInfoOperation(destination, source);
		// MAPS OPERATION
		if(areMaps(dClass,sClass))		       return mapAnalyzer		 .getInfoOperation(destination, source);
		// ARRAY <-> LIST OPERATION
		if(areArrayAndList(dClass, sClass))    return arrayListAnalyzer  .getInfoOperation(destination, source);
		
		// if the operation has not been identified
		return new InfoOperation().setInstructionType(OperationType.UNDEFINED);
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