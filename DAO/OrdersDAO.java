package com.food.DAO;




import java.util.ArrayList;

import com.food.Model.Orders;



public interface OrdersDAO {

	
	
	
	int insert(Orders u);
	
	ArrayList<Orders> fetchAll();

	Orders fetchOne(int orderid);
	
	int update(int id,String password);
	
	int delete(int id); 
	
}

