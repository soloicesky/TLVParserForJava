/*
 * @author soloicesky
 * @fileName OperatorDBHelper.java
 * @date 2013-10-11 下午14:01:44
 * @description 
 */

package com.soloicesky.tlvutils;

import java.util.ArrayList;

public class TLVUtils {
	/**
	 * 
	 * @param tlvArray
	 *            arrayList of TLV objects
	 * @return
	 */
	public static byte[] buildTLVString(ArrayList<TLV> tlvArray) {
		byte[] desMsg = new byte[1024];
		int desMsgLen = 0;

		for (TLV tlv : tlvArray) {
			if (tlv.getLength() <= 0) {
				continue;
			}

			if ((tlv.getTag() & 0xFF00) > 0) {
				desMsg[desMsgLen++] = (byte) (tlv.getTag() >> 8);
			}

			desMsg[desMsgLen++] = (byte) (tlv.getTag() & 0x00FF);

			if (tlv.getLength() > 127) {
				desMsg[desMsgLen++] = (byte) 0x81;

			}

			desMsg[desMsgLen++] = (byte) (tlv.getTag() & 0x00EF);

			System.arraycopy(tlv.getValue(), 0, desMsg, desMsgLen,
					tlv.getLength());
			desMsgLen += tlv.getLength();
		}

		return desMsg;
	}

	/**
	 * 
	 * @param src
	 *            tlv格式的源串
	 * @param srcLen
	 *            串的长度
	 * @param decodeConstructedData
	 *            是否解析constructed的tlv数据,true - 解析, false-不解析
	 * @param savetlvobj
	 *            保存解析好的tlv元素的接口
	 * @return 0 成功， 非0失败
	 */
	public static int parseTLVString(byte[] src, int srcLen,
			boolean decodeConstructedData, SaveTLVOBJCallback savetlvobj) {
		if (src == null || srcLen <= 0 || srcLen > src.length) {
			return -1;
		}

		int start = 0;

		for (int i = 0; i < srcLen; i++) {
			start++;
			if (src[i] == 0x00 || (src[i] & 0xFF) == 0xFF) {
				continue;
			} else {
				break;
			}
		}

		if (start >= srcLen) {
			return 0;
		}

		short tag;
		int len;
		byte[] value = new byte[1024];
		int lenBytes;

		for (int i = start; i < srcLen;) {
			// parse tag
			tag = 0;

			if ((src[i] & 0x1F) == 0x1F) {
				tag = (short) (src[i++] & 0xFF);
				tag = (short) (tag << 8);
			}

			tag += (short) (src[i++] & 0xFF);

			// parse length
			len = 0;

			if ((src[i] & 0x80) == 0x80) {
				lenBytes = (src[i] & 0x7F);

				for (int j = 0; j < lenBytes; j++) {
					len = len << 8 + src[++i];
				}
			} else {
				len = src[i++];
			}

			if (len > (srcLen - i)) {
				return -2;
			}

			System.arraycopy(src, i, value, 0, len);
			i += len;
			savetlvobj.saveTLVOBJ(tag, len, value);
		}

		return 0;
	}
}
