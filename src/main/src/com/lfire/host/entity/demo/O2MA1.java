package com.lfire.host.entity.demo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Ly
 * Ë«Ïò¹ØÁª
 */
@Entity
public class O2MA1 {
	private int id;
	private String name;
	private Set<O2MB1> sets;
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
	@OneToMany(mappedBy="o2ma1",cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	public Set<O2MB1> getSets() {
		return sets;
	}
	public void setSets(Set<O2MB1> sets) {
		this.sets = sets;
	}
}
