package com.googlecode.jmapper.util;

import static com.googlecode.jmapper.operations.NestedMappingHandler.isNestedMapping;
import static com.googlecode.jmapper.operations.NestedMappingHandler.nestedFields;
import static com.googlecode.jmapper.util.GeneralUtility.isEmpty;
import static com.googlecode.jmapper.util.GeneralUtility.isNull;

import com.googlecode.jmapper.api.JMapperAPI;
import com.googlecode.jmapper.config.JmapperLog;
import com.googlecode.jmapper.xml.XML;
import com.googlecode.jmapper.xml.beans.XmlAttribute;
import com.googlecode.jmapper.xml.beans.XmlClass;
import com.googlecode.jmapper.xml.beans.XmlJmapper;

public class ConfigHelper <D, S> {
	
	/** destination class */
	private final Class<D> destinationClass;
	
	/** source class */
	private final Class<S> sourceClass;
	
	/** mapped class */
	private Class<?> mappedClass;
	
	/** xmlClass cached */
	private XmlClass xmlMappedClass;
	
	/**
	 * It converts the configuration from XML to XStream format.
	 * @param xml xml to convert
	 * @return Configuration in XStream format
	 */
	private static final XmlJmapper xmlToXStream(String xml){
		
		try {
			return new XML(true, xml).toXStream();
		} catch (Exception e) {
			//TODO lanciare exception
			JmapperLog.ERROR(e);
			throw new RuntimeException();
		}
	}
	
	/**
	 * It converts the configuration from Annotation to XML format.
	 * @param destinationClass destination class
	 * @param sourceClass source class
	 * @return the configuration in XML format
	 */
	private static final String annotationToXml(Class<?> destinationClass, Class<?> sourceClass){
		return null;
	}

	/**
	 * In case of nested mapping will be returned the last field name declared. 
	 * @param fieldName field name
	 * @return field name
	 */
	private static final String checkNestedMapping(String fieldName){
		
		if(isNestedMapping(fieldName)){
			String[] nestedFields = nestedFields(fieldName);
			return nestedFields[nestedFields.length-1];
		}
		
		return fieldName;
	}
	/**
	 * It permits to analyze the annotated configuration between destination and source classes.
	 * @param destinationClass destination class
	 * @param sourceClass source class
	 */
	public ConfigHelper(Class<D> destinationClass, Class<S> sourceClass) {
		this(destinationClass, sourceClass, annotationToXml(destinationClass, sourceClass));
	}
	
	/**
	 * It permits to analyze the XML configuration between destination and source classes.
	 * @param destinationClass destination class
	 * @param sourceClass source class
	 * @param xml xml (path or content as string) 
	 */
	public ConfigHelper(Class<D> destinationClass, Class<S> sourceClass, String xml) {
		this(destinationClass, sourceClass, xmlToXStream(xml));
	}
	
	/**
	 * It permits to analyze the API configuration between destination and source classes.
	 * @param destinationClass destination class
	 * @param sourceClass source class
	 * @param api configuration in API format
	 */
	public ConfigHelper(Class<D> destinationClass, Class<S> sourceClass, JMapperAPI api) {
		this(destinationClass, sourceClass, api.toXStream());
	}
	
	//TODO considerare le gerarchie
	private ConfigHelper(Class<D> destinationClass, Class<S> sourceClass, XmlJmapper root) {
		this.destinationClass = destinationClass;
		this.sourceClass = sourceClass;
		
		for (XmlClass xmlClass : root.classes) {
			if(xmlClass.name.equals(destinationClass.getName())){
				mappedClass = destinationClass;
				
			}
			
			if(isNull(mappedClass) && xmlClass.name.equals(sourceClass.getName())){
				mappedClass = sourceClass;
			}
				
			if(!isNull(mappedClass)) 
				xmlMappedClass = xmlClass;
		}
		
		if(isNull(mappedClass)){
			//TODO lanciare exception
			//nessuna delle due classi è configurata
		}
	}
	
	public String getSourceFieldName(final String destinationFieldName){
		
		    // if the mapped class is the destination class
			if(mappedClass.equals(destinationClass)){
				
				for (XmlAttribute xmlAttribute : xmlMappedClass.attributes) {
					
					// find between target fields the source field name
					if(!xmlAttribute.name.equals(destinationFieldName)) continue;

					if(isEmpty(xmlAttribute.classes)){
						//TODO lanciare exception
						// è obbligatorio definire le classi per verificare l'appartenza
						// oppure
						// se è destination a essere mappata, per sapere chi è il sourceField
						// devo poter fare una associazione con la source class
					}
					
					Integer targetClassIndex = null;
					for(int i = 0; i < xmlAttribute.classes.size(); i++)
						if(xmlAttribute.classes.get(i).name.equals(sourceClass.getName()))
							targetClassIndex = i;
						
					// if between target classes there isn't source class, thrown an exception
					if(isNull(targetClassIndex)){
						//TODO lanciare exception
						//classe source non configurata, impossibile recuperare il campo
					}
						
					// if there are attributes defined, returns the attribute in targetClassIndex position
					if(!isEmpty(xmlAttribute.attributes))
						return checkNestedMapping(xmlAttribute.attributes.get(targetClassIndex).name);
								
					// return the value content
					return checkNestedMapping(xmlAttribute.value.name);
					
				}
				
			// if the mapped class is the source class
			}else{
				
				String destinationField = checkNestedMapping(destinationFieldName);
				for (XmlAttribute xmlAttribute : xmlMappedClass.attributes) {
					
					if(isEmpty(xmlAttribute.classes)){
						//TODO lanciare exception
						// è obbligatorio definire le classi per verificare l'appartenza
						// oppure
						// se è destination a essere mappata, per sapere chi è il sourceField
						// devo poter fare una associazione con la source class
					}
					
					if(!isEmpty(xmlAttribute.attributes))
						for(int i = 0; i < xmlAttribute.attributes.size(); i++)
							if(  xmlAttribute.attributes.get(i).name.equals(destinationField)
							  && xmlAttribute.classes.get(i).name.equals(destinationClass.getName()))
								return xmlAttribute.name;
					
					if( xmlAttribute.value.name.equals(destinationField))
						for(int i = 0; i < xmlAttribute.classes.size(); i++)
					       if(xmlAttribute.classes.get(i).name.equals(destinationClass.getName()))
					    	   return xmlAttribute.name;
				}
				
			}
		
			//TODO lanciare exception
			// campo non trovato
		
		return "this return is never used";
	}
	
	public String getDestinationFieldName(final String sourceFieldName){
		
		// if the mapped class is the destination class
		if(mappedClass.equals(destinationClass)){
			
			String sourceField = checkNestedMapping(sourceFieldName);
			for (XmlAttribute xmlAttribute : xmlMappedClass.attributes) {
				
				if(isEmpty(xmlAttribute.classes)){
					//TODO lanciare exception 
					// è obbligatorio definire le classi per verificare l'appartenza
					// oppure
					// se è destination a essere mappata, per sapere chi è il sourceField
					// devo poter fare una associazione con la source class
				}
				
				if(!isEmpty(xmlAttribute.attributes))
					for(int i = 0; i < xmlAttribute.attributes.size(); i++)
						if(  xmlAttribute.attributes.get(i).name.equals(sourceField)
						  && xmlAttribute.classes.get(i).name.equals(destinationClass.getName()))
							return xmlAttribute.name;
				
				if( xmlAttribute.value.name.equals(sourceField))
					for(int i = 0; i < xmlAttribute.classes.size(); i++)
				       if(xmlAttribute.classes.get(i).name.equals(destinationClass.getName()))
				    	   return xmlAttribute.name;
			}
		
		// if the mapped class is the source class
		}else{
			
			for (XmlAttribute xmlAttribute : xmlMappedClass.attributes) {
				
				// find between target fields the source field name
				if(!xmlAttribute.name.equals(sourceFieldName)) continue;

				if(isEmpty(xmlAttribute.classes)){
					//TODO lanciare exception
					// è obbligatorio definire le classi per verificare l'appartenza
					// oppure
					// se è destination a essere mappata, per sapere chi è il sourceField
					// devo poter fare una associazione con la source class
				}
				
				Integer targetClassIndex = null;
				for(int i = 0; i < xmlAttribute.classes.size(); i++)
					if(xmlAttribute.classes.get(i).name.equals(sourceClass.getName()))
						targetClassIndex = i;
					
				// if between target classes there isn't source class, thrown an exception
				if(isNull(targetClassIndex)){
					//TODO lanciare exception
					//classe source non configurata, impossibile recuperare il campo
				}
					
				// if there are attributes defined, returns the attribute in targetClassIndex position
				if(!isEmpty(xmlAttribute.attributes))
					return checkNestedMapping(xmlAttribute.attributes.get(targetClassIndex).name);
							
				// return the value content
				return checkNestedMapping(xmlAttribute.value.name);
				
			}
		}
			
		//TODO lanciare exception
		// campo non trovato
	
		return "this return is never used";
	}

}
