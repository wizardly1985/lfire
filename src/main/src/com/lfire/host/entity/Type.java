package com.lfire.host.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Type {
	private int id;
	private String name;
	private Type parent;
	private Set<Type> children;
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
	@JoinColumn(name = "parentid")
	public Type getParent() {
		return parent;
	}

	public void setParent(Type parent) {
		this.parent = parent;
	}

//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="children") 
	@OneToMany(fetch=FetchType.EAGER, mappedBy="children") 
	public Set<Type> getChildren() {
		return children;
	}

	public void setChildren(Set<Type> children) {
		this.children = children;
	}

}
