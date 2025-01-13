package com.food.Model;

public class Menu {

	
	
	private int Menuid;
	private int Restaurantid;
	private String Name;
	private String Description;
	private int Price;
	private int Isavailable;
	private String Imagepath;
	private int Quantity;
	
	
	
	public int getQuantity() {
		return Quantity;
	}



	public void setQuantity(int quantity) {
		Quantity = quantity;
	}



	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Menu(int menuid, int restaurantid, String name, String description, int price, int isavailable,
			String imagepath) {
		super();
		Menuid = menuid;
		Restaurantid = restaurantid;
		Name = name;
		Description = description;
		Price = price;
		Isavailable = isavailable;
		Imagepath = imagepath;
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



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public int getPrice() {
		return Price;
	}



	public void setPrice(int price) {
		Price = price;
	}



	public int getIsavailable() {
		return Isavailable;
	}



	public void setIsavailable(int isavailable) {
		Isavailable = isavailable;
	}



	public String getImagepath() {
		return Imagepath;
	}



	public void setImagepath(String imagepath) {
		Imagepath = imagepath;
	}



	@Override
	public String toString() {
		return "Menu [Menuid=" + Menuid + ", Restaurantid=" + Restaurantid + ", Name=" + Name + ", Description="
				+ Description + ", Price=" + Price + ", Isavailable=" + Isavailable + ", Imagepath=" + Imagepath + "]";
	}
	
	
	
	
	
	
}
