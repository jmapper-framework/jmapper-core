package com.googlecode.jmapper.operations;

import static com.googlecode.jmapper.util.ClassesManager.retrieveField;
import com.googlecode.jmapper.bean.Fields;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.enums.OperationType;
import com.googlecode.jmapper.operations.info.InfoMapOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.util.XML;

import junit.framework.TestCase;

public class OperationAnalyzerTest extends TestCase {

	public void testBasicInstruction() throws ClassNotFoundException{
		
		// instructions where fields are equal
		verifyInstructionType(OperationType.BASIC_INSTRUCTION,Fields.primitiveTypes);
		verifyInstructionType(OperationType.BASIC_INSTRUCTION,Fields.wrapperTypes);
		// instructions where source class is an extensions of destination class
	}
	
	public void testMappingInstruction() throws ClassNotFoundException{
		verifyInstructionType(OperationType.OBJECT,Fields.mappedObj,Fields.targetObj);
		verifyInstructionType(OperationType.OBJECT,Fields.mappedObj,Fields.extendsMappedObj);
	}
	
	public void testArrayInstruction() throws ClassNotFoundException{
		// if destination field is assignable from source field
		verifyInstructionType(OperationType.ARRAY,Fields.arrayTypes);
		//instructions where destination field is assignable from source field
		verifyInstructionType(OperationType.ARRAY,Fields.arrayTypes,Fields.implArrayTypes);
	}
	
	public void testArrayConversion(){
		verifyConversionType(ConversionType.FromStringToint, "intArray", "strArray");
		verifyConversionType(ConversionType.FromintToString, "strArray", "intArray");
		verifyConversionType(ConversionType.FromStringToInteger, "integerArray", "strArray");
		verifyConversionType(ConversionType.FromIntegerToString, "strArray", "integerArray");
		
	}
	
	public void testArrayListInstruction() throws ClassNotFoundException{
	
		verifyInstructionType(OperationType.ARRAY_LIST, "strArray", "aList2");
		verifyConversionType(ConversionType.ABSENT, "strArray", "aList2");
		
		verifyInstructionType(OperationType.LIST_ARRAY, "aList2", "strArray");
		verifyConversionType(ConversionType.ABSENT, "aList2", "strArray");
		
		verifyConversionType(ConversionType.FromStringToint, "intArray", "aList2");
		verifyConversionType(ConversionType.FromintToString, "aList2", "intArray");
		
		verifyInstructionType(OperationType.LIST_ARRAY_WITH_MAPPED_ITEMS, "aLinkedList2", "mappedArray");
		verifyInstructionType(OperationType.ARRAY_LIST_WITH_MAPPED_ITEMS, "mappedArray", "aLinkedList2");
		
	}
	
	public void testCollectionInstruction() throws ClassNotFoundException{
		
		// if destination field is assignable from source field
		verifyInstructionType(OperationType.COLLECTION,Fields.collectionTypes);
		verifyInstructionType(OperationType.COLLECTION,Fields.collectionTypes,Fields.implCollectionTypes);
		// if fields are collections but with different structure ( ArrayList<?> <-> HashSet<?> for example) 
		verifyInstructionType(OperationType.COLLECTION,Fields.diffImplCollectionTypes,Fields.implCollectionTypes);
		// if fields are collections but with different items ( ArrayList<String> <-> HashSet<Integer> for example) 
		verifyInstructionType(OperationType.COLLECTION,Fields.collections,Fields.collections2);
	}
	
	public void testCollectionConversion(){
		verifyConversionType(ConversionType.FromLongToString, "aList2", "aArrayList2");
		verifyConversionType(ConversionType.FromIntegerToString, "aHashSet3", "aLinkedList3");
		verifyConversionType(ConversionType.FromStringToInteger, "aLinkedList3", "aHashSet3");
		
	}
	
	public void testMapInstruction() throws ClassNotFoundException{
		// if destination field is assignable from source field
		verifyInstructionType(OperationType.MAP,Fields.mapTypes);
		verifyInstructionType(OperationType.MAP,Fields.mapTypes,Fields.implMapTypes);
		// if fields are maps but with different structure ( HashMap<String,Integer>, TreeMap<String,Integer> for example) 
		verifyInstructionType(OperationType.MAP,Fields.diffImplMapTypes,Fields.implMapTypes);
		// if fields are maps but with different items ( HashMap<String,Integer>, TreeMap<Integer,String> for example) 
		verifyInstructionType(OperationType.MAP,Fields.maps,Fields.maps2);
	}
	
	public void testMapConversion(){
		verifyConversionPair(ConversionType.FromIntegerToString, ConversionType.FromStringToInteger, "aMap", "aSortedMap");
	}
	
	public void testRecursiveCollectionInstruction() throws ClassNotFoundException{		
		// if items are mapped objects
		verifyInstructionType(OperationType.COLLECTION_WITH_MAPPED_ITEMS,Fields.mappedCollections,Fields.targetCollections);
		verifyInstructionType(OperationType.MAP_WITH_MAPPED_ITEMS,Fields.mappedMaps,Fields.targetMaps);
		verifyInstructionType(OperationType.ARRAY_WITH_MAPPED_ITEMS,Fields.mappedArrays,Fields.targetArrays);
	}
	
	public void testVerifyItems()throws ClassNotFoundException{
		verifyInstructionType(OperationType.COLLECTION,new String[]{"list"});
	}
	
	private void verifyInstructionType(OperationType instructionTypes, String type, String type2) throws ClassNotFoundException{
		Field typeField = retrieveField(Fields.class, type);
		Field typeField2 = retrieveField(Fields.class, type2);
		OperationType operationType = new OperationAnalyzer(new XML()).getInfoOperation(typeField, typeField2).getInstructionType();
		assertEquals("destination field: "+type+" source field: "+type2,instructionTypes, operationType);
	}
	private void verifyInstructionType(OperationType instructionTypes, String[] types) throws ClassNotFoundException{
		verifyInstructionType(instructionTypes,types,types);
	}
	private void verifyInstructionType(OperationType instructionTypes, String[] types, String[] implTypes) throws ClassNotFoundException{
		for(int i = 0; i < types.length;i++)
			verifyInstructionType(instructionTypes,types[i],implTypes[i]);
	}
	private void verifyConversionType(ConversionType expected, String field, String field2){
		Field typeField = retrieveField(Fields.class, field);
		Field typeField2 = retrieveField(Fields.class, field2);
		ConversionType actual = new OperationAnalyzer(new XML()).getInfoOperation(typeField, typeField2).getConversionType();
		assertEquals(expected, actual);
	}
	private InfoOperation getInfo(String field, String field2){
		Field typeField = retrieveField(Fields.class, field);
		Field typeField2 = retrieveField(Fields.class, field2);
		return new OperationAnalyzer(new XML()).getInfoOperation(typeField, typeField2);
	}
	private void verifyConversionPair(ConversionType expectedKey, ConversionType expectedValue,String field, String field2){
		InfoMapOperation info = (InfoMapOperation) getInfo(field,field2);
		assertEquals(expectedKey, info.getKeyConversionType());
		assertEquals(expectedValue, info.getValueConversionType());
			
	}
}
