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

/**
 * This Class defines conversion methods between primitive and wrapper types in literal version.
 * 
 * @author Alessandro Vurro
 *
 */
public final class ConversionMethod{

	/*  STRING METHODS  */
	public static String FrombyteToString(final String source)     {	return "Byte.toString("+source+")";			}
	public static String FromshortToString(final String source)    {	return "Short.toString("+source+")";		}
	public static String FromintToString(final String source)      {	return "Integer.toString("+source+")";		}
	public static String FromlongToString(final String source)     {	return "Long.toString("+source+")";			}
	public static String FromfloatToString(final String source)    {	return "Float.toString("+source+")";		}
	public static String FromdoubleToString(final String source)   {	return "Double.toString("+source+")";		}
	public static String FromcharToString(final String source) 	   {	return "Character.toString("+source+")";	}
	public static String FrombooleanToString(final String source)  {	return "Boolean.toString("+source+")";		}
	
	public static String FromByteToString(final String source)     {	return source+".toString()";				}
	public static String FromShortToString(final String source)    {	return source+".toString()";				}
	public static String FromIntegerToString(final String source)  {	return source+".toString()";				}
	public static String FromLongToString(final String source)     {	return source+".toString()";				}
	public static String FromFloatToString(final String source)    {	return source+".toString()";				}
	public static String FromDoubleToString(final String source)   {	return source+".toString()";				}
	public static String FromCharacterToString(final String source){	return source+".toString()";				}
	public static String FromBooleanToString(final String source)  {	return source+".toString()";				}

	
	/*  BYTE METHODS  */
	public static String FromshortToByte(final String source) 	  {	return "new Byte((byte) "+source+")";		}
	public static String FromintToByte(final String source)       { return "new Byte((byte) "+source+")";		}
	public static String FromlongToByte(final String source) 	  { return "new Byte((byte) "+source+")";		}
	public static String FromfloatToByte(final String source) 	  { return "new Byte((byte) "+source+")";		}
	public static String FromdoubleToByte(final String source) 	  { return "new Byte((byte) "+source+")";		}
	public static String FromcharToByte(final String source) 	  { return "new Byte((byte) "+source+")";							}
	public static String FrombooleanToByte(final String source)   { return "new Byte("+source+"?(byte)1:(byte)0)";   				}
	
	public static String FromStringToByte(final String source) 	  { return "new Byte("+source+")";				}
	public static String FromShortToByte(final String source) 	  {	return "new Byte("+source+".byteValue())";	}
	public static String FromIntegerToByte(final String source)   { return "new Byte("+source+".byteValue())";	}
	public static String FromLongToByte(final String source) 	  { return "new Byte("+source+".byteValue())";	}
	public static String FromFloatToByte(final String source) 	  { return "new Byte("+source+".byteValue())";	}
	public static String FromDoubleToByte(final String source) 	  { return "new Byte("+source+".byteValue())";	}
	public static String FromCharacterToByte(final String source) { return "new Byte((byte)"+source+".charValue())";				}
	public static String FromBooleanToByte(final String source)   { return "new Byte("+source+".booleanValue()?(byte)1:(byte)0)";   }
	
	public static String FromshortTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String FromintTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String FromlongTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String FromfloatTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String FromdoubleTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String FromcharTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String FrombooleanTobyte(final String source)   { return source+"?(byte)1:(byte)0";     		}
	
	public static String FromStringTobyte(final String source) 	  { return "Byte.parseByte("+source+")";		}
	public static String FromShortTobyte(final String source) 	  { return source+".byteValue()";				}
	public static String FromIntegerTobyte(final String source)	  { return source+".byteValue()";				}
	public static String FromLongTobyte(final String source) 	  { return source+".byteValue()";				}
	public static String FromFloatTobyte(final String source) 	  { return source+".byteValue()";				}
	public static String FromDoubleTobyte(final String source)    { return source+".byteValue()";				}
	public static String FromCharacterTobyte(final String source) { return "(byte) "+source+".charValue()";		}
	public static String FromBooleanTobyte(final String source)   { return source+".booleanValue()?(byte)1:(byte)0";   }

	
	/*  SHORT METHODS  */
	public static String FrombyteToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String FromintToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String FromlongToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String FromfloatToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String FromdoubleToShort(final String source)   { return "new Short((short) "+source+")";		}
	public static String FromcharToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String FrombooleanToShort(final String source)  { return "new Short("+source+"?(short)1:(short)0)";   }
	
	public static String FromStringToShort(final String source)	  { return "new Short("+source+")";				}
	public static String FromByteToShort(final String source) 	  {	return "new Short("+source+".shortValue())";}
	public static String FromIntegerToShort(final String source)  {	return "new Short("+source+".shortValue())";}
	public static String FromLongToShort(final String source) 	  {	return "new Short("+source+".shortValue())";}
	public static String FromFloatToShort(final String source) 	  {	return "new Short("+source+".shortValue())";}
	public static String FromDoubleToShort(final String source)   {	return "new Short("+source+".shortValue())";}
	public static String FromCharacterToShort(final String source){	return "new Short((short)"+source+".charValue())";}
	public static String FromBooleanToShort(final String source)  { return "new Short("+source+".booleanValue()?(short)1:(short)0)";   }

	public static String FrombyteToshort(final String source) 	  { return "(short) "+source;					}
	public static String FromintToshort(final String source) 	  { return "(short) "+source;					}
	public static String FromlongToshort(final String source) 	  { return "(short) "+source;					}
	public static String FromfloatToshort(final String source) 	  { return "(short) "+source;					}
	public static String FromdoubleToshort(final String source)   { return "(short) "+source;					}
	public static String FromcharToshort(final String source) 	  { return "(short) "+source;					}
	public static String FrombooleanToshort(final String source)  { return source+"?(short)1:(short)0";   	    }
	
	public static String FromStringToshort(final String source)   { return "Short.parseShort("+source+")";		}
	public static String FromByteToshort(final String source) 	  { return source+".shortValue()";				}
	public static String FromIntegerToshort(final String source)  { return source+".shortValue()";				}
	public static String FromLongToshort(final String source) 	  { return source+".shortValue()";				}
	public static String FromFloatToshort(final String source) 	  { return source+".shortValue()";				}
	public static String FromDoubleToshort(final String source)   { return source+".shortValue()";				}
	public static String FromCharacterToshort(final String source){ return "(short) "+source+".charValue()";	}
	public static String FromBooleanToshort(final String source)  { return source+".booleanValue()?(short)1:(short)0";   }

	
	/*  INTEGER/INT METHODS  */
	public static String FromStringToInteger(final String source) { return "new Integer("+source+")";			}
	public static String FrombyteToInteger(final String source)   { return "new Integer((int) "+source+")";		}
	public static String FromshortToInteger(final String source)  { return "new Integer((int) "+source+")";		}
	public static String FromlongToInteger(final String source)   { return "new Integer((int) "+source+")";		}
	public static String FromfloatToInteger(final String source)  { return "new Integer((int) "+source+")";		}
	public static String FromdoubleToInteger(final String source) { return "new Integer((int) "+source+")";		}
	public static String FromcharToInteger(final String source)   {	return "new Integer((int) "+source+")";		}
	public static String FrombooleanToInteger(final String source){ return "new Integer("+source+"?(int)1:(int)0)";   }
	
	public static String FromByteToInteger(final String source)   {	return "new Integer("+source+".intValue())";}
	public static String FromShortToInteger(final String source)  {	return "new Integer("+source+".intValue())";}
	public static String FromLongToInteger(final String source)   {	return "new Integer("+source+".intValue())";}
	public static String FromFloatToInteger(final String source)  {	return "new Integer("+source+".intValue())";}
	public static String FromDoubleToInteger(final String source) {	return "new Integer("+source+".intValue())";}
	public static String FromCharacterToInteger(final String source){return "new Integer((int) "+source+".charValue())";}
	public static String FromBooleanToInteger(final String source){ return "new Integer("+source+".booleanValue()?(int)1:(int)0)";   }

	public static String FrombyteToint(final String source)   	  { return "(int) "+source;						}
	public static String FromshortToint(final String source) 	  { return "(int) "+source;						}
	public static String FromlongToint(final String source) 	  { return "(int) "+source;						}
	public static String FromfloatToint(final String source) 	  { return "(int) "+source;						}
	public static String FromdoubleToint(final String source) 	  { return "(int) "+source;						}
	public static String FromcharToint(final String source) 	  { return "(int) "+source;						}
	public static String FrombooleanToint(final String source)    { return source+"?(int)1:(int)0";   			}

	public static String FromStringToint(final String source) 	  { return "Integer.parseInt("+source+")";		}
	public static String FromByteToint(final String source) 	  { return source+".intValue()";				}
	public static String FromShortToint(final String source) 	  { return source+".intValue()";				}
	public static String FromLongToint(final String source) 	  { return source+".intValue()";				}
	public static String FromFloatToint(final String source) 	  { return source+".intValue()";				}
	public static String FromDoubleToint(final String source) 	  { return source+".intValue()";				}
	public static String FromCharacterToint(final String source)  { return "(int) "+source+".charValue()";		}
	public static String FromBooleanToint(final String source)    { return source+".booleanValue()?(int)1:(int)0";   }


	/*  LONG METHODS  */
	public static String FromStringToLong(final String source) 	  {	return "new Long("+source+")";				}
	public static String FrombyteToLong(final String source)  	  { return "new Long((long) "+source+")";		}
	public static String FromshortToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String FromintToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String FromdoubleToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String FromcharToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String FrombooleanToLong(final String source)	  { return "new Long("+source+"?1L:0L)";   		}

	public static String FromByteToLong(final String source) 	  {	return "new Long("+source+".longValue())";	}
	public static String FromShortToLong(final String source)	  {	return "new Long("+source+".longValue())";	}
	public static String FromIntegerToLong(final String source)   {	return "new Long("+source+".longValue())";	}
	public static String FromFloatToLong(final String source) 	  {	return "new Long("+source+".longValue())";	}
	public static String FromfloatToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String FromDoubleToLong(final String source) 	  {	return "new Long("+source+".longValue())";	}
	public static String FromCharacterToLong(final String source) { return "new Long((long) "+source+".charValue())";}
	public static String FromBooleanToLong(final String source)   { return "new Long("+source+".booleanValue()?1L:0L)";}
	
	public static String FromStringTolong(final String source) 	  { return "Long.parseLong("+source+")";		}
	public static String FrombyteTolong(final String source) 	  { return "(long) "+source;					}
	public static String FromshortTolong(final String source) 	  { return "(long) "+source;					}
	public static String FromintTolong(final String source) 	  { return "(long) "+source;					}
	public static String FromfloatTolong(final String source) 	  { return "(long) "+source;					}
	public static String FromdoubleTolong(final String source) 	  { return "(long) "+source;					}
	public static String FromcharTolong(final String source) 	  { return "(long) "+source;					}
	public static String FrombooleanTolong(final String source)   { return source+"?1L:0L";   					}

	public static String FromByteTolong(final String source) 	  { return source+".longValue()";				}
	public static String FromShortTolong(final String source) 	  { return source+".longValue()";				}
	public static String FromIntegerTolong(final String source)   { return source+".longValue()";				}
	public static String FromFloatTolong(final String source)     { return source+".longValue()";				}
	public static String FromDoubleTolong(final String source)    { return source+".longValue()";				}
	public static String FromCharacterTolong(final String source) { return "(long) "+source+".charValue()";		}
	public static String FromBooleanTolong(final String source)   { return source+".booleanValue()?1L:0L";   	}


	/*  FLOAT METHODS */
	public static String FromStringToFloat(final String source)   {	return "new Float("+source+")";				}
	public static String FrombyteToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String FromshortToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String FromintToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String FromlongToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String FromdoubleToFloat(final String source)   { return "new Float((float) "+source+")";		}
	public static String FromcharToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String FrombooleanToFloat(final String source)  { return "new Float("+source+"?1F:0F)";		}
	
	public static String FromByteToFloat(final String source) 	  { return "new Float("+source+".floatValue())";}
	public static String FromShortToFloat(final String source) 	  { return "new Float("+source+".floatValue())";}
	public static String FromIntegerToFloat(final String source)  { return "new Float("+source+".floatValue())";}
	public static String FromLongToFloat(final String source) 	  { return "new Float("+source+".floatValue())";}
	public static String FromDoubleToFloat(final String source)   { return "new Float("+source+".floatValue())";}
	public static String FromCharacterToFloat(final String source){ return "new Float((float) "+source+".charValue())";}
	public static String FromBooleanToFloat(final String source)  { return "new Float("+source+".booleanValue()?1F:0F)";}

	public static String FromStringTofloat(final String source)	  { return "Float.parseFloat("+source+")";}
	public static String FrombyteTofloat(final String source) 	  { return "(float) "+source;					}
	public static String FromshortTofloat(final String source) 	  { return "(float) "+source;					}
	public static String FromintTofloat(final String source) 	  { return "(float) "+source;					}
	public static String FromlongTofloat(final String source) 	  { return "(float) "+source;					}
	public static String FromdoubleTofloat(final String source)	  { return "(float) "+source;					}
	public static String FromcharTofloat(final String source) 	  { return "(float) "+source;					}
	public static String FrombooleanTofloat(final String source)  { return source+"?1F:0F";}

	public static String FromByteTofloat(final String source) 	  { return source+".floatValue()";				}
	public static String FromShortTofloat(final String source)    { return source+".floatValue()";				}
	public static String FromIntegerTofloat(final String source)  { return source+".floatValue()";				}
	public static String FromLongTofloat(final String source) 	  { return source+".floatValue()";				}
	public static String FromDoubleTofloat(final String source)   { return source+".floatValue()";				}
	public static String FromCharacterTofloat(final String source){ return "(float) "+source+".charValue()";	}
	public static String FromBooleanTofloat(final String source)  { return source+".booleanValue()?1F:0F";		}


	/*  DOUBLE METHODS  */
	public static String FromStringToDouble(final String source)  {	return "new Double("+source+")";			}
	public static String FrombyteToDouble(final String source) 	  {	return "new Double((double) "+source+")";	}
	public static String FromshortToDouble(final String source)   {	return "new Double((double) "+source+")";	}
	public static String FromintToDouble(final String source) 	  {	return "new Double((double) "+source+")";	}
	public static String FromlongToDouble(final String source) 	  {	return "new Double((double) "+source+")";	}
	public static String FromfloatToDouble(final String source)   {	return "new Double((double) "+source+")";	}
	public static String FromcharToDouble(final String source) 	  {	return "new Double((double) "+source+")";	}
	public static String FrombooleanToDouble(final String source) { return "new Double("+source+"?1D:0D)";	    }

	public static String FromByteToDouble(final String source) 	  {	return "new Double("+source+".doubleValue())";}
	public static String FromShortToDouble(final String source)   {	return "new Double("+source+".doubleValue())";}
	public static String FromIntegerToDouble(final String source) {	return "new Double("+source+".doubleValue())";}
	public static String FromLongToDouble(final String source) 	  {	return "new Double("+source+".doubleValue())";}
	public static String FromFloatToDouble(final String source)   {	return "new Double("+source+".doubleValue())";}
	public static String FromCharacterToDouble(final String source){return "new Double((double) "+source+".charValue())";}
	public static String FromBooleanToDouble(final String source) { return "new Double("+source+".booleanValue()?1D:0D)";}
	
	public static String FromStringTodouble(final String source)  { return "Double.parseDouble("+source+")";	}
	public static String FrombyteTodouble(final String source) 	  { return "(double) "+source;					}
	public static String FromshortTodouble(final String source)   { return "(double) "+source;					}
	public static String FromintTodouble(final String source) 	  { return "(double) "+source;					}
	public static String FromlongTodouble(final String source) 	  { return "(double) "+source;					}
	public static String FromfloatTodouble(final String source)   { return "(double) "+source;					}
	public static String FromcharTodouble(final String source) 	  { return "(double) "+source;					}
	public static String FrombooleanTodouble(final String source) { return source+"?1D:0D";						}
	
	public static String FromLongTodouble(final String source) 	  { return source+".doubleValue()";				}
	public static String FromByteTodouble(final String source) 	  { return source+".doubleValue()";				}
	public static String FromShortTodouble(final String source)   { return source+".doubleValue()";				}
	public static String FromIntegerTodouble(final String source) { return source+".doubleValue()";				}
	public static String FromFloatTodouble(final String source)   { return source+".doubleValue()";				}
	public static String FromCharacterTodouble(final String source){return "(double) "+source+".charValue()";	}
	public static String FromBooleanTodouble(final String source)  {return source+".booleanValue()?1D:0D";		}
	
	
	/* CHARACTER/CHAR METHODS  */
	public static String FromStringToCharacter(final String source){ return "new Character("+source+".charAt(0))";}
	public static String FrombyteToCharacter(final String source)  { return "new Character((char) "+source+")"; }
	public static String FromshortToCharacter(final String source) { return "new Character((char) "+source+")";	}
	public static String FromintToCharacter(final String source)   { return "new Character((char) "+source+")";	}
	public static String FromlongToCharacter(final String source)  { return "new Character((char) "+source+")";	}
	public static String FromfloatToCharacter(final String source) { return "new Character((char) "+source+")";	}
	public static String FromdoubleToCharacter(final String source){ return "new Character((char) "+source+")";	}
	public static String FrombooleanToCharacter(final String source){return "new Character("+source+"?'T':'F')";}
	
	public static String FromByteToCharacter(final String source)  { return "new Character((char) "+source+".byteValue())";  }
	public static String FromShortToCharacter(final String source) { return "new Character((char) "+source+".shortValue())"; }
	public static String FromIntegerToCharacter(final String source){return "new Character((char) "+source+".intValue())";	 }
	public static String FromLongToCharacter(final String source)  { return "new Character((char) "+source+".longValue())";	 }
	public static String FromFloatToCharacter(final String source) { return "new Character((char) "+source+".floatValue())"; }
	public static String FromDoubleToCharacter(final String source){ return "new Character((char) "+source+".doubleValue())";}
	public static String FromBooleanToCharacter(final String source){return "new Character("+source+".booleanValue()?'T':'F')";}
	
	public static String FromStringTochar(final String source) 	  {return source+".charAt(0)";				    }
	public static String FrombyteTochar(final String source) 	  {return "(char) "+source;						}
	public static String FromshortTochar(final String source) 	  {return "(char) "+source;						}
	public static String FromintTochar(final String source) 	  {return "(char) "+source;						}
	public static String FromlongTochar(final String source) 	  {return "(char) "+source;						}
	public static String FromfloatTochar(final String source) 	  {return "(char) "+source;						}
	public static String FromdoubleTochar(final String source) 	  {return "(char) "+source;						}
	public static String FrombooleanTochar(final String source)   {return source+"?'T':'F'";					}
	
	public static String FromByteTochar(final String source) 	  {return "(char) "+source+".byteValue()";		}
	public static String FromShortTochar(final String source) 	  {return "(char) "+source+".shortValue()";		}
	public static String FromIntegerTochar(final String source)   {return "(char) "+source+".intValue()";		}
	public static String FromLongTochar(final String source) 	  {return "(char) "+source+".longValue()";		}
	public static String FromFloatTochar(final String source) 	  {return "(char) "+source+".floatValue()";		}
	public static String FromDoubleTochar(final String source) 	  {return "(char) "+source+".doubleValue()";	}
	public static String FromBooleanTochar(final String source)   {return source+".booleanValue()?'T':'F'";		}
	
	
	/*  BOOLEAN METHODS  */
	public static String FromStringToBoolean(final String source) { return "new Boolean("+source+")";			   }
	public static String FrombyteToBoolean(final String source)   { return "new Boolean("+source+"==0?false:true)";}
	public static String FromshortToBoolean(final String source)  { return "new Boolean("+source+"==0?false:true)";}
	public static String FromintToBoolean(final String source) 	  { return "new Boolean("+source+"==0?false:true)";}
	public static String FromlongToBoolean(final String source)   { return "new Boolean("+source+"==0?false:true)";}
	public static String FromfloatToBoolean(final String source)  { return "new Boolean("+source+"==0?false:true)";}
	public static String FromdoubleToBoolean(final String source) { return "new Boolean("+source+"==0?false:true)";}
	public static String FromcharToBoolean(final String source)   { return "new Boolean("+source+"=='T'?true:"+source+"=='F'?false:null)";}
	
	public static String FromByteToBoolean(final String source)   { return "new Boolean("+source+".byteValue()==0?false:true)";}
	public static String FromShortToBoolean(final String source)  { return "new Boolean("+source+".shortValue()==0?false:true)";}
	public static String FromIntegerToBoolean(final String source){ return "new Boolean("+source+".intValue()==0?false:true)";}
	public static String FromLongToBoolean(final String source)	  { return "new Boolean("+source+".longValue()==0?false:true)";}
	public static String FromFloatToBoolean(final String source)  { return "new Boolean("+source+".floatValue()==0?false:true)";}
	public static String FromDoubleToBoolean(final String source) { return "new Boolean("+source+".doubleValue()==0?false:true)";}
	public static String FromCharacterToBoolean(final String source){ return "new Boolean("+source+".charValue()=='T'?true:"+source+".charValue()=='F'?false:null)";}
	
	public static String FrombyteToboolean(final String source)   { return source+"==0?false:true";}
	public static String FromshortToboolean(final String source)  { return source+"==0?false:true";}
	public static String FromintToboolean(final String source) 	  { return source+"==0?false:true";}
	public static String FromlongToboolean(final String source)   { return source+"==0?false:true";}
	public static String FromfloatToboolean(final String source)  { return source+"==0?false:true";}
	public static String FromdoubleToboolean(final String source) { return source+"==0?false:true";}
	public static String FromcharToboolean(final String source)   { return source+"=='T'?true:false";}
	
	public static String FromStringToboolean(final String source) { return "Boolean.parseBoolean("+source+")";}
	public static String FromByteToboolean(final String source)   { return source+".byteValue()==0?false:true";}
	public static String FromShortToboolean(final String source)  { return source+".shortValue()==0?false:true";}
	public static String FromIntegerToboolean(final String source){ return source+".intValue()==0?false:true";}
	public static String FromLongToboolean(final String source)   { return source+".longValue()==0?false:true";}
	public static String FromFloatToboolean(final String source)  { return source+".floatValue()==0?false:true";}
	public static String FromDoubleToboolean(final String source) { return source+".doubleValue()==0?false:true";}
	public static String FromCharacterToboolean(final String source){ return source+".charValue()=='T'?true:false";}
}
