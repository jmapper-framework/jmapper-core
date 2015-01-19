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

import static com.googlecode.jmapper.enums.ConversionType.*;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;

/**
 * This class analyzes the two classes received in input, indicating what kind of conversion that has to be done.<br>
 * If the conversion was not found, returns UNDEFINED.
 * @author Alessandro Vurro
 *
 */
public final class ConversionAnalyzer {

	/**
	 * Analyzes Fields given as input and returns the type of conversion that has to be done.
	 * @param destination Field to analyze
	 * @param source Field to analyze
	 * @return type of Conversion
	 */
	public static ConversionType getConversionType(final Field destination, final Field source){
		return getConversionType(destination.getType(),source.getType());
	}
	/**
	 * Analyzes classes given as input and returns the type of conversion that has to be done.
	 * @param destination class to analyze
	 * @param source class to analyze
	 * @return type of Conversion
	 */
	public static ConversionType getConversionType(final Class<?> destination, final Class<?> source){
		
		if(destination == String.class){
			if(source == Byte.class) return FromByteToString;
			if(source == byte.class) return FrombyteToString;
			if(source == Short.class) return FromShortToString;
			if(source == short.class) return FromshortToString;
			if(source == Integer.class) return FromIntegerToString;
			if(source == int.class) return FromintToString;
			if(source == Long.class) return FromLongToString;
			if(source == long.class) return FromlongToString;
			if(source == Float.class) return FromFloatToString;
			if(source == float.class) return FromfloatToString;
			if(source == Double.class) return FromDoubleToString;
			if(source == double.class) return FromdoubleToString;
			if(source == Character.class) return FromCharacterToString;
			if(source == char.class) return FromcharToString;
			if(source == Boolean.class) return FromBooleanToString;
			if(source == boolean.class) return FrombooleanToString;
		}
		
		if(destination == Byte.class){
			if(source == String.class) return FromStringToByte;
			if(source == Short.class) return FromShortToByte;
			if(source == short.class) return FromshortToByte;
			if(source == Integer.class) return FromIntegerToByte;
			if(source == int.class) return FromintToByte;
			if(source == Long.class) return FromLongToByte;
			if(source == long.class) return FromlongToByte;
			if(source == Float.class) return FromFloatToByte;
			if(source == float.class) return FromfloatToByte;
			if(source == Double.class) return FromDoubleToByte;
			if(source == double.class) return FromdoubleToByte;
			if(source == Character.class) return FromCharacterToByte;
			if(source == char.class) return FromcharToByte;
			if(source == Boolean.class) return FromBooleanToByte;
			if(source == boolean.class) return FrombooleanToByte;
		}
		
		if(destination == byte.class){
			if(source == String.class) return FromStringTobyte;
			if(source == Short.class) return FromShortTobyte;
			if(source == short.class) return FromshortTobyte;
			if(source == Integer.class) return FromIntegerTobyte;
			if(source == int.class) return FromintTobyte;
			if(source == Long.class) return FromLongTobyte;
			if(source == long.class) return FromlongTobyte;
			if(source == Float.class) return FromFloatTobyte;
			if(source == float.class) return FromfloatTobyte;
			if(source == Double.class) return FromDoubleTobyte;
			if(source == double.class) return FromdoubleTobyte;
			if(source == Character.class) return FromCharacterTobyte;
			if(source == char.class) return FromcharTobyte;
			if(source == Boolean.class) return FromBooleanTobyte;
			if(source == boolean.class) return FrombooleanTobyte;
		}
		
		if(destination == Short.class){
			if(source == String.class) return FromStringToShort;
			if(source == Byte.class) return FromByteToShort;
			if(source == byte.class) return FrombyteToShort;
			if(source == Integer.class) return FromIntegerToShort;
			if(source == int.class) return FromintToShort;
			if(source == Long.class) return FromLongToShort;
			if(source == long.class) return FromlongToShort;
			if(source == Float.class) return FromFloatToShort;
			if(source == float.class) return FromfloatToShort;
			if(source == Double.class) return FromDoubleToShort;
			if(source == double.class) return FromdoubleToShort;
			if(source == Character.class) return FromCharacterToShort;
			if(source == char.class) return FromcharToShort;
			if(source == Boolean.class) return FromBooleanToShort;
			if(source == boolean.class) return FrombooleanToShort;
		}
		
		if(destination == short.class){
			if(source == String.class) return FromStringToshort;
			if(source == Byte.class) return FromByteToshort;
			if(source == byte.class) return FrombyteToshort;
			if(source == Integer.class) return FromIntegerToshort;
			if(source == int.class) return FromintToshort;
			if(source == Long.class) return FromLongToshort;
			if(source == long.class) return FromlongToshort;
			if(source == Float.class) return FromFloatToshort;
			if(source == float.class) return FromfloatToshort;
			if(source == Double.class) return FromDoubleToshort;
			if(source == double.class) return FromdoubleToshort;
			if(source == Character.class) return FromCharacterToshort;
			if(source == char.class) return FromcharToshort;
			if(source == Boolean.class) return FromBooleanToshort;
			if(source == boolean.class) return FrombooleanToshort;
		}
		
		if(destination == Integer.class){
			if(source == String.class) return FromStringToInteger;
			if(source == Byte.class) return FromByteToInteger;
			if(source == byte.class) return FrombyteToInteger;
			if(source == Short.class) return FromShortToInteger;
			if(source == short.class) return FromshortToInteger;
			if(source == Long.class) return FromLongToInteger;
			if(source == long.class) return FromlongToInteger;
			if(source == Float.class) return FromFloatToInteger;
			if(source == float.class) return FromfloatToInteger;
			if(source == Double.class) return FromDoubleToInteger;
			if(source == double.class) return FromdoubleToInteger;
			if(source == Character.class) return FromCharacterToInteger;
			if(source == char.class) return FromcharToInteger;
			if(source == Boolean.class) return FromBooleanToInteger;
			if(source == boolean.class) return FrombooleanToInteger;
		}
		
		if(destination == int.class){
			if(source == String.class) return FromStringToint;
			if(source == Byte.class) return FromByteToint;
			if(source == byte.class) return FrombyteToint;
			if(source == Short.class) return FromShortToint;
			if(source == short.class) return FromshortToint;
			if(source == Long.class) return FromLongToint;
			if(source == long.class) return FromlongToint;
			if(source == Float.class) return FromFloatToint;
			if(source == float.class) return FromfloatToint;
			if(source == Double.class) return FromDoubleToint;
			if(source == double.class) return FromdoubleToint;
			if(source == Character.class) return FromCharacterToint;
			if(source == char.class) return FromcharToint;
			if(source == Boolean.class) return FromBooleanToint;
			if(source == boolean.class) return FrombooleanToint;
		}
		
		if(destination == Long.class){
			if(source == String.class) return FromStringToLong;
			if(source == Byte.class) return FromByteToLong;
			if(source == byte.class) return FrombyteToLong;
			if(source == Short.class) return FromShortToLong;
			if(source == short.class) return FromshortToLong;
			if(source == Integer.class) return FromIntegerToLong;
			if(source == int.class) return FromintToLong;
			if(source == Float.class) return FromFloatToLong;
			if(source == float.class) return FromfloatToLong;
			if(source == Double.class) return FromDoubleToLong;
			if(source == double.class) return FromdoubleToLong;
			if(source == Character.class) return FromCharacterToLong;
			if(source == char.class) return FromcharToLong;
			if(source == Boolean.class) return FromBooleanToLong;
			if(source == boolean.class) return FrombooleanToLong;
		}
		
		if(destination == long.class){
			if(source == String.class) return FromStringTolong;
			if(source == Byte.class) return FromByteTolong;
			if(source == byte.class) return FrombyteTolong;
			if(source == Short.class) return FromShortTolong;
			if(source == short.class) return FromshortTolong;
			if(source == Integer.class) return FromIntegerTolong;
			if(source == int.class) return FromintTolong;
			if(source == Float.class) return FromFloatTolong;
			if(source == float.class) return FromfloatTolong;
			if(source == Double.class) return FromDoubleTolong;
			if(source == double.class) return FromdoubleTolong;
			if(source == Character.class) return FromCharacterTolong;
			if(source == char.class) return FromcharTolong;
			if(source == Boolean.class) return FromBooleanTolong;
			if(source == boolean.class) return FrombooleanTolong;
		}
		
		if(destination == Float.class){
			if(source == String.class) return FromStringToFloat;
			if(source == Byte.class) return FromByteToFloat;
			if(source == byte.class) return FrombyteToFloat;
			if(source == Short.class) return FromShortToFloat;
			if(source == short.class) return FromshortToFloat;
			if(source == Integer.class) return FromIntegerToFloat;
			if(source == int.class) return FromintToFloat;
			if(source == Long.class) return FromLongToFloat;
			if(source == long.class) return FromlongToFloat;
			if(source == Double.class) return FromDoubleToFloat;
			if(source == double.class) return FromdoubleToFloat;
			if(source == Character.class) return FromCharacterToFloat;
			if(source == char.class) return FromcharToFloat;
			if(source == Boolean.class) return FromBooleanToFloat;
			if(source == boolean.class) return FrombooleanToFloat;
		}
		
		if(destination == float.class){
			if(source == String.class) return FromStringTofloat;
			if(source == Byte.class) return FromByteTofloat;
			if(source == byte.class) return FrombyteTofloat;
			if(source == Short.class) return FromShortTofloat;
			if(source == short.class) return FromshortTofloat;
			if(source == Integer.class) return FromIntegerTofloat;
			if(source == int.class) return FromintTofloat;
			if(source == Long.class) return FromLongTofloat;
			if(source == long.class) return FromlongTofloat;
			if(source == Double.class) return FromDoubleTofloat;
			if(source == double.class) return FromdoubleTofloat;
			if(source == Character.class) return FromCharacterTofloat;
			if(source == char.class) return FromcharTofloat;
			if(source == Boolean.class) return FromBooleanTofloat;
			if(source == boolean.class) return FrombooleanTofloat;
		}
		
		if(destination == Double.class){
			if(source == String.class) return FromStringToDouble;
			if(source == Byte.class) return FromByteToDouble;
			if(source == byte.class) return FrombyteToDouble;
			if(source == Short.class) return FromShortToDouble;
			if(source == short.class) return FromshortToDouble;
			if(source == Integer.class) return FromIntegerToDouble;
			if(source == int.class) return FromintToDouble;
			if(source == Long.class) return FromLongToDouble;
			if(source == long.class) return FromlongToDouble;
			if(source == Float.class) return FromFloatToDouble;
			if(source == float.class) return FromfloatToDouble;
			if(source == Character.class) return FromCharacterToDouble;
			if(source == char.class) return FromcharToDouble;
			if(source == Boolean.class) return FromBooleanToDouble;
			if(source == boolean.class) return FrombooleanToDouble;
		}
		
		if(destination == double.class){
			if(source == String.class) return FromStringTodouble;
			if(source == Byte.class) return FromByteTodouble;
			if(source == byte.class) return FrombyteTodouble;
			if(source == Short.class) return FromShortTodouble;
			if(source == short.class) return FromshortTodouble;
			if(source == Integer.class) return FromIntegerTodouble;
			if(source == int.class) return FromintTodouble;
			if(source == Long.class) return FromLongTodouble;
			if(source == long.class) return FromlongTodouble;
			if(source == Float.class) return FromFloatTodouble;
			if(source == float.class) return FromfloatTodouble;
			if(source == Character.class) return FromCharacterTodouble;
			if(source == char.class) return FromcharTodouble;
			if(source == Boolean.class) return FromBooleanTodouble;
			if(source == boolean.class) return FrombooleanTodouble;
		}

		if(destination == Character.class){
			if(source == String.class) return FromStringToCharacter;
			if(source == Byte.class) return FromByteToCharacter;
			if(source == byte.class) return FrombyteToCharacter;
			if(source == Short.class) return FromShortToCharacter;
			if(source == short.class) return FromshortToCharacter;
			if(source == Integer.class) return FromIntegerToCharacter;
			if(source == int.class) return FromintToCharacter;
			if(source == Long.class) return FromLongToCharacter;
			if(source == long.class) return FromlongToCharacter;
			if(source == Float.class) return FromFloatToCharacter;
			if(source == float.class) return FromfloatToCharacter;
			if(source == Double.class) return FromDoubleToCharacter;
			if(source == double.class) return FromdoubleToCharacter;
			if(source == Boolean.class) return FromBooleanToCharacter;
			if(source == boolean.class) return FrombooleanToCharacter;
		}
		
		if(destination == char.class){
			if(source == String.class) return FromStringTochar;
			if(source == Byte.class) return FromByteTochar;
			if(source == byte.class) return FrombyteTochar;
			if(source == Short.class) return FromShortTochar;
			if(source == short.class) return FromshortTochar;
			if(source == Integer.class) return FromIntegerTochar;
			if(source == int.class) return FromintTochar;
			if(source == Long.class) return FromLongTochar;
			if(source == long.class) return FromlongTochar;
			if(source == Float.class) return FromFloatTochar;
			if(source == float.class) return FromfloatTochar;
			if(source == Double.class) return FromDoubleTochar;
			if(source == double.class) return FromdoubleTochar;
			if(source == Boolean.class) return FromBooleanTochar;
			if(source == boolean.class) return FrombooleanTochar;
		}
		
		if(destination == Boolean.class){
			if(source == String.class) return FromStringToBoolean;
			if(source == Byte.class) return FromByteToBoolean;
			if(source == byte.class) return FrombyteToBoolean;
			if(source == Short.class) return FromShortToBoolean;
			if(source == short.class) return FromshortToBoolean;
			if(source == Integer.class) return FromIntegerToBoolean;
			if(source == int.class) return FromintToBoolean;
			if(source == Long.class) return FromLongToBoolean;
			if(source == long.class) return FromlongToBoolean;
			if(source == Float.class) return FromFloatToBoolean;
			if(source == float.class) return FromfloatToBoolean;
			if(source == Double.class) return FromDoubleToBoolean;
			if(source == double.class) return FromdoubleToBoolean;
			if(source == Character.class) return FromCharacterToBoolean;
			if(source == char.class) return FromcharToBoolean;
		}
		
		if(destination == boolean.class){
			if(source == String.class) return FromStringToboolean;
			if(source == Byte.class) return FromByteToboolean;
			if(source == byte.class) return FrombyteToboolean;
			if(source == Short.class) return FromShortToboolean;
			if(source == short.class) return FromshortToboolean;
			if(source == Integer.class) return FromIntegerToboolean;
			if(source == int.class) return FromintToboolean;
			if(source == Long.class) return FromLongToboolean;
			if(source == long.class) return FromlongToboolean;
			if(source == Float.class) return FromFloatToboolean;
			if(source == float.class) return FromfloatToboolean;
			if(source == Double.class) return FromDoubleToboolean;
			if(source == double.class) return FromdoubleToboolean;
			if(source == Character.class) return FromCharacterToboolean;
			if(source == char.class) return FromcharToboolean;
		}
		
		return UNDEFINED;
	}
}
