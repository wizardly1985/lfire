package com.lfire.host.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Cart {
	private int id;
	private Client client;
	private Set<Oder> oders;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "client_id")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	@OneToMany(mappedBy="cart",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<Oder> getOders() {
		return oders;
	}

	public void setOders(Set<Oder> oders) {
		this.oders = oders;
	}

	
}
