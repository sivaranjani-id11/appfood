


package com.food.Controller;

import java.io.IOException;
import com.food.DAO.OrdersDAO;
import com.food.DaoImpl.Cart;
import com.food.DaoImpl.OrdersDaoImpl;
import com.food.Model.CartItem;
import com.food.Model.Orders;
import com.food.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Checkout extends HttpServlet {

    private OrdersDAO orderDAO;

    @Override
    public void init() {
        try {
            orderDAO = new OrdersDaoImpl(); // Initialize DAO
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("loggedInUser");

        // Debugging output to check session attributes
        System.out.println("Cart: " + cart);
        System.out.println("Logged-in User: " + user);

        // Check if cart and user are not null and cart is not empty
        if (cart != null && user != null && !cart.getItems().isEmpty()) {
            // Retrieve payment method from the request
            String paymentMethod = req.getParameter("paymentMethod");
            System.out.println("Payment Method: " + paymentMethod);

            // Create an order object
            Orders order = new Orders();
            order.setUserid(user.getUserid());  // Set user ID
            order.setPaymentmode(paymentMethod); // Set payment mode
            order.setStatus("Pending"); // Set initial status

            // Check if the restaurant ID is available in the session
            Integer restaurantId = (Integer) session.getAttribute("restaurantid");
            if (restaurantId != null) {
                order.setRestaurantid(restaurantId); // Set restaurant ID
            } else {
                // Handle the case where the restaurant ID is missing
                System.out.println("Restaurant ID is missing in session!");
                res.sendRedirect("errorPage.jsp"); // Redirect to an error page
                return; // Exit the method
            }

            // Calculate total amount from the cart
            float totalAmount = 0;
            for (CartItem item : cart.getItems().values()) {
                totalAmount += item.getPrice() * item.getQuantity(); // Sum of item price * quantity
            }
            order.setTotalamount(totalAmount);  // Set total amount in the order

            // Insert order into the database
            int orderId = orderDAO.insert(order);
            if (orderId > 0) {
                // Success: Clear the cart and set the order in session
                session.removeAttribute("cart");  // Remove cart from session after order
                session.setAttribute("order", order);  // Set the created order in session

                // Redirect to order confirmation page
                res.sendRedirect("OrderConfirmation.jsp");
            } else {
                // Failure: Redirect to error page
                res.sendRedirect("error.jsp");
            }
        } else {
            // If cart is empty or user is not logged in, redirect to home page
            res.sendRedirect("homefood1.jsp");
        }
    }
}




















