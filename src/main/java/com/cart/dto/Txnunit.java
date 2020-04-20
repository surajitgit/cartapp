package com.cart.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Txnunit {
	private Long id;
	private int itemid;
	private int currunit;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getCurrunit() {
		return currunit;
	}
	public void setCurrunit(int currunit) {
		this.currunit = currunit;
	}
	
}
