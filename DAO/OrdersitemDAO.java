package com.food.DAO;




import java.util.ArrayList;

import com.food.Model.Ordersitem;



public interface OrdersitemDAO 

{
int insert(Ordersitem oi);
	
	ArrayList<Ordersitem> fetchAll();

	Ordersitem fetchOne(int id);
	
	int update(int id,int Quantity);
	
	int delete(int id); 
	
}

