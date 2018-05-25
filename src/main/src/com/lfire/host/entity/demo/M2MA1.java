package com.lfire.host.entity.demo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class M2MA1 {
	private int id;
	private String name;
	private Set<M2MB1> m2mb1Sets;
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
	@ManyToMany(mappedBy = "m2ma1Sets",cascade = CascadeType.ALL)
	public Set<M2MB1> getM2mb1Sets() {
		return m2mb1Sets;
	}
	public void setM2mb1Sets(Set<M2MB1> m2mb1Sets) {
		this.m2mb1Sets = m2mb1Sets;
	}
	
	
}
