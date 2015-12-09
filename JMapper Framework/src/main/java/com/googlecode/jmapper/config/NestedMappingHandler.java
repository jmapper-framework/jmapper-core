package com.googlecode.jmapper.config;

import static com.googlecode.jmapper.config.Constants.NESTED_MAPPING_ENDS_SYMBOL;
import static com.googlecode.jmapper.config.Constants.NESTED_MAPPING_STARTS_SYMBOL;

import java.lang.reflect.Field;

import com.googlecode.jmapper.exceptions.InvalidNestedMappingException;
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
	public static boolean isNestedMappingValid(Class<?> aClass,String regex){
		
		// qui ho la classe di partenza e il path, devo verificare
		// che il path sia valido, quindi verificare classe per classe
		// se ci sono i campi e i metodi di accesso (in modo ricorsivo)
		// se ci sono errori lanciare exception, con indicazioni del campo inestato mal configurato
		return false;
	}
	
	/**
	 * This method returns the nested field if exists, throws an InvalidNestedMappingException otherwise.
	 * @param aClass class to check
	 * @param regex regex used to find the nested field
	 * @return the nested field if exists, null otherwise
	 * @throws InvalidNestedMappingException in case of an invalid nested mapping
	 */
	public static Field getNestedField(Class<?> aClass,String regex) throws InvalidNestedMappingException{
		
		if(!isNestedMappingValid(aClass, regex))
			throw new InvalidNestedMappingException("invalid nested mapping");
				
		return null;
	}
}
