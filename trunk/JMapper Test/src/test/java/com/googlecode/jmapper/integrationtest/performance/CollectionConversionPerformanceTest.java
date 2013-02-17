package com.googlecode.jmapper.integrationtest.performance;

import java.util.ArrayList;
import java.util.Collection;

import com.googlecode.jmapper.integrationtest.Performance;
import com.googlecode.jmapper.integrationtest.config.Constants;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.CollectionConversionS;

public class CollectionConversionPerformanceTest extends
		Performance<CollectionConversionD, CollectionConversionS> {

	@Override
	protected CollectionConversionD staticMapping(CollectionConversionS source) {
		
		   CollectionConversionD destination = new CollectionConversionD();
		   
		   if(source.getSourceListInteger()!=null){
			   ArrayList<String> destinationList = new ArrayList<String>();
			   for (Integer sourceItem : source.getSourceListInteger()) {
				   destinationList.add(sourceItem.toString());
			   }
			   destination.setDestListString(destinationList);
		   }
		   
		   if(source.getSourceListString()!=null){
			   ArrayList<Integer> destinationList = new ArrayList<Integer>();
			   for (String sourceItem : source.getSourceListString()) {
				   destinationList.add(new Integer(sourceItem));
			   }
			   destination.setDestListInteger(destinationList);
		   }

		   return destination;
	}

	@Override
	protected CollectionConversionS getSource() {
		return new CollectionConversionS(add(new ArrayList<Integer>(),1,2), 
				 add(new ArrayList<String>(),"3","4"));
	}

	@Override
	protected int getInternalWeight() {
		return 20000;
	}

	@Override
	protected String titleOfTest() {
		return Constants.CollectionConversionPerformanceTest;
	}

	protected <T extends Collection<E>,E> T  add(T collection,E...elements ){
		for (E element : elements)	collection.add(element);
		return collection;
	}
}
