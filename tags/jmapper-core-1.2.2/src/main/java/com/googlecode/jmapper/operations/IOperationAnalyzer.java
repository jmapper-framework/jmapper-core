package com.googlecode.jmapper.operations;

import java.lang.reflect.Field;

import com.googlecode.jmapper.operations.info.InfoOperation;

public interface IOperationAnalyzer {

	/**
	 * This method calculates and returns information relating the operation to be performed.
	 * @param destination destination field to be analyzed
	 * @param source source field to be analyzed
	 * @return all information relating the operation to be performed
	 */
	public InfoOperation getInfoOperation(final Field destination, final Field source);
	
	/**
	 * this method verifies if there are the conditions to elaborate the operation info.
	 * @param destination destination field to be analyzed
	 * @param source source field to be analyzed
	 * @return all information relating the operation to be performed
	 */
	public boolean verifyConditions(final Field destination, final Field source);
}
