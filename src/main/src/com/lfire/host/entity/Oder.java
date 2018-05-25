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

/**
 * @author Ly
 * ¶©µ¥
 */
@Entity
public class Oder {

	private int id;
	private Cart cart;
	private Set<OderItem> oderItems;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name  = "cart_id")
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@OneToMany(mappedBy = "oder",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<OderItem> getOderItems() {
		return oderItems;
	}

	public void setOderItems(Set<OderItem> oderItems) {
		this.oderItems = oderItems;
	}
	
	
	
}
