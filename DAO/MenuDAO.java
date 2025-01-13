package com.food.DAO;

import java.util.ArrayList;
import java.util.List;

import com.food.Model.Menu;

public interface MenuDAO {

	
int insert(Menu m );
	
	ArrayList<Menu> fetchAll();

	Menu fetchOne(int id);
	
	ArrayList<Menu> fetchMenuByRestaurant(int Restaurantid);
	
	int update(int id,int price);
	
	
	int delete(int id); 
	
}
