package com.food.Model;



public class Restaurant {

	private int Restaurantid;
	private String Name;
	private String Cusinetype;
	private int  Deliverytime;
	private String Address;
	private float Rating;
	private int Isactive;
	private String Imagepath;
	
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Restaurant(int restaurantid, String name, String cusinetype, int deliverytime, String address,
			float rating, int isactive, String imagepath) {
		super();
		Restaurantid = restaurantid;
		Name = name;
		Cusinetype = cusinetype;
		Deliverytime = deliverytime;
		Address = address;
		Rating = rating;
		Isactive = isactive;
		Imagepath = imagepath;
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


	public String getCusinetype() {
		return Cusinetype;
	}


	public void setCusinetype(String cusinetype) {
		Cusinetype = cusinetype;
	}


	public int getDeliverytime() {
		return Deliverytime;
	}


	public void setDeliverytime(int deliverytime) {
		Deliverytime = deliverytime;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public float getRating() {
		return Rating;
	}


	public void setRating(float rating) {
		Rating = rating;
	}


	public int getIsactive() {
		return Isactive;
	}


	public void setIsactive(int isactive) {
		Isactive = isactive;
	}


	public String getImagepath() {
		return Imagepath;
	}


	public void setImagepath(String imagepath) {
		Imagepath = imagepath;
	}


	@Override
	public String toString() {
		return "Restaurant [Restaurantid=" + Restaurantid + ", Name=" + Name + ", Cusinetype=" + Cusinetype
				+ ", Deliverytime=" + Deliverytime + ", Address=" + Address + ", Rating=" + Rating + ", Isactive="
				+ Isactive + ", Imagepath=" + Imagepath + "]";
	}


	
	
	
	

	}


