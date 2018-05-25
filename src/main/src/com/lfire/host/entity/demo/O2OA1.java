package com.lfire.host.entity.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class O2OA1 {
	private int id;
	private String name;
	private O2OB1 o2ob;
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
	@JoinColumn(name = "o2ob_id")
	public O2OB1 getO2ob() {
		return o2ob;
	}

	public void setO2ob(O2OB1 o2ob) {
		this.o2ob = o2ob;
	}

}
