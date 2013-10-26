package com.soloicesky.tlvutils;

public class TLV {
	private short tag;
	private int   length;
	private byte[] value;
	
	public TLV()
	{
		
	}
	
	public TLV(short t, int l, byte[] v)
	{
		this.tag = t;
		this.length = l;
		this.value = v;
	}

	public short getTag() {
		return tag;
	}

	public void setTag(short tag) {
		this.tag = tag;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public byte[] getValue() {
		return value;
	}

	public void setValue(byte[] value) {
		this.value = value;
	}
	
	
}
