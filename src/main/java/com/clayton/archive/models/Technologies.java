package com.clayton.archive.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Technologies {
	@Id
	private int _id;
	private String name;
	private String src;
	
	public Technologies() {}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	
}
