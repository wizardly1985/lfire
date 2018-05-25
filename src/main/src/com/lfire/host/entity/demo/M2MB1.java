package com.lfire.host.entity.demo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class M2MB1 {
	private int id;
	private String name;
	private Set<M2MA1> m2ma1Sets;

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


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "m2ma1_m2mb1",
			/**
			 * 这一方的Id
			 */
			joinColumns = { @JoinColumn(name = "m2mb1_id") },
			/**
			 * 反转的另外一段的列名,既对方一张表的Id
			 * 
			 * @return
			 */
			inverseJoinColumns = { @JoinColumn(name = "m2ma1_id") })
	public Set<M2MA1> getM2ma1Sets() {
		return m2ma1Sets;
	}
	
	public void setM2ma1Sets(Set<M2MA1> m2ma1Sets) {
		this.m2ma1Sets = m2ma1Sets;
	}
	
}
