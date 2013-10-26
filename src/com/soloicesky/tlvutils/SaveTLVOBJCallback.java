package com.soloicesky.tlvutils;

public interface SaveTLVOBJCallback {
	void saveTLVOBJ(short tag, int length, byte[] value);
}
