package com.lfire.host.entity.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class O2OB1 {

	private int id;
	private String name;
	private O2OA1 o2oa;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToOne
	@JoinColumn(name = "o2oa_id")
	public O2OA1 getO2oa() {
		return o2oa;
	}

	public void setO2oa(O2OA1 o2oa) {
		this.o2oa = o2oa;
	}
	
}
