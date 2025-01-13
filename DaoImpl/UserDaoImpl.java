package com.food.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.food.DAO.*;
import com.food.Model.User;
import com.food.Util.DBconnection;


public class UserDaoImpl implements UserDAO {

	

	public ArrayList<User>UserList=new ArrayList<User>();
	private static final String INSERTQUERY="insert into user(username,password,email,address) values(?,?,?,?)";
	private static final String FETCHALL="select*from user";
	private static final String FETCHONE="select*from user where Userid=?";
	private static final String UPDATE="update user set password=? where Userid=?";
	private static final String DELETE="delete from user where Userid=?";
	
	
	
	static Connection con;
	
	static
	{
		con=DBconnection.connect();
		
		
	}
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private User u;
	
	@Override
	public int insert(User u) {
		
		try
		{
			pstmt=con.prepareStatement(INSERTQUERY);
			//pstmt.setInt(1, u.getUserid());
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getAddress());
			
			
			return pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<User>fetchAll()
	{
		try {
			stmt=con.createStatement()	;	
			resultSet=stmt.executeQuery(FETCHALL);
			
			
			UserList=extractUserListFromResultSet(resultSet);
			
			}
			
		
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return UserList;
	}
	
	
	@Override
	public User fetchOne(int id)
	{
		
		try
		{
		pstmt=con.prepareStatement(FETCHONE);
		
		pstmt.setInt(1,id);
		resultSet=pstmt.executeQuery();
		UserList=extractUserListFromResultSet(resultSet);
		if (!UserList.isEmpty()) {
            u = UserList.get(0);
        }
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
		
		
	}
	
	ArrayList<User>extractUserListFromResultSet(ResultSet resultSet)
	{
		try
		{
			
			
			while(resultSet.next())
			{
				UserList.add(new User(
						resultSet.getInt("Userid"),
						resultSet.getString("Username"),
						resultSet.getString("Password"),
						resultSet.getString("Email"),
						resultSet.getString("Address")
						)
						);
				
				
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return UserList;
	}

	@Override
	public int update(int id,String password) {
	
		
		
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			//pstmt.setInt(1,id);
			pstmt.setString(1,password);
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
