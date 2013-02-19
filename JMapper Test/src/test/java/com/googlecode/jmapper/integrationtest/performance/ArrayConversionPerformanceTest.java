package com.googlecode.jmapper.integrationtest.performance;

import com.googlecode.jmapper.integrationtest.Performance;
import com.googlecode.jmapper.integrationtest.config.Constants;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayConversionD;
import com.googlecode.jmapper.integrationtest.operations.bean.ArrayConversionS;

public class ArrayConversionPerformanceTest extends
		Performance<ArrayConversionD, ArrayConversionS> {

	@Override
	protected ArrayConversionD staticMapping(ArrayConversionS source) {
		   ArrayConversionD destination = new ArrayConversionD();
		   if(source.getSInteger()!=null){
			   Integer[] sourceArray = source.getSInteger();
			   String[] destinationArray = new String[sourceArray.length];
			   for(int i = 0; i < sourceArray.length;i++){
				   Integer sourceItem = (Integer) sourceArray[i];
				   String destinationItem = sourceItem.toString();
				   destinationArray[i] = destinationItem;
			   }
			   destination.setDString(destinationArray);
		   }
		   if(source.getSString()!=null){
			   String[] sourceArray = source.getSString();
			   Integer[] destinationArray = new Integer[sourceArray.length];
			   for(int i = 0; i < sourceArray.length;i++){
				   String sourceItem = (String) sourceArray[i];
				   Integer destinationItem = new Integer(sourceItem);
				   destinationArray[i] = destinationItem;
			   }
			   destination.setDInteger(destinationArray);
		   }
		   if(source.getSInt()!=null){
			   int[] sourceArray = source.getSInt();
			  Double[] destinationArray = new Double[sourceArray.length];
			   for(int i = 0; i < sourceArray.length;i++){
				   int sourceItem = (int) sourceArray[i];
				   Double destinationItem = new Double((double) sourceItem);
				   destinationArray[i] = destinationItem;
			   }
			   destination.setDCharacter(destinationArray);
		   }
		   return destination;
	}

	@Override
	protected ArrayConversionS getSource() {
		return new ArrayConversionS(new Integer[]{5003},new String[]{"5003"},new int[]{2});
	}

	@Override
	protected int getInternalWeight() {
		return 250000;
	}

	@Override
	protected String titleOfTest() {
		return Constants.ArrayConversionPerformanceTest;
	}

}
