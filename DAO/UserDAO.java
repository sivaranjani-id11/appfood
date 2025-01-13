package com.food.DAO;

import java.util.ArrayList;
import com.food.DAO.*;
import com.food.Model.User;


public interface UserDAO {

	
	
	
int insert(User u);
	
	ArrayList<User> fetchAll();

	User fetchOne(int id);
	
	int update(int id,String password);
	
	int delete(int id); 
	

}
