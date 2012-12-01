/**
 * Copyright (C) 2012 Alessandro Vurro.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.avutils.jmapper.operations.info;

import it.avutils.jmapper.enums.ChooseConfig;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.enums.OperationType;

/**
 * InfoOperation represents the operation to be performed, taking with him such information as:<br>
 * the type of operation, the conversion type and configuration to be analyzed.
 * @author Alessandro Vurro
 *
 */
public class InfoOperation {

	private OperationType instructionType;
	private ConversionType conversionType;
	private ChooseConfig configChosen;
	
	public InfoOperation setConfigChosen(ChooseConfig configChosen) {
		this.configChosen = configChosen;
		return this;
	}
	public InfoOperation setInstructionType(OperationType instructionType) {
		this.instructionType = instructionType;
		return this;
	}
	public InfoOperation setConversionType(ConversionType conversionType) {
		this.conversionType = conversionType;
		return this;
	}
	
	public ChooseConfig getConfigChosen() {			return configChosen;	}
	public OperationType getInstructionType() {	return instructionType;	}
	public ConversionType getConversionType() {	return conversionType;	}
	
	/**
	 * @param instructionType
	 * @param conversionType
	 */
	public InfoOperation(OperationType instructionType, ConversionType conversionType) {
		super();
		this.instructionType = instructionType;
		this.conversionType = conversionType;
	}
	
	public InfoOperation() {}
	
	/**
	 * @param instructionType
	 * @param conversionType
	 * @param configChosen
	 * @param mapOperation
	 */
	public InfoOperation(OperationType instructionType, ConversionType conversionType, ChooseConfig configChosen,
			InfoMapOperation mapOperation) {
		super();
		this.instructionType = instructionType;
		this.conversionType = conversionType;
		this.configChosen = configChosen;
	}
	
	
}
