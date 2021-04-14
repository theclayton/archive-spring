package com.clayton.archive.models;

public class Triple {
	private int pos;
	private String name;
	private int value;
	
	public Triple (int pos, String name, int value) {
		this.pos = pos;
		this.name = name;
		this.value = value;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
