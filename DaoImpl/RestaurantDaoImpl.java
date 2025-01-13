package com.food.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.food.DAO.RestaurantDAO;
import com.food.Util.DBconnection;
import com.food.Model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDAO {

	

	
	
	public ArrayList<Restaurant>RestaurantList=new ArrayList<Restaurant>();
	private static final String INSERTQUERY="insert into Restaurant(Restaurantid,Name,Cusinetype,Deliverytime,Address,Rating,Isactive,Imagepath) values(?,?,?,?,?,?,?,?)";
	private static final String FETCHALL="select*from restaurant";
	private static final String FETCHONE="select*from restaurant where restaurantid=?";
	private static final String UPDATE="update restaurant set Address=? where restaurantid=?";
	private static final String DELETE="delete from restaurant where restaurantid=?";
	
	
	
	static Connection con;
	
	static
	{
		con=DBconnection.connect();
		
		
	}
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Restaurant  r;
	
	@Override
	public int insert(Restaurant  r) {
		
		try
		{
			pstmt=con.prepareStatement(INSERTQUERY);
			
			pstmt.setInt(1, r.getRestaurantid());
			pstmt.setString(2, r.getName());
			pstmt.setString(3, r.getCusinetype());
			pstmt.setInt(4, r.getDeliverytime());
			pstmt.setString(5,r.getAddress());
			pstmt.setFloat(6,r.getRating());
			pstmt.setInt(7,r.getIsactive());
			pstmt.setString(8, r.getImagepath());
			
			
			return pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<Restaurant>fetchAll()
	{
		try {
			stmt=con.createStatement()	;	
			resultSet=stmt.executeQuery(FETCHALL);
			
			
			RestaurantList=extractRestaurantListFromResultSet(resultSet);
			
			}
			
		
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return RestaurantList;
	}
	
	
	@Override
	public Restaurant fetchOne(int id)
	{
		
		try
		{
		pstmt=con.prepareStatement(FETCHONE);
		
		pstmt.setInt(1,id);
		resultSet=pstmt.executeQuery();
		RestaurantList=extractRestaurantListFromResultSet(resultSet);
		r=RestaurantList.get(0);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
		
		
	}
	
	ArrayList<Restaurant>extractRestaurantListFromResultSet(ResultSet resultSet)
	{
		try
		{
			
			
			while(resultSet.next())
			{
				RestaurantList.add(new Restaurant(
						resultSet.getInt("Restaurantid"),
						resultSet.getString("Name"),
						resultSet.getString("Cusinetype"),
						resultSet.getInt("Deliverytime"),
						resultSet.getString("Address"),
						resultSet.getFloat("Rating"),
						resultSet.getInt("Isactive"),
						resultSet.getString("Imagepath")
						)
						);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return RestaurantList;
	}

	@Override
	public int update(int id,String Address) {
	
		
		
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			//pstmt.setInt(1,id);
			pstmt.setString(1,Address);
			pstmt.setInt(2,id);
			return pstmt.executeUpdate();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
			
		}
		
	}

	@Override
	public int delete(int id) {
		
		try
		{
			pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
}





