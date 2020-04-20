package com.cart.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="txnrecord")
public class Txnrecord {
	private Long id;
	private int itemid;
	private int amount;
	private int unitpurch;
	private Date buyoutdt;
	private String purchby;

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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUnitpurch() {
		return unitpurch;
	}
	public void setUnitpurch(int unitpurch) {
		this.unitpurch = unitpurch;
	}
	public Date getBuyoutdt() {
		return buyoutdt;
	}
	public void setBuyoutdt(Date buyoutdt) {
		this.buyoutdt = buyoutdt;
	}
	public String getPurchby() {
		return purchby;
	}
	public void setPurchby(String purchby) {
		this.purchby = purchby;
	}
	
}
