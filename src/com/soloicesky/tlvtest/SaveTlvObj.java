/**
 * com.soloicesky.tlvtest.SaveTlvObj.java
 *Administrator @ 2013-10-26 ионГ11:48:32
 */
package com.soloicesky.tlvtest;

import com.soloicesky.tlvutils.HexStringUtil;
import com.soloicesky.tlvutils.SaveTLVOBJCallback;

/**
 * @filname SaveTlvObj.java
 * @description
 * @author soloicesky
 * @data 2013-10-26 @time ионГ11:48:32
 */
public class SaveTlvObj implements SaveTLVOBJCallback {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soloicesky.tlvutils.SaveTLVOBJCallback#saveTLVOBJ(short, int,
	 * byte[])
	 */
	@Override
	public void saveTLVOBJ(short tag, int length, byte[] value) {
		// TODO Auto-generated method stub
		System.out
				.println("=======================================================");

		String s = String.format("%X", tag);
		System.out.println("Tag: " + s);
		System.out.println("Len:" + length);
		System.out.println("Value:"
				+ HexStringUtil.byteArrayToHexstring(value, 0, length));
	}
}
