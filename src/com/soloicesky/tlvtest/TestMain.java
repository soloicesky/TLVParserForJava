/**
 * com.soloicesky.tlvutils.TestMain.java
 *Administrator @ 2013-10-26 ионГ11:39:06
 */
package com.soloicesky.tlvtest;

import com.soloicesky.tlvutils.HexStringUtil;
import com.soloicesky.tlvutils.TLVUtils;

import com.soloicesky.tlvtest.SaveTlvObj;
/**
 * @filname TestMain.java
 * @description
 * @author soloicesky
 * @data 2013-10-26 @time ионГ11:39:06
 */
public class TestMain {
	public static void main(String[] args) {
		String tlvConstructedData = "9F26087D7013C90F9B688B9F2701809F101307010103A0A802010A01000000361907167E7E9F37049F0E155D9F36020795950500800400009A031310259C01009F02060000000000095F2A02015682027C009F1A0201569F03060000000000009F3303E0E1C89F34030203009F3501229F1E083132333435363738";
		SaveTlvObj stlv = new SaveTlvObj();
		
		TLVUtils.parseTLVString(
				HexStringUtil.hexStringToBytes(tlvConstructedData),
				tlvConstructedData.length() / 2, true, stlv);
	}

}
