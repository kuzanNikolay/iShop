package edu.ishop.model;

import java.io.Serializable;

public abstract class Model  implements Serializable{
	private long Id;
	private String name;

	public Model(){
		Id = 0l;
	}
	public Model(long id) {
		Id = id;
	}

	public long getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		Id = id;
	}

}
