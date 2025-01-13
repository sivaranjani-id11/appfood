package com.food.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.tap.secure.MyEncrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	
	private Connection con;
	private PreparedStatement pstmt;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String username=MyEncrypt.encrypt(req.getParameter("username"));
		String email=MyEncrypt.encrypt(req.getParameter("email"));
		
		String address=MyEncrypt.encrypt(req.getParameter("address"));
		
		String password=MyEncrypt.encrypt(req.getParameter("password"));
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapplication","root","root");
			
			String insert="insert into User(Username,email,address,password)values(?,?,?,?)";
			pstmt=con.prepareStatement(insert);
			
			pstmt.setString(1, username);
			pstmt.setString(2,email);
			//pstmt.setString(3,mobile);
			pstmt.setString(3,address);
			//pstmt.setString(5,city);
			pstmt.setString(4,password);
			
			
			
			if(pstmt.executeUpdate()==1)
			{
				//resp.sendRedirect("success.jsp");
				resp.sendRedirect("loginfood.jsp");
				
			}
			else
			{		
				resp.sendRedirect("failure.jsp");
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


			

}

