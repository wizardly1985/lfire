package com.lfire.host.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author Ly
 * ¶©µ¥Ïî
 */
@Entity
public class OderItem {
	private int id;
	private Oder oder;
	private Goods goods;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "oder_id")
	public Oder getOder() {
		return oder;
	}
	public void setOder(Oder oder) {
		this.oder = oder;
	}
	@OneToOne
	@JoinColumn(name  = "goods_id")
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	
}
