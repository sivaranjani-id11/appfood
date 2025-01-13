package com.food.Controller;

import java.io.IOException;

import com.food.DAO.MenuDAO;
import com.food.DaoImpl.Cart;
import com.food.DaoImpl.MenuDaoImpl;
import com.food.Model.CartItem;
import com.food.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        int menuId = Integer.parseInt(request.getParameter("menuId"));

        MenuDAO menuDAO = new MenuDaoImpl();

        if ("add".equals(action)) {
            Menu menuItem = menuDAO.fetchOne(menuId);
            if (menuItem != null) {
                CartItem cartItem = new CartItem(menuItem.getMenuid(), menuItem.getRestaurantid(), 
                                                 menuItem.getName(), menuItem.getPrice(), 1);
                
                cartItem.setImagePath(menuItem.getImagepath());
                cart.addItem(cartItem);
            }
        } else if ("update".equals(action)) {
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            cart.updateItem(menuId, quantity);
        } else if ("remove".equals(action)) {
            cart.removeItem(menuId);
        } else {
            cart.clear();
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("Cart.jsp");
    }
}






























