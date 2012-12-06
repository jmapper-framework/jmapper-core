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
 * InfoMapOperation represents the operation to be performed, taking with him such information as:<br>
 * the key type of operation.<br>
 * the key conversion type.<br> 
 * the key configuration to be analyzed.<br>
 * the value type of operation.<br>
 * the value conversion type.<br> 
 * the value configuration to be analyzed.<br>
 * 
 * @author Alessandro Vurro
 *
 */
public class InfoMapOperation extends InfoOperation{

	OperationType keyInstructionType;
	ConversionType keyConversionType;
	ChooseConfig keyConfigChosen;
	OperationType valueInstructionType;
	ConversionType valueConversionType;
	ChooseConfig valueConfigChosen;
	
	public InfoMapOperation() {}
	/**
	 * @param keyInstructionType
	 * @param keyConversionType
	 * @param keyConfigChosen
	 * @param valueInstructionType
	 * @param valueConversionType
	 * @param valueConfigChosen
	 */
	public InfoMapOperation(OperationType keyInstructionType,
			ConversionType keyConversionType, ChooseConfig keyConfigChosen,
			OperationType valueInstructionType,
			ConversionType valueConversionType, ChooseConfig valueConfigChosen) {
		super();
		this.keyInstructionType = keyInstructionType;
		this.keyConversionType = keyConversionType;
		this.keyConfigChosen = keyConfigChosen;
		this.valueInstructionType = valueInstructionType;
		this.valueConversionType = valueConversionType;
		this.valueConfigChosen = valueConfigChosen;
	}
	
	public void keyValueUndefined(){
		keyInstructionType = OperationType.UNDEFINED;
		keyConversionType = ConversionType.UNDEFINED;
		valueInstructionType = OperationType.UNDEFINED;
		valueConversionType = ConversionType.UNDEFINED;
	}
	
	public OperationType getKeyInstructionType() {
		return keyInstructionType;
	}
	public InfoMapOperation setKeyInstructionType(OperationType keyInstructionType) {
		this.keyInstructionType = keyInstructionType;return this;
	}
	public ConversionType getKeyConversionType() {
		return keyConversionType;
	}
	public InfoMapOperation setKeyConversionType(ConversionType keyConversionType) {
		this.keyConversionType = keyConversionType;return this;
	}
	public ChooseConfig getKeyConfigChosen() {
		return keyConfigChosen;
	}
	public InfoMapOperation setKeyConfigChosen(ChooseConfig keyConfigChosen) {
		this.keyConfigChosen = keyConfigChosen;return this;
	}
	public OperationType getValueInstructionType() {
		return valueInstructionType;
	}
	public InfoMapOperation setValueInstructionType(OperationType valueInstructionType) {
		this.valueInstructionType = valueInstructionType;return this;
	}
	public ConversionType getValueConversionType() {
		return valueConversionType;
	}
	public InfoMapOperation setValueConversionType(ConversionType valueConversionType) {
		this.valueConversionType = valueConversionType;return this;
	}
	public ChooseConfig getValueConfigChosen() {
		return valueConfigChosen;
	}
	public InfoMapOperation setValueConfigChosen(ChooseConfig valueConfigChosen) {
		this.valueConfigChosen = valueConfigChosen;return this;
	}
	
	
}
