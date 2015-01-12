package com.googlecode.jmapper.integrationtest;

import com.googlecode.jmapper.api.enums.MappingType;
import com.googlecode.jmapper.api.enums.NullPointerControl;

import com.googlecode.jmapper.integrationtest.mock.IMockDS;

/**
 *	
 * @author Alessandro Vurro
 * 
 * @param <D> Destination Instance
 * @param <S> Source Instance
 */
public abstract class AbstractDS<D,S> extends Abstract<D,S> implements IDS{

	@SuppressWarnings("incomplete-switch")
	private  D inputDestination(MappingType mtd, MappingType mts){
		switch (mtd){ 
			case ALL_FIELDS:			switch (mts){
				case ALL_FIELDS: 		return getMockDS().AllAll().inputDestination(); 
				case ONLY_VALUED_FIELDS:return getMockDS().AllValued().inputDestination();}break;
			case ONLY_VALUED_FIELDS:	switch (mts){
				case ALL_FIELDS:		return getMockDS().ValuedAll().inputDestination();
				case ONLY_VALUED_FIELDS:return getMockDS().ValuedValued().inputDestination();
				case ONLY_NULL_FIELDS:	return getMockDS().ValuedNull().inputDestination();}break;
			case ONLY_NULL_FIELDS:	switch (mts){
				case ONLY_VALUED_FIELDS:return getMockDS().NullValued().inputDestination();}break;
		}
		return null;
	}
	
	public abstract IMockDS<D,S> getMockDS();
	
	/*
	 * 			WITHOUT CONTROL
	 * 
	 * 			MappingType-D		ALL
	 * 			MappingType-S		ALL
	 * */
	public void testAllAllWithoutControl() {
		outputDestination = getMockDS().AllAll().outputDestination();
		inputDestination = getMockDS().AllAll().inputDestination();
		source = getMockDS().AllAll().source();
	
		destination = mapper.getDestinationWithoutControl(inputDestination,source);
		verify("vVAllAllAll -> getDestinationWithoutControl(inputDestination,source)");
	}
	
	/*
	 * 			MappingType-D		ALL
	 * 			MappingType-S		ALL
	 * */
	public final void testAllAll(){
		outputDestination = getMockDS().AllAll().outputDestination();
		inputDestination = getMockDS().AllAll().inputDestination();
		source = getMockDS().AllAll().source();
		
		destination = mapper.getDestination(inputDestination,source);
//		System.out.println(destination);
		verify("vVAllAllAll -> getDestination(inputDestination,source)");
	}
	
	/*
	 * 			MappingType-D		ALL
	 * 			MappingType-S		VALUED
	 * */
	public final void testAllValued(){
		outputDestination = getMockDS().AllValued().outputDestination();
		inputDestination = getMockDS().AllValued().inputDestination();
		source = getMockDS().AllValued().source();
		
		npcWithMappingType(allFields, valuedFields);
	}
	
	/*
	 * 			MappingType-D		VALUED
	 * 			MappingType-S		NULL
	 * */
	public final void testValuedNull(){
		outputDestination = getMockDS().ValuedNull().outputDestination();
		inputDestination = getMockDS().ValuedNull().inputDestination();
		source = getMockDS().ValuedNull().source();
		
		npcWithMappingType(valuedFields, nullFields);
	}
	
	/*
	 * 			MappingType-D		VALUED
	 * 			MappingType-S		ALL
	 * */	
	public final void testValuedAll(){
		outputDestination = getMockDS().ValuedAll().outputDestination();
		inputDestination = getMockDS().ValuedAll().inputDestination();
		source = getMockDS().ValuedAll().source();
		
		npcWithMappingType(valuedFields, allFields);
	}
	
	/*
	 * 			MappingType-D		VALUED
	 * 			MappingType-S		VALUED
	 * */	
	public final void testValuedValued(){
		outputDestination = getMockDS().ValuedValued().outputDestination();
		inputDestination = getMockDS().ValuedValued().inputDestination();
		source = getMockDS().ValuedValued().source();
		
		npcWithMappingType(valuedFields, valuedFields);
	}
	
	/*
	 * 			MappingType-D		NULL
	 * 			MappingType-S		VALUED
	 * */
	public final void testNullValued(){
		outputDestination = getMockDS().NullValued().outputDestination();
		inputDestination = getMockDS().NullValued().inputDestination();
		source = getMockDS().NullValued().source();
		
		npcWithMappingType(nullFields, valuedFields);
	}

	public void testNullInputObject() {
		outputDestination = null;
		S sourceNull = null;
		D destNull = null;
		inputDestination = getMockDS().NullInputObject().inputDestination();
		source = getMockDS().NullInputObject().source();
		
		destination = mapper.getDestination(inputDestination,sourceNull);
		verify("destination isn't null -> getDestination(inputDestination,null)");
		
		destination = mapper.getDestination(destNull,source);
		verify("destination isn't null -> getDestination(null,source)");
		
		verifyNullPointerAndMappingTypes();
	}
	
	private void verifyNullPointerAndMappingTypes(){
		for(int obj = 0; obj < 2; obj ++){
			
			if(obj == 0){
				inputDestination = getMockDS().NullInputObject().inputDestination();
				source = null;
			}else{
				inputDestination = null;
				source = getMockDS().NullInputObject().source();
			}
			
			for (int mts = 0; mts < mpValues.length; mts++)
				for (int mtd = 0; mtd < mpValues.length; mtd++)
					for (int npc = 0; npc < npcValues.length; npc++) {
										
						// se non ci sono controlli di alcun tipo va in null pointer exception
						if(npcValues[npc]==NullPointerControl.NOT_ANY)continue;
						
						// se source è NULL e npc è DESTINATION va in null pointer exception sul source
						if(npcValues[npc]==NullPointerControl.DESTINATION && source == null)continue;
						
						// se inputDestination è NULL e npc è SOURCE va in null pointer exception sul destination
						if(npcValues[npc]==NullPointerControl.SOURCE && inputDestination == null)continue;
						
						// se entrambi i mapping type sono only null fields 
						// allora viene restituito il destination passato in input
						outputDestination = mpValues[mtd] == MappingType.ONLY_NULL_FIELDS && 
										    mpValues[mts] == MappingType.ONLY_NULL_FIELDS? inputDestination : null;
						
						destination = mapper.getDestination(inputDestination,source,npcValues[npc],mpValues[mtd],mpValues[mts]);
						verify("destination isn't null -> getDestination(inputDestination,source,"+npcValues[npc]+","+mpValues[mtd]+","+mpValues[mts]+")");
					}
			
		}
	}
	
	private void npcWithMappingType(MappingType mtd,MappingType mts){
		for(int i = 0; i < npcValues.length; i++){
			destination = mapper.getDestination(inputDestination(mtd,mts),source,npcValues[i],mtd,mts);
			verify(getMessage(npcValues[i],mtd,mts));
		}
	}
	
	private String getMessage(NullPointerControl npc,MappingType mtd,MappingType mts){
		return "vV"+this.npc.get(npc)+this.mt.get(mtd)+this.mt.get(mts)+" -> getDestination(inputDestination, source, "+npc+", "+mts+", "+mtd+")";
	}

	
}
