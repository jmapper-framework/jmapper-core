/**
 * Copyright (C) 2012 - 2016 Alessandro Vurro.
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
		case FromByteToString:			return fromByteToString(source);
		case FrombyteToString:			return frombyteToString(source);
		case FromShortToString:			return fromShortToString(source);
		case FromshortToString:			return fromshortToString(source);
		case FromIntegerToString:		return fromIntegerToString(source);
		case FromintToString:			return fromintToString(source);
		case FromLongToString:			return fromLongToString(source);
		case FromlongToString:			return fromlongToString(source);
		case FromFloatToString:			return fromFloatToString(source);
		case FromfloatToString:			return fromfloatToString(source);
		case FromDoubleToString:		return fromDoubleToString(source);
		case FromdoubleToString:		return fromdoubleToString(source);
		case FromCharacterToString:		return fromCharacterToString(source);
		case FromcharToString:			return fromcharToString(source);
		case FromBooleanToString:		return fromBooleanToString(source);
		case FrombooleanToString:		return frombooleanToString(source);
		                            	                                                    
		case FromStringToByte:			return fromStringToByte(source);
		case FromShortToByte:			return fromShortToByte(source);
		case FromshortToByte:			return fromshortToByte(source);
		case FromIntegerToByte:			return fromIntegerToByte(source);
		case FromintToByte:				return fromintToByte(source);
		case FromLongToByte:			return fromLongToByte(source);
		case FromlongToByte:			return fromlongToByte(source);
		case FromFloatToByte:			return fromFloatToByte(source);
		case FromfloatToByte:			return fromfloatToByte(source);
		case FromDoubleToByte:			return fromDoubleToByte(source);
		case FromdoubleToByte:			return fromdoubleToByte(source);
		case FromCharacterToByte:		return fromCharacterToByte(source);
		case FromcharToByte:			return fromcharToByte(source);
		case FromBooleanToByte:			return fromBooleanToByte(source);
		case FrombooleanToByte:			return frombooleanToByte(source);
		                            	                                                    
		case FromStringTobyte:			return fromStringTobyte(source);
		case FromShortTobyte:			return fromShortTobyte(source);
		case FromshortTobyte:			return fromshortTobyte(source);
		case FromIntegerTobyte:			return fromIntegerTobyte(source);
		case FromintTobyte:				return fromintTobyte(source);
		case FromLongTobyte:			return fromLongTobyte(source);
		case FromlongTobyte:			return fromlongTobyte(source);
		case FromFloatTobyte:			return fromFloatTobyte(source);
		case FromfloatTobyte:			return fromfloatTobyte(source);
		case FromDoubleTobyte:			return fromDoubleTobyte(source);
		case FromdoubleTobyte:			return fromdoubleTobyte(source);
		case FromCharacterTobyte:		return fromCharacterTobyte(source);
		case FromcharTobyte:			return fromcharTobyte(source);
		case FromBooleanTobyte:			return fromBooleanTobyte(source);
		case FrombooleanTobyte:			return frombooleanTobyte(source);
			                        		                                                
		case FromStringToShort:			return fromStringToShort(source);
		case FromByteToShort:			return fromByteToShort(source);
		case FrombyteToShort:			return frombyteToShort(source);
		case FromIntegerToShort:		return fromIntegerToShort(source);
		case FromintToShort:			return fromintToShort(source);
		case FromLongToShort:			return fromLongToShort(source);
		case FromlongToShort:			return fromlongToShort(source);
		case FromFloatToShort:			return fromFloatToShort(source);
		case FromfloatToShort:			return fromfloatToShort(source);
		case FromDoubleToShort:			return fromDoubleToShort(source);
		case FromdoubleToShort:			return fromdoubleToShort(source);
		case FromCharacterToShort:		return fromCharacterToShort(source);
		case FromcharToShort:			return fromcharToShort(source);
		case FromBooleanToShort:		return fromBooleanToShort(source);
		case FrombooleanToShort:		return frombooleanToShort(source);
		                            	                                                    
		case FromStringToshort:			return fromStringToshort(source);
		case FromByteToshort:			return fromByteToshort(source);
		case FrombyteToshort:			return frombyteToshort(source);
		case FromIntegerToshort:		return fromIntegerToshort(source);
		case FromintToshort:			return fromintToshort(source);
		case FromLongToshort:			return fromLongToshort(source);
		case FromlongToshort:			return fromlongToshort(source);
		case FromFloatToshort:			return fromFloatToshort(source);
		case FromfloatToshort:			return fromfloatToshort(source);
		case FromDoubleToshort:			return fromDoubleToshort(source);
		case FromdoubleToshort:			return fromdoubleToshort(source);
		case FromCharacterToshort:		return fromCharacterToshort(source);
		case FromcharToshort:			return fromcharToshort(source);
		case FromBooleanToshort:		return fromBooleanToshort(source);
		case FrombooleanToshort:		return frombooleanToshort(source);
		                            	                                                    
		case FromStringToInteger:		return fromStringToInteger(source);
		case FromByteToInteger:			return fromByteToInteger(source);
		case FrombyteToInteger:			return frombyteToInteger(source);
		case FromShortToInteger:		return fromShortToInteger(source);
		case FromshortToInteger:		return fromshortToInteger(source);
		case FromLongToInteger:			return fromLongToInteger(source);
		case FromlongToInteger:			return fromlongToInteger(source);
		case FromFloatToInteger:		return fromFloatToInteger(source);
		case FromfloatToInteger:		return fromfloatToInteger(source);
		case FromDoubleToInteger:		return fromDoubleToInteger(source);
		case FromdoubleToInteger:		return fromdoubleToInteger(source);
		case FromCharacterToInteger:	return fromCharacterToInteger(source);
		case FromcharToInteger:			return fromcharToInteger(source);
		case FromBooleanToInteger:		return fromBooleanToInteger(source);
		case FrombooleanToInteger:		return frombooleanToInteger(source);
		                            	                                                    
		case FromStringToint:			return fromStringToint(source);
		case FromByteToint:				return fromByteToint(source);
		case FrombyteToint:				return frombyteToint(source);
		case FromShortToint:			return fromShortToint(source);
		case FromshortToint:			return fromshortToint(source);
		case FromLongToint:				return fromLongToint(source);
		case FromlongToint:				return fromlongToint(source);
		case FromFloatToint:			return fromFloatToint(source);
		case FromfloatToint:			return fromfloatToint(source);
		case FromDoubleToint:			return fromDoubleToint(source);
		case FromdoubleToint:			return fromdoubleToint(source);
		case FromCharacterToint:		return fromCharacterToint(source);
		case FromcharToint:				return fromcharToint(source);
		case FromBooleanToint:			return fromBooleanToint(source);
		case FrombooleanToint:			return frombooleanToint(source);
		                            	                                                    
		case FromStringToLong:			return fromStringToLong(source);
		case FromByteToLong:			return fromByteToLong(source);
		case FrombyteToLong:			return frombyteToLong(source);
		case FromShortToLong:			return fromShortToLong(source);
		case FromshortToLong:			return fromshortToLong(source);
		case FromIntegerToLong:			return fromIntegerToLong(source);
		case FromintToLong:				return fromintToLong(source);
		case FromFloatToLong:			return fromFloatToLong(source);
		case FromfloatToLong:			return fromfloatToLong(source);
		case FromDoubleToLong:			return fromDoubleToLong(source);
		case FromdoubleToLong:			return fromdoubleToLong(source);
		case FromCharacterToLong:		return fromCharacterToLong(source);
		case FromcharToLong:			return fromcharToLong(source);
		case FromBooleanToLong:			return fromBooleanToLong(source);
		case FrombooleanToLong:			return frombooleanToLong(source);
		                            	                                                    
		case FromStringTolong:			return fromStringTolong(source);
		case FromByteTolong:			return fromByteTolong(source);
		case FrombyteTolong:			return frombyteTolong(source);
		case FromShortTolong:			return fromShortTolong(source);
		case FromshortTolong:			return fromshortTolong(source);
		case FromIntegerTolong:			return fromIntegerTolong(source);
		case FromintTolong:				return fromintTolong(source);
		case FromFloatTolong:			return fromFloatTolong(source);
		case FromfloatTolong:			return fromfloatTolong(source);
		case FromDoubleTolong:			return fromDoubleTolong(source);
		case FromdoubleTolong:			return fromdoubleTolong(source);
		case FromCharacterTolong:		return fromCharacterTolong(source);
		case FromcharTolong:			return fromcharTolong(source);
		case FromBooleanTolong:			return fromBooleanTolong(source);
		case FrombooleanTolong:			return frombooleanTolong(source);
		                            	                                                    
		case FromStringToFloat:			return fromStringToFloat(source);
		case FromByteToFloat:			return fromByteToFloat(source);
		case FrombyteToFloat:			return frombyteToFloat(source);
		case FromShortToFloat:			return fromShortToFloat(source);
		case FromshortToFloat:			return fromshortToFloat(source);
		case FromIntegerToFloat:		return fromIntegerToFloat(source);
		case FromintToFloat:			return fromintToFloat(source);
		case FromLongToFloat:			return fromLongToFloat(source);
		case FromlongToFloat:			return fromlongToFloat(source);
		case FromDoubleToFloat:			return fromDoubleToFloat(source);
		case FromdoubleToFloat:			return fromdoubleToFloat(source);
		case FromCharacterToFloat:		return fromCharacterToFloat(source);
		case FromcharToFloat:			return fromcharToFloat(source);
		case FromBooleanToFloat:		return fromBooleanToFloat(source);
		case FrombooleanToFloat:		return frombooleanToFloat(source);
		                            	                                                    
		case FromStringTofloat:			return fromStringTofloat(source);
		case FromByteTofloat:			return fromByteTofloat(source);
		case FrombyteTofloat:			return frombyteTofloat(source);
		case FromShortTofloat:			return fromShortTofloat(source);
		case FromshortTofloat:			return fromshortTofloat(source);
		case FromIntegerTofloat:		return fromIntegerTofloat(source);
		case FromintTofloat:			return fromintTofloat(source);
		case FromLongTofloat:			return fromLongTofloat(source);
		case FromlongTofloat:			return fromlongTofloat(source);
		case FromDoubleTofloat:			return fromDoubleTofloat(source);
		case FromdoubleTofloat:			return fromdoubleTofloat(source);
		case FromCharacterTofloat:		return fromCharacterTofloat(source);
		case FromcharTofloat:			return fromcharTofloat(source);
		case FromBooleanTofloat:		return fromBooleanTofloat(source);
		case FrombooleanTofloat:		return frombooleanTofloat(source);
		                            	                                                    
		case FromStringToDouble:		return fromStringToDouble(source);
		case FromByteToDouble:			return fromByteToDouble(source);
		case FrombyteToDouble:			return frombyteToDouble(source);
		case FromShortToDouble:			return fromShortToDouble(source);
		case FromshortToDouble:			return fromshortToDouble(source);
		case FromIntegerToDouble:		return fromIntegerToDouble(source);
		case FromintToDouble:			return fromintToDouble(source);
		case FromLongToDouble:			return fromLongToDouble(source);
		case FromlongToDouble:			return fromlongToDouble(source);
		case FromFloatToDouble:			return fromFloatToDouble(source);
		case FromfloatToDouble:			return fromfloatToDouble(source);
		case FromCharacterToDouble:		return fromCharacterToDouble(source);
		case FromcharToDouble:			return fromcharToDouble(source);
		case FromBooleanToDouble:		return fromBooleanToDouble(source);
		case FrombooleanToDouble:		return frombooleanToDouble(source);
		                            	                                                    
		case FromStringTodouble:		return fromStringTodouble(source);
		case FromByteTodouble:			return fromByteTodouble(source);
		case FrombyteTodouble:			return frombyteTodouble(source);
		case FromShortTodouble:			return fromShortTodouble(source);
		case FromshortTodouble:			return fromshortTodouble(source);
		case FromIntegerTodouble:		return fromIntegerTodouble(source);
		case FromintTodouble:			return fromintTodouble(source);
		case FromLongTodouble:			return fromLongTodouble(source);
		case FromlongTodouble:			return fromlongTodouble(source);
		case FromFloatTodouble:			return fromFloatTodouble(source);
		case FromfloatTodouble:			return fromfloatTodouble(source);
		case FromCharacterTodouble:		return fromCharacterTodouble(source);
		case FromcharTodouble:			return fromcharTodouble(source);
		case FromBooleanTodouble:		return fromBooleanTodouble(source);
		case FrombooleanTodouble:		return frombooleanTodouble(source);
		                            	                                                    
		case FromStringToCharacter:		return fromStringToCharacter(source);
		case FromByteToCharacter:		return fromByteToCharacter(source);
		case FrombyteToCharacter:		return frombyteToCharacter(source);
		case FromShortToCharacter:		return fromShortToCharacter(source);
		case FromshortToCharacter:		return fromshortToCharacter(source);
		case FromIntegerToCharacter:	return fromIntegerToCharacter(source);
		case FromintToCharacter:		return fromintToCharacter(source);
		case FromLongToCharacter:		return fromLongToCharacter(source);
		case FromlongToCharacter:		return fromlongToCharacter(source);
		case FromFloatToCharacter:		return fromFloatToCharacter(source);
		case FromfloatToCharacter:		return fromfloatToCharacter(source);
		case FromDoubleToCharacter:		return fromDoubleToCharacter(source);
		case FromdoubleToCharacter:		return fromdoubleToCharacter(source);
		case FromBooleanToCharacter:	return fromBooleanToCharacter(source);
		case FrombooleanToCharacter:	return frombooleanToCharacter(source);
		                            	                                                    
		case FromStringTochar:			return fromStringTochar(source);
		case FromByteTochar:			return fromByteTochar(source);
		case FrombyteTochar:			return frombyteTochar(source);
		case FromShortTochar:			return fromShortTochar(source);
		case FromshortTochar:			return fromshortTochar(source);
		case FromIntegerTochar:			return fromIntegerTochar(source);
		case FromintTochar:				return fromintTochar(source);
		case FromLongTochar:			return fromLongTochar(source);
		case FromlongTochar:			return fromlongTochar(source);
		case FromFloatTochar:			return fromFloatTochar(source);
		case FromfloatTochar:			return fromfloatTochar(source);
		case FromDoubleTochar:			return fromDoubleTochar(source);
		case FromdoubleTochar:			return fromdoubleTochar(source);
		case FromBooleanTochar:			return fromBooleanTochar(source);
		case FrombooleanTochar:			return frombooleanTochar(source);

		case FromStringToBoolean:		return fromStringToBoolean(source);
		case FromByteToBoolean:			return fromByteToBoolean(source);
		case FrombyteToBoolean:			return frombyteToBoolean(source);
		case FromShortToBoolean:		return fromShortToBoolean(source);
		case FromshortToBoolean:		return fromshortToBoolean(source);
		case FromIntegerToBoolean:		return fromIntegerToBoolean(source);
		case FromintToBoolean:			return fromintToBoolean(source);
		case FromLongToBoolean:			return fromLongToBoolean(source);
		case FromlongToBoolean:			return fromlongToBoolean(source);
		case FromFloatToBoolean:		return fromFloatToBoolean(source);
		case FromfloatToBoolean:		return fromfloatToBoolean(source);
		case FromDoubleToBoolean:		return fromDoubleToBoolean(source);
		case FromdoubleToBoolean:		return fromdoubleToBoolean(source);
		case FromCharacterToBoolean:	return fromCharacterToBoolean(source);
		case FromcharToBoolean:			return fromcharToBoolean(source);
		                            	                                                    
		case FromStringToboolean:		return fromStringToboolean(source);
		case FromByteToboolean:			return fromByteToboolean(source);
		case FrombyteToboolean:			return frombyteToboolean(source);
		case FromShortToboolean:		return fromShortToboolean(source);
		case FromshortToboolean:		return fromshortToboolean(source);
		case FromIntegerToboolean:		return fromIntegerToboolean(source);
		case FromintToboolean:			return fromintToboolean(source);
		case FromLongToboolean:			return fromLongToboolean(source);
		case FromlongToboolean:			return fromlongToboolean(source);
		case FromFloatToboolean:		return fromFloatToboolean(source);
		case FromfloatToboolean:		return fromfloatToboolean(source);
		case FromDoubleToboolean:		return fromDoubleToboolean(source);
		case FromdoubleToboolean:		return fromdoubleToboolean(source);
		case FromCharacterToboolean:	return fromCharacterToboolean(source);
		case FromcharToboolean:			return fromcharToboolean(source);
		default: break;
		}
		return null;
	}
}
