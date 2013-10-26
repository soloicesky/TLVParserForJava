/**
 * @author solomon
 * @fileName HexStringUtil.java
 * @date 2013-3-27 下午8:22:44
 * @description 
 */
package com.soloicesky.tlvutils;


public class HexStringUtil {
	
	public static final char ERR_INVALID_ARGUMENT = '.';

	/**
	 * 
	 * @Author solomon
	 * @DataTime 2013-3-27 下午8:42:46
	 * @Functon hexStringToBytes
	 * @Description
	 *
	 * @param
	 * @Return none
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.length() == 0) {
			return null;
		}
		
		hexString = hexString.replaceAll(" ", ""); //remove all blankspace
		hexString = hexString.toUpperCase();
		if (hexString.length()%2 != 0) {
			hexString = hexString.concat("0");
		}
		char[] hexChars = hexString.toCharArray();
		int bytesLen = (hexString.length()+1) / 2;
		byte[] desBytes = new byte[bytesLen];
		int pos = 0;
		
		for (int i = 0; i < desBytes.length; i++) {
			pos = i * 2;
			desBytes[i] = (byte) ((charToByte(hexChars[pos]) << 4) | charToByte(hexChars[pos + 1]));
		}

		return desBytes;
	}

	/**
	 * 
	 * @Author solomon
	 * @DataTime 2013-3-27 下午8:42:36
	 * @Functon charToByte
	 * @Description
	 *
	 * @param
	 * @Return none
	 */
	public static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	
	/**
	 * 
	 * @Author solomon
	 * @DataTime 2013-3-27 下午8:42:40
	 * @Functon byteArrayToHexstring
	 * @Description
	 *
	 * @param
	 * @Return none
	 */
	public static String byteArrayToHexstring(byte[] bytes)
	{
		StringBuilder hexString = new StringBuilder();
		
		if (bytes.length <= 0 || bytes == null) {
			return null;
		}
		
		String hv;
		int v = 0;
		
		for (int i = 0; i < bytes.length; i++) {
			v = bytes[i] & 0xFF;
			hv = Integer.toHexString(v);
			
			if (hv.length() < 2) {
				hexString.append(0);
			}
			
			hexString.append(hv);
		}
		
		return hexString.toString().toUpperCase();
	}
	
	/**
	 * 
	 * @Author solomon
	 * @DataTime 2013-3-29 下午4:03:32
	 * @Functon byteToHexChar
	 * @Description
	 *
	 * @param
	 * @Return none
	 */
	public static char[] byteToHexChar(byte b)
	{		
		char[] ch = new char[2];
		if (b > 0xFF) {
			return null;
		}
		
//		System.out.println("byteToHexChar b=" + ((b & 0xF0)>>4)  + ", " + (b & 0x0F));
		ch[0] = "0123456789ABCDEF".charAt((b & 0xF0)>>4);
		ch[1] = "0123456789ABCDEF".charAt((b & 0x0F));
		return ch;
	}
	
	/**
	 * 
	 * @Author solomon
	 * @DataTime 2013-4-1 下午1:04:57
	 * @Functon byteArrayToHexstring
	 * @Description
	 *
	 * @param
	 * @Return none
	 */
	public static String byteArrayToHexstring(byte[] bytes, int start, int end)
	{
		StringBuilder hexString = new StringBuilder();
		
		if (bytes.length <= 0 || bytes == null) {
			return null;
		}
		
		String hv;
		int v = 0;
		
		for (int i = start; i < end; i++) {
			v = bytes[i] & 0xFF;
			hv = Integer.toHexString(v);
			
			if (hv.length() < 2) {
				hexString.append(0);
			}
			
			hexString.append(hv);
		}
		
		return hexString.toString().toUpperCase();
	}
}
