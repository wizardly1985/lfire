package com.lfire.host.entity.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class O2MB1 {
	private int id;
	private String name;
	private O2MA1 o2ma1;
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
	@ManyToOne
	@JoinColumn(name = "o2ma1_id")
	public O2MA1 getO2ma1() {
		return o2ma1;
	}
	public void setO2ma1(O2MA1 o2ma1) {
		this.o2ma1 = o2ma1;
	}
	
}
