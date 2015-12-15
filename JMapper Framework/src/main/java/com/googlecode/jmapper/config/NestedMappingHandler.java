package com.googlecode.jmapper.config;

import static com.googlecode.jmapper.config.Constants.NESTED_MAPPING_ENDS_SYMBOL;
import static com.googlecode.jmapper.config.Constants.NESTED_MAPPING_SPLIT_SYMBOL;
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
	 * @param nestedMappingPath nested mapping path
	 * @return a list with splitted fields
	 */
	private static String[] nestedFields(String nestedMappingPath){
		return nestedMappingPath
				 .substring(NESTED_MAPPING_STARTS_SYMBOL.length(), nestedMappingPath.length() - NESTED_MAPPING_ENDS_SYMBOL.length())
		         .split(NESTED_MAPPING_SPLIT_SYMBOL);
	}
	
	private static void checkGetAccessor(Class<?> aClass, String nestedField){
		// deve controllare che ci siano i get
	}
	
	private static void checkAccessors(Class<?> aClass, String nestedField){
		// deve controllare che ci siano i get e set
	}
	
	private static Class<?> getFieldClass(Class<?> aClass,String nestedField){
		// ritorna la classe del campo
		return null;
	}
	
	/**
	 * This method returns the name of the field whose name matches with regex.
	 * @param aClass class to check
	 * @param regex regex used to find the field
	 */
	public static void nestedMappingValidyChecks(Class<?> aClass,String regex){
		
			
		Class<?> nestedClass = aClass;
		String[] nestedFields = nestedFields(regex);
		
		// from first field to second-last it's only checked get accessor 
		for(int i = 0; i< nestedFields.length-1;i++){
			String nestedField = nestedFields[i];
			checkGetAccessor(nestedClass, nestedField);
			nestedClass = getFieldClass(nestedClass, nestedField);
		}
		
		// the last fields in the path must have get and set accessors
		checkAccessors(nestedClass, nestedFields[nestedFields.length-1]);
		
		//TODO questa exception va lanciata nei metodi interni, con in aggiunta (nella mappa) i campi mal configurati
		throw new InvalidNestedMappingException(regex);
	}
	
	/**
	 * This method returns the nested field if exists, throws an InvalidNestedMappingException otherwise.
	 * @param aClass class to check
	 * @param regex regex used to find the nested field
	 * @return the nested field if exists, null otherwise
	 */
	public static Field getNestedField(Class<?> aClass,String regex){
		
		//non tornerà mai null, o il campo nidificato o exception
		// questo ritorno è solo di appoggio
		return ClassesManager.retrieveField(aClass, regex);
	}
	
	/**
	 * This method returns the nested class that contains the field to map, throws an InvalidNestedMappingException otherwise in errors case.
	 * @param aClass class to check
	 * @param regex regex used to find the nested field
	 * @return the nested class if exists, null otherwise
	 */
	public static Class<?> getNestedClass(Class<?> aClass,String regex){
		
		//non tornerà mai null, o la classe nidificata o exception
		// il ritorno della classe stessa è di appoggio
		return aClass;
	}
}
