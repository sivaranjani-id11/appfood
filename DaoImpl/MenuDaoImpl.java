package com.food.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.Util.DBconnection;
import com.food.Model.Menu;
import com.food.DAO.MenuDAO;
public class MenuDaoImpl implements MenuDAO {

	
	
	public ArrayList<Menu>MenuList=new ArrayList<Menu>();
	private static final String INSERTQUERY="insert into Menu(Menuid,Restaurantid,Name,Description,Price,Isavailable,Imagepath) values(?,?,?,?,?,?,?)";
	private static final String FETCHALL="select*from Menu";
	private static final String FETCHONE="select*from Menu where Menuid=?";
	private static final String FETCHONE_BYRESTAURANT="select*from menu where Restaurantid=?";
	private static final String UPDATE="update Menu set Price=? where Menuid=?";
	private static final String DELETE="delete from Menu where Menuid=?";
	
	
	
	static Connection con;
	
	static
	{
		con=DBconnection.connect();
		
		
	}
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Menu m;
	
	@Override
	public int insert(Menu m) {
		
		try
		{
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1,m.getMenuid());
			pstmt.setInt(2, m.getRestaurantid());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getDescription());
			pstmt.setInt(5, m.getPrice());
			pstmt.setInt(6,m.getIsavailable());
			pstmt.setString(7, m.getImagepath());
			
			
			return pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	
	@Override
	public ArrayList<Menu>fetchAll()
	{
		try {
			stmt=con.createStatement()	;	
			resultSet=stmt.executeQuery(FETCHALL);
			
			
			MenuList=extractMenuListFromResultSet(resultSet);
			
			}
			
		
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return MenuList;
	}
	
	
	@Override
	public Menu fetchOne(int id)
	{
		
		try
		{
		pstmt=con.prepareStatement(FETCHONE);
		
		pstmt.setInt(1,id);
		resultSet=pstmt.executeQuery();
		MenuList=extractMenuListFromResultSet(resultSet);
		m=MenuList.get(0);
		}
		
		catch(SQLException  e)
		{
			throw new RuntimeException("Error retrieving menu Item:",e);
			//e.printStackTrace();
		}
		return m;
		
		
	}
	
	ArrayList<Menu>extractMenuListFromResultSet(ResultSet resultSet)
	{
		try
		{
			
			
			while(resultSet.next())
			{
				MenuList.add(new Menu(
						resultSet.getInt("Menuid"),
						resultSet.getInt("Restaurantid"),
						resultSet.getString("Name"),
						resultSet.getString("Description"),
						resultSet.getInt("Price"),
						resultSet.getInt("Isavailable"),
						resultSet.getString("Imagepath")
						)
						);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return MenuList;
	}

	
	
	@Override
	public  ArrayList<Menu> fetchMenuByRestaurant(int Restaurantid)
	{
//		List<Menu>menulist=new ArrayList<>();
		//ArrayList<Menu> arrayList = new ArrayList<Menu>();
		try
		{
			pstmt=con.prepareStatement(FETCHONE_BYRESTAURANT);
			pstmt.setInt(1, Restaurantid);
			
			resultSet=pstmt.executeQuery();
			MenuList=extractMenuListFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return MenuList;
	}
			
	
	
	
	
	@Override
	public int update(int id,int price) {
	
		
		
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			//pstmt.setInt(1,id);
			pstmt.setInt(1,price);
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
