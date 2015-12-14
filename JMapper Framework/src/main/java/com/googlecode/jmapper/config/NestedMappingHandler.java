package com.googlecode.jmapper.config;

import static com.googlecode.jmapper.config.Constants.NESTED_MAPPING_ENDS_SYMBOL;
import static com.googlecode.jmapper.config.Constants.NESTED_MAPPING_STARTS_SYMBOL;

import java.lang.reflect.Field;

import com.googlecode.jmapper.exceptions.InvalidNestedMappingException;
import com.googlecode.jmapper.util.ClassesManager;
public class NestedMappingHandler {

	/**
	 * Returns true if this regex represents a nested mapping, false other cases.
	 * @param regex string that represents the mapping
	 * @return true if this is a nested mapping, false other cases
	 */
	public static boolean isNestedMapping(String regex){
		return   regex.startsWith(NESTED_MAPPING_STARTS_SYMBOL)
			  && regex.endsWith  (NESTED_MAPPING_ENDS_SYMBOL);
	}
	
	/**
	 * This method returns the name of the field whose name matches with regex.
	 * @param aClass class to check
	 * @param regex regex used to find the field
	 * @return the field name if exists, null otherwise
	 */
	public static void nestedMappingValidyChecks(Class<?> aClass,String regex){
		
		// splitto la stringa
		
		// primo split con aClass -> verifico accessor
		
		// secondo split con classe di primo split -> verifico accessor
		
		// ....
		
		// ultimo split con class penultimo split -> verifico accessor
		
		
		// se ci sono errori lanciare exception, con indicazioni del campo inestato mal configurato
		throw new InvalidNestedMappingException(regex);
	}
	
	/**
	 * This method returns the nested field if exists, throws an InvalidNestedMappingException otherwise.
	 * @param aClass class to check
	 * @param regex regex used to find the nested field
	 * @return the nested field if exists, null otherwise
	 * @throws InvalidNestedMappingException in case of an invalid nested mapping
	 */
	public static Field getNestedField(Class<?> aClass,String regex) throws InvalidNestedMappingException{
		
		//non tornerà mai null, o il campo nidificato o exception
		// questo ritorno è solo di appoggio
		return ClassesManager.retrieveField(aClass, regex);
	}
	
	/**
	 * This method returns the nested class that contains the field to map (if exists), throws an InvalidNestedMappingException otherwise.
	 * @param aClass class to check
	 * @param regex regex used to find the nested field
	 * @return the nested class if exists, null otherwise
	 * @throws InvalidNestedMappingException in case of an invalid nested mapping
	 */
	public static Class<?> getNestedClass(Class<?> aClass,String regex) throws InvalidNestedMappingException{
		
		//non tornerà mai null, o la classe nidificata o exception
		// il ritorno della classe stessa è di appoggio
		return aClass;
	}
}
