/**
 * Copyright (C) 2012 - 2015 Alessandro Vurro.
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

package com.googlecode.jmapper.conversions.implicit;

import static com.googlecode.jmapper.conversions.implicit.ConversionMethod.*;

import com.googlecode.jmapper.enums.ConversionType;
/**
 * This Class handles conversion between primitive and wrapper types.
 * 
 * @author Alessandro Vurro
 *
 */
public final class ConversionHandler {

	/**
	 * Returns a String that contains a literal conversion from source to destination defined from conversionType parameter.
	 * 
	 * @param conversionType defines the conversion type
	 * @param src source to be transformed in destination
	 * @return a string containing the transformation
	 */
	public static String getConversion(final ConversionType conversionType,final Object src){
		String source = src instanceof StringBuilder?((StringBuilder) src).toString():src instanceof String?(String) src:null;
		
		switch(conversionType){
		case FromByteToString:			return FromByteToString(source);
		case FrombyteToString:			return FrombyteToString(source);
		case FromShortToString:			return FromShortToString(source);
		case FromshortToString:			return FromshortToString(source);
		case FromIntegerToString:		return FromIntegerToString(source);
		case FromintToString:			return FromintToString(source);
		case FromLongToString:			return FromLongToString(source);
		case FromlongToString:			return FromlongToString(source);
		case FromFloatToString:			return FromFloatToString(source);
		case FromfloatToString:			return FromfloatToString(source);
		case FromDoubleToString:		return FromDoubleToString(source);
		case FromdoubleToString:		return FromdoubleToString(source);
		case FromCharacterToString:		return FromCharacterToString(source);
		case FromcharToString:			return FromcharToString(source);
		case FromBooleanToString:		return FromBooleanToString(source);
		case FrombooleanToString:		return FrombooleanToString(source);
		                            	                                                    
		case FromStringToByte:			return FromStringToByte(source);
		case FromShortToByte:			return FromShortToByte(source);
		case FromshortToByte:			return FromshortToByte(source);
		case FromIntegerToByte:			return FromIntegerToByte(source);
		case FromintToByte:				return FromintToByte(source);
		case FromLongToByte:			return FromLongToByte(source);
		case FromlongToByte:			return FromlongToByte(source);
		case FromFloatToByte:			return FromFloatToByte(source);
		case FromfloatToByte:			return FromfloatToByte(source);
		case FromDoubleToByte:			return FromDoubleToByte(source);
		case FromdoubleToByte:			return FromdoubleToByte(source);
		case FromCharacterToByte:		return FromCharacterToByte(source);
		case FromcharToByte:			return FromcharToByte(source);
		case FromBooleanToByte:			return FromBooleanToByte(source);
		case FrombooleanToByte:			return FrombooleanToByte(source);
		                            	                                                    
		case FromStringTobyte:			return FromStringTobyte(source);
		case FromShortTobyte:			return FromShortTobyte(source);
		case FromshortTobyte:			return FromshortTobyte(source);
		case FromIntegerTobyte:			return FromIntegerTobyte(source);
		case FromintTobyte:				return FromintTobyte(source);
		case FromLongTobyte:			return FromLongTobyte(source);
		case FromlongTobyte:			return FromlongTobyte(source);
		case FromFloatTobyte:			return FromFloatTobyte(source);
		case FromfloatTobyte:			return FromfloatTobyte(source);
		case FromDoubleTobyte:			return FromDoubleTobyte(source);
		case FromdoubleTobyte:			return FromdoubleTobyte(source);
		case FromCharacterTobyte:		return FromCharacterTobyte(source);
		case FromcharTobyte:			return FromcharTobyte(source);
		case FromBooleanTobyte:			return FromBooleanTobyte(source);
		case FrombooleanTobyte:			return FrombooleanTobyte(source);
			                        		                                                
		case FromStringToShort:			return FromStringToShort(source);
		case FromByteToShort:			return FromByteToShort(source);
		case FrombyteToShort:			return FrombyteToShort(source);
		case FromIntegerToShort:		return FromIntegerToShort(source);
		case FromintToShort:			return FromintToShort(source);
		case FromLongToShort:			return FromLongToShort(source);
		case FromlongToShort:			return FromlongToShort(source);
		case FromFloatToShort:			return FromFloatToShort(source);
		case FromfloatToShort:			return FromfloatToShort(source);
		case FromDoubleToShort:			return FromDoubleToShort(source);
		case FromdoubleToShort:			return FromdoubleToShort(source);
		case FromCharacterToShort:		return FromCharacterToShort(source);
		case FromcharToShort:			return FromcharToShort(source);
		case FromBooleanToShort:		return FromBooleanToShort(source);
		case FrombooleanToShort:		return FrombooleanToShort(source);
		                            	                                                    
		case FromStringToshort:			return FromStringToshort(source);
		case FromByteToshort:			return FromByteToshort(source);
		case FrombyteToshort:			return FrombyteToshort(source);
		case FromIntegerToshort:		return FromIntegerToshort(source);
		case FromintToshort:			return FromintToshort(source);
		case FromLongToshort:			return FromLongToshort(source);
		case FromlongToshort:			return FromlongToshort(source);
		case FromFloatToshort:			return FromFloatToshort(source);
		case FromfloatToshort:			return FromfloatToshort(source);
		case FromDoubleToshort:			return FromDoubleToshort(source);
		case FromdoubleToshort:			return FromdoubleToshort(source);
		case FromCharacterToshort:		return FromCharacterToshort(source);
		case FromcharToshort:			return FromcharToshort(source);
		case FromBooleanToshort:		return FromBooleanToshort(source);
		case FrombooleanToshort:		return FrombooleanToshort(source);
		                            	                                                    
		case FromStringToInteger:		return FromStringToInteger(source);
		case FromByteToInteger:			return FromByteToInteger(source);
		case FrombyteToInteger:			return FrombyteToInteger(source);
		case FromShortToInteger:		return FromShortToInteger(source);
		case FromshortToInteger:		return FromshortToInteger(source);
		case FromLongToInteger:			return FromLongToInteger(source);
		case FromlongToInteger:			return FromlongToInteger(source);
		case FromFloatToInteger:		return FromFloatToInteger(source);
		case FromfloatToInteger:		return FromfloatToInteger(source);
		case FromDoubleToInteger:		return FromDoubleToInteger(source);
		case FromdoubleToInteger:		return FromdoubleToInteger(source);
		case FromCharacterToInteger:	return FromCharacterToInteger(source);
		case FromcharToInteger:			return FromcharToInteger(source);
		case FromBooleanToInteger:		return FromBooleanToInteger(source);
		case FrombooleanToInteger:		return FrombooleanToInteger(source);
		                            	                                                    
		case FromStringToint:			return FromStringToint(source);
		case FromByteToint:				return FromByteToint(source);
		case FrombyteToint:				return FrombyteToint(source);
		case FromShortToint:			return FromShortToint(source);
		case FromshortToint:			return FromshortToint(source);
		case FromLongToint:				return FromLongToint(source);
		case FromlongToint:				return FromlongToint(source);
		case FromFloatToint:			return FromFloatToint(source);
		case FromfloatToint:			return FromfloatToint(source);
		case FromDoubleToint:			return FromDoubleToint(source);
		case FromdoubleToint:			return FromdoubleToint(source);
		case FromCharacterToint:		return FromCharacterToint(source);
		case FromcharToint:				return FromcharToint(source);
		case FromBooleanToint:			return FromBooleanToint(source);
		case FrombooleanToint:			return FrombooleanToint(source);
		                            	                                                    
		case FromStringToLong:			return FromStringToLong(source);
		case FromByteToLong:			return FromByteToLong(source);
		case FrombyteToLong:			return FrombyteToLong(source);
		case FromShortToLong:			return FromShortToLong(source);
		case FromshortToLong:			return FromshortToLong(source);
		case FromIntegerToLong:			return FromIntegerToLong(source);
		case FromintToLong:				return FromintToLong(source);
		case FromFloatToLong:			return FromFloatToLong(source);
		case FromfloatToLong:			return FromfloatToLong(source);
		case FromDoubleToLong:			return FromDoubleToLong(source);
		case FromdoubleToLong:			return FromdoubleToLong(source);
		case FromCharacterToLong:		return FromCharacterToLong(source);
		case FromcharToLong:			return FromcharToLong(source);
		case FromBooleanToLong:			return FromBooleanToLong(source);
		case FrombooleanToLong:			return FrombooleanToLong(source);
		                            	                                                    
		case FromStringTolong:			return FromStringTolong(source);
		case FromByteTolong:			return FromByteTolong(source);
		case FrombyteTolong:			return FrombyteTolong(source);
		case FromShortTolong:			return FromShortTolong(source);
		case FromshortTolong:			return FromshortTolong(source);
		case FromIntegerTolong:			return FromIntegerTolong(source);
		case FromintTolong:				return FromintTolong(source);
		case FromFloatTolong:			return FromFloatTolong(source);
		case FromfloatTolong:			return FromfloatTolong(source);
		case FromDoubleTolong:			return FromDoubleTolong(source);
		case FromdoubleTolong:			return FromdoubleTolong(source);
		case FromCharacterTolong:		return FromCharacterTolong(source);
		case FromcharTolong:			return FromcharTolong(source);
		case FromBooleanTolong:			return FromBooleanTolong(source);
		case FrombooleanTolong:			return FrombooleanTolong(source);
		                            	                                                    
		case FromStringToFloat:			return FromStringToFloat(source);
		case FromByteToFloat:			return FromByteToFloat(source);
		case FrombyteToFloat:			return FrombyteToFloat(source);
		case FromShortToFloat:			return FromShortToFloat(source);
		case FromshortToFloat:			return FromshortToFloat(source);
		case FromIntegerToFloat:		return FromIntegerToFloat(source);
		case FromintToFloat:			return FromintToFloat(source);
		case FromLongToFloat:			return FromLongToFloat(source);
		case FromlongToFloat:			return FromlongToFloat(source);
		case FromDoubleToFloat:			return FromDoubleToFloat(source);
		case FromdoubleToFloat:			return FromdoubleToFloat(source);
		case FromCharacterToFloat:		return FromCharacterToFloat(source);
		case FromcharToFloat:			return FromcharToFloat(source);
		case FromBooleanToFloat:		return FromBooleanToFloat(source);
		case FrombooleanToFloat:		return FrombooleanToFloat(source);
		                            	                                                    
		case FromStringTofloat:			return FromStringTofloat(source);
		case FromByteTofloat:			return FromByteTofloat(source);
		case FrombyteTofloat:			return FrombyteTofloat(source);
		case FromShortTofloat:			return FromShortTofloat(source);
		case FromshortTofloat:			return FromshortTofloat(source);
		case FromIntegerTofloat:		return FromIntegerTofloat(source);
		case FromintTofloat:			return FromintTofloat(source);
		case FromLongTofloat:			return FromLongTofloat(source);
		case FromlongTofloat:			return FromlongTofloat(source);
		case FromDoubleTofloat:			return FromDoubleTofloat(source);
		case FromdoubleTofloat:			return FromdoubleTofloat(source);
		case FromCharacterTofloat:		return FromCharacterTofloat(source);
		case FromcharTofloat:			return FromcharTofloat(source);
		case FromBooleanTofloat:		return FromBooleanTofloat(source);
		case FrombooleanTofloat:		return FrombooleanTofloat(source);
		                            	                                                    
		case FromStringToDouble:		return FromStringToDouble(source);
		case FromByteToDouble:			return FromByteToDouble(source);
		case FrombyteToDouble:			return FrombyteToDouble(source);
		case FromShortToDouble:			return FromShortToDouble(source);
		case FromshortToDouble:			return FromshortToDouble(source);
		case FromIntegerToDouble:		return FromIntegerToDouble(source);
		case FromintToDouble:			return FromintToDouble(source);
		case FromLongToDouble:			return FromLongToDouble(source);
		case FromlongToDouble:			return FromlongToDouble(source);
		case FromFloatToDouble:			return FromFloatToDouble(source);
		case FromfloatToDouble:			return FromfloatToDouble(source);
		case FromCharacterToDouble:		return FromCharacterToDouble(source);
		case FromcharToDouble:			return FromcharToDouble(source);
		case FromBooleanToDouble:		return FromBooleanToDouble(source);
		case FrombooleanToDouble:		return FrombooleanToDouble(source);
		                            	                                                    
		case FromStringTodouble:		return FromStringTodouble(source);
		case FromByteTodouble:			return FromByteTodouble(source);
		case FrombyteTodouble:			return FrombyteTodouble(source);
		case FromShortTodouble:			return FromShortTodouble(source);
		case FromshortTodouble:			return FromshortTodouble(source);
		case FromIntegerTodouble:		return FromIntegerTodouble(source);
		case FromintTodouble:			return FromintTodouble(source);
		case FromLongTodouble:			return FromLongTodouble(source);
		case FromlongTodouble:			return FromlongTodouble(source);
		case FromFloatTodouble:			return FromFloatTodouble(source);
		case FromfloatTodouble:			return FromfloatTodouble(source);
		case FromCharacterTodouble:		return FromCharacterTodouble(source);
		case FromcharTodouble:			return FromcharTodouble(source);
		case FromBooleanTodouble:		return FromBooleanTodouble(source);
		case FrombooleanTodouble:		return FrombooleanTodouble(source);
		                            	                                                    
		case FromStringToCharacter:		return FromStringToCharacter(source);
		case FromByteToCharacter:		return FromByteToCharacter(source);
		case FrombyteToCharacter:		return FrombyteToCharacter(source);
		case FromShortToCharacter:		return FromShortToCharacter(source);
		case FromshortToCharacter:		return FromshortToCharacter(source);
		case FromIntegerToCharacter:	return FromIntegerToCharacter(source);
		case FromintToCharacter:		return FromintToCharacter(source);
		case FromLongToCharacter:		return FromLongToCharacter(source);
		case FromlongToCharacter:		return FromlongToCharacter(source);
		case FromFloatToCharacter:		return FromFloatToCharacter(source);
		case FromfloatToCharacter:		return FromfloatToCharacter(source);
		case FromDoubleToCharacter:		return FromDoubleToCharacter(source);
		case FromdoubleToCharacter:		return FromdoubleToCharacter(source);
		case FromBooleanToCharacter:	return FromBooleanToCharacter(source);
		case FrombooleanToCharacter:	return FrombooleanToCharacter(source);
		                            	                                                    
		case FromStringTochar:			return FromStringTochar(source);
		case FromByteTochar:			return FromByteTochar(source);
		case FrombyteTochar:			return FrombyteTochar(source);
		case FromShortTochar:			return FromShortTochar(source);
		case FromshortTochar:			return FromshortTochar(source);
		case FromIntegerTochar:			return FromIntegerTochar(source);
		case FromintTochar:				return FromintTochar(source);
		case FromLongTochar:			return FromLongTochar(source);
		case FromlongTochar:			return FromlongTochar(source);
		case FromFloatTochar:			return FromFloatTochar(source);
		case FromfloatTochar:			return FromfloatTochar(source);
		case FromDoubleTochar:			return FromDoubleTochar(source);
		case FromdoubleTochar:			return FromdoubleTochar(source);
		case FromBooleanTochar:			return FromBooleanTochar(source);
		case FrombooleanTochar:			return FrombooleanTochar(source);

		case FromStringToBoolean:		return FromStringToBoolean(source);
		case FromByteToBoolean:			return FromByteToBoolean(source);
		case FrombyteToBoolean:			return FrombyteToBoolean(source);
		case FromShortToBoolean:		return FromShortToBoolean(source);
		case FromshortToBoolean:		return FromshortToBoolean(source);
		case FromIntegerToBoolean:		return FromIntegerToBoolean(source);
		case FromintToBoolean:			return FromintToBoolean(source);
		case FromLongToBoolean:			return FromLongToBoolean(source);
		case FromlongToBoolean:			return FromlongToBoolean(source);
		case FromFloatToBoolean:		return FromFloatToBoolean(source);
		case FromfloatToBoolean:		return FromfloatToBoolean(source);
		case FromDoubleToBoolean:		return FromDoubleToBoolean(source);
		case FromdoubleToBoolean:		return FromdoubleToBoolean(source);
		case FromCharacterToBoolean:	return FromCharacterToBoolean(source);
		case FromcharToBoolean:			return FromcharToBoolean(source);
		                            	                                                    
		case FromStringToboolean:		return FromStringToboolean(source);
		case FromByteToboolean:			return FromByteToboolean(source);
		case FrombyteToboolean:			return FrombyteToboolean(source);
		case FromShortToboolean:		return FromShortToboolean(source);
		case FromshortToboolean:		return FromshortToboolean(source);
		case FromIntegerToboolean:		return FromIntegerToboolean(source);
		case FromintToboolean:			return FromintToboolean(source);
		case FromLongToboolean:			return FromLongToboolean(source);
		case FromlongToboolean:			return FromlongToboolean(source);
		case FromFloatToboolean:		return FromFloatToboolean(source);
		case FromfloatToboolean:		return FromfloatToboolean(source);
		case FromDoubleToboolean:		return FromDoubleToboolean(source);
		case FromdoubleToboolean:		return FromdoubleToboolean(source);
		case FromCharacterToboolean:	return FromCharacterToboolean(source);
		case FromcharToboolean:			return FromcharToboolean(source);
		default: break;
		}
		return null;
	}
}
