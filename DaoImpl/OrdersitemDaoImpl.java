package com.food.DaoImpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.food.DAO.OrdersitemDAO;
import com.food.Model.Ordersitem;
import com.food.Util.DBconnection;


public class OrdersitemDaoImpl implements OrdersitemDAO 

{

	
	public ArrayList<Ordersitem>OrderitemList=new ArrayList<Ordersitem>();
	private static final String INSERTQUERY="insert into Ordersitems(orderitemid,orderid,Menuid,Quantity,Itemtotal) values(?,?,?,?,?)";
	private static final String FETCHALL="select*from Ordersitems";
	private static final String FETCHONE="select*from Ordersitems where orderitemid=?";
	private static final String UPDATE="update Ordersitems set Quantity=? where Orderitemid=?";
	private static final String DELETE="delete from Ordersitems where Orderitemid=?";
	
	
	
	static Connection con;
	
	static
	{
		con=DBconnection.connect();
		
		
	}
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Ordersitem oi;
	
	@Override
	public int insert(Ordersitem oi) {
		
		try
		{
			pstmt=con.prepareStatement(INSERTQUERY);
			pstmt.setInt(1, oi.getOrderitemid());
			pstmt.setInt(2, oi.getOrderid());
			pstmt.setInt(3, oi.getMenuid());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setInt(5, oi.getItemtotal());
			
			
			return pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ArrayList<Ordersitem>fetchAll()
	{
		try {
			stmt=con.createStatement()	;	
			resultSet=stmt.executeQuery(FETCHALL);
			
			
			OrderitemList=extractOrderitemListFromResultSet(resultSet);
			
			}
			
		
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return OrderitemList;
	}
	
	
	@Override
	public Ordersitem fetchOne(int id)
	{
		
		try
		{
		pstmt=con.prepareStatement(FETCHONE);
		
		pstmt.setInt(1,id);
		resultSet=pstmt.executeQuery();
		OrderitemList=extractOrderitemListFromResultSet(resultSet);
		oi=OrderitemList.get(0);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return oi;
		
		
	}
	
	ArrayList<Ordersitem>extractOrderitemListFromResultSet(ResultSet resultSet)
	{
		try
		{
			
			
			while(resultSet.next())
			{
				OrderitemList.add(new Ordersitem(
						resultSet.getInt("orderitemid"),
						resultSet.getInt("orderid"),
						resultSet.getInt("Menuid"),
						resultSet.getInt("Quantity"),
						resultSet.getInt("Itemtotal")
						
						)
						);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return OrderitemList;
	}

	@Override
	public int update(int id,int Quantity) {
	
		
		
		try
		{
			pstmt=con.prepareStatement(UPDATE);
			//pstmt.setInt(1,id);
			pstmt.setInt(1,Quantity);
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


