package com.food.Model;

public class User {

	
	private int Userid;
	private String Username;
	private  String password;
	private  String Email;
	private  String Address;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User( int userid,String username, String password, String email, String address) {
		super();
		Userid = userid;
		Username = username;
		this.password = password;
		Email = email;
		Address = address;
	}
	
	public int getUserid() {
		return Userid;
	}


	public void setUserid(int userid) {
		Userid = userid;
	}


	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	   
	



	@Override
	public String toString() {
		return "User [userid="+ Userid +", Username=" + Username + ", password=" + password + ", Email=" + Email
				+ ", Address=" + Address + "]";
	}
	
}
