package com.googlecode.jmapper.integrationtest;

import java.util.HashMap;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.MappingType;
import com.googlecode.jmapper.enums.NullPointerControl;

import junit.framework.TestCase;
/**
 * @author Alessandro Vurro
 *
 */
public abstract class Abstract<D,S> extends TestCase{

	/**	input for JMapper */
	public D inputDestination;
	
	/**	expected result */
	public D outputDestination;
	
	/** obtained result */
	public D destination;
	
	/** input for JMapper */
	public S source;
	
	public JMapper<D,S> mapper;
	
	public final NullPointerControl[] npcValues = NullPointerControl.values();
	public final NullPointerControl notAnyControl = NullPointerControl.NOT_ANY;
	public final NullPointerControl allControl = NullPointerControl.ALL;
	public final NullPointerControl destinationControl = NullPointerControl.DESTINATION;
	public final NullPointerControl sourceControl = NullPointerControl.SOURCE;
	public final HashMap<NullPointerControl, String> npc;
	
	public final MappingType[] mpValues = MappingType.values();
	public final MappingType allFields = MappingType.ALL_FIELDS;
	public final MappingType valuedFields = MappingType.ONLY_VALUED_FIELDS;
	public final MappingType nullFields = MappingType.ONLY_NULL_FIELDS;
	public final HashMap<MappingType, String> mt;
	
	public Abstract() {
		npc = new HashMap<NullPointerControl, String>();
		mt = new HashMap<MappingType, String>();
		
		npc.put(allControl, "All");
		npc.put(sourceControl, "Sou");
		npc.put(destinationControl, "Des");
		npc.put(notAnyControl, "Not");
		
		mt.put(allFields, "All");
		mt.put(valuedFields, "Valued");
		mt.put(nullFields, "Null");
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mapper = getJMapper();
	}
	
	public final void verify(String str){ 
		assertEquals(str,outputDestination,destination); 
	}
	
	public abstract JMapper<D,S> getJMapper();
	
}
