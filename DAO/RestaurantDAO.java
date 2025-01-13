package com.food.DAO;



import java.util.ArrayList;

import com.food.Model.Restaurant;

public interface RestaurantDAO {

	
int insert(Restaurant u);
	
	ArrayList<Restaurant> fetchAll();

	Restaurant fetchOne(int id);
	
	int update(int id,String Address);
	
	int delete(int id); 
	
}
