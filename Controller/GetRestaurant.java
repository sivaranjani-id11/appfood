package com.food.Controller;

import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.List;

import com.food.Model.Restaurant;
import com.food.DaoImpl.RestaurantDaoImpl;
import com.food.DAO.RestaurantDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet {

	
	private List<Restaurant> restaurantList;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		Cookie[] cookies = req.getCookies();
        String username = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }
        
        if (username != null) 
		{
			RestaurantDAO pdao=new RestaurantDaoImpl();
			
			restaurantList=pdao.fetchAll();
			HttpSession session=req.getSession();
			session.setAttribute("restaurantList", restaurantList);
			
			resp.sendRedirect("homefood1.jsp");
			
			
		}
		
		else
		{
			resp.sendRedirect("login.html");
		}
		
		
		
	}
	}
	

