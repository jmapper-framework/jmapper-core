package com.googlecode.jmapper.integrationtest;

import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.api.enums.NullPointerControl;

import com.googlecode.jmapper.integrationtest.mock.IMockS;
import com.googlecode.jmapper.integrationtest.Abstract;
import com.googlecode.jmapper.integrationtest.IS;

/**
 * @author Alessandro Vurro
 * 
 * @param <D> Destination Instance
 * @param <S> Source Instance
 */
public abstract class AbstractS<D,S> extends Abstract<D,S> implements IS{
	
	public abstract IMockS<D,S> getMockS();
	/*	  
	 * 			WITHOUT CONTROL
	 * 
	 * 			MappingType-D		ALL
	 * 			MappingType-S		ALL
	 * */
	public final void testAllAllWithoutControl(){
		
		outputDestination = getMockS().AllAll().outputDestination();
		source = getMockS().AllAll().source();
		
		destination = mapper.getDestinationWithoutControl(source);
		verify("nullVNotAllAll -> getDestinationWithoutControl(source)");
	}

	/*			MappingType-D		ALL
	 * 			MappingType-S		ALL
	 * */
	public final void testAllAll(){
		
		outputDestination = getMockS().AllAll().outputDestination();
		source = getMockS().AllAll().source();
		
		destination = mapper.getDestination(source);
		verify("nullVSouAllAll -> getDestination(source)");
		
		destination = mapper.getDestination(source,allFields);
		verify("NullVSouAllAll -> getDestination(source, "+allFields+")");
		
		npcWithMappingType(allFields);
	}
	
	/*	
	 * 			MappingType-D		ALL
	 * 			MappingType-S		VALUED
	 * */
	public final void testAllValued(){
		
		outputDestination = getMockS().AllValued().outputDestination();
		source = getMockS().AllValued().source();
		
		npcWithMappingType(valuedFields);
	}
	
	/*	
	 * 			MappingType-D		ALL
	 * 			MappingType-S		NULL
	 * */
	public final void testAllNull(){
		
		outputDestination = getMockS().AllNull().outputDestination();
		source = getMockS().AllNull().source();
		
		npcWithMappingType(nullFields);
	}
	
	/*	
	 * 			Destination		NULL
	 * 			Source			NULL
	 * */
	public final void testNullInputObject(){
		outputDestination = null;
		
		destination = mapper.getDestination(null);
		verify("destination isn't null -> getDestination(null)");
		
		verifyMappingTypes();
		verifyNullPointerAndMappingTypes();
	}
	
	private void verifyMappingTypes(){
		for (int i = 0; i < mpValues.length; i++) {
			destination = mapper.getDestination(null,mpValues[i]);
			verify("destination isn't null -> getDestination(null,"+mpValues[i]+")");
		}
	}
	
	private void verifyNullPointerAndMappingTypes(){
		for (int i = 0; i < mpValues.length; i++) {
			for (int j = 0; j < npcValues.length; j++) {
				
				// se source � NULL e non ci sono controlli di alcun tipo va in null pointer exception
				if(npcValues[j]==NullPointerControl.NOT_ANY)continue;
				
				destination = mapper.getDestination(null,npcValues[j],mpValues[i]);
				verify("destination isn't null -> getDestination(null,"+npcValues[j]+","+mpValues[i]+")");
			}
		}
	}
	
	private void npcWithMappingType(MappingType mt){
		for(int i = 0; i < npcValues.length; i++){
			destination = mapper.getDestination(source,npcValues[i],mt);
			verify(getMessage(npcValues[i],mt));
		}
	}
	
	private String getMessage(NullPointerControl npc,MappingType mts){
		return "NullV"+this.npc.get(npc)+this.mt.get(allFields)+this.mt.get(mts)+" -> getDestination(source, "+npc+", "+mts+")";
	}
	
	
}
