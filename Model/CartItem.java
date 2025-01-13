package com.food.Model;

public class CartItem {

	private int Menuid;
	private int Restaurantid;
	private String Name;	
	private int Price;
	private int Quantity;
	private String imagepath;
	
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CartItem(int menuid, int restaurantid, String name, int price, int quantity) {
		super();
		Menuid = menuid;
		Restaurantid = restaurantid;
		Name = name;
		Price = price;
		Quantity = quantity;
		this.imagepath=imagepath;
	}


	public int getMenuid() {
		return Menuid;
	}


	public void setMenuid(int menuid) {
		Menuid = menuid;
	}


	public int getRestaurantid() {
		return Restaurantid;
	}


	public void setRestaurantid(int restaurantid) {
		Restaurantid = restaurantid;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getPrice() {
		return Price;
	}


	public void setPrice(int price) {
		Price = price;
	}


	public int getQuantity() {
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getImagepath() {
        return imagepath;
    }

    public void setImagePath(String imagePath) {
        this.imagepath = imagePath;
    }

	
	
	
	
}
