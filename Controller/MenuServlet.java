package com.food.Controller;

import java.io.IOException;
import java.util.ArrayList;

import com.food.DAO.MenuDAO;
import com.food.DaoImpl.MenuDaoImpl;
import com.food.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")

public class MenuServlet extends HttpServlet {
	
	 
	
	

	private ArrayList<Menu> menulistByRestaurant;
	private HttpSession session;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int restaurantid=Integer.parseInt(req.getParameter("restaurantid"));
		
		
		MenuDaoImpl menulist= new MenuDaoImpl();
		
		menulistByRestaurant=menulist.fetchMenuByRestaurant(restaurantid);
		session=req.getSession();
		session.setAttribute("menuList", menulistByRestaurant);
		session.setAttribute("restaurantid", restaurantid);
		resp.sendRedirect("menu.jsp");
		
		
		
		}

	}

		
		
		
	
		
	


