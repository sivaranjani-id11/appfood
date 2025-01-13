package com.food.Model;



public class Ordersitem {

	private int orderitemid;
	private int orderid;
	private int Menuid;
	private int Quantity;
	private int Itemtotal;
	
	
	public Ordersitem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ordersitem(int orderitemid, int orderid, int menuid, int quantity, int itemtotal) {
		super();
		this.orderitemid = orderitemid;
		this.orderid = orderid;
		Menuid = menuid;
		Quantity = quantity;
		Itemtotal = itemtotal;
	}


	public int getOrderitemid() {
		return orderitemid;
	}


	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}


	public int getOrderid() {
		return orderid;
	}


	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}


	public int getMenuid() {
		return Menuid;
	}


	public void setMenuid(int menuid) {
		Menuid = menuid;
	}


	public int getQuantity() {
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}


	public int getItemtotal() {
		return Itemtotal;
	}


	public void setItemtotal(int itemtotal) {
		Itemtotal = itemtotal;
	}


	@Override
	public String toString() {
		return "Ordersitem [orderitemid=" + orderitemid + ", orderid=" + orderid + ", Menuid=" + Menuid + ", Quantity="
				+ Quantity + ", Itemtotal=" + Itemtotal + "]";
	}


	
	
	
	
	
	
	
}


