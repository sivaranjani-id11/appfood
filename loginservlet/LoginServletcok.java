package com.loginservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.annotation.WebServlet;

import com.food.Model.User;
import com.tap.secure.MyDecrypt;
import com.tap.secure.MyEncrypt;
 

import jakarta.servlet.http.Cookie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServletcok
 */


		
		@WebServlet("/LoginServletcok")
		public class LoginServletcok extends HttpServlet {

		    private Connection con;
		    private String checkEmail = "SELECT * FROM User WHERE EMAIL=?";
		    private PreparedStatement pstmt;
		    private ResultSet res;

		    @Override
		    public void init() throws ServletException {
		        String url = "jdbc:mysql://localhost:3306/foodapplication";
		        String username = "root";
		        String password = "root";

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection(url, username, password);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    @Override
		    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		        HttpSession session = req.getSession();
		        String email = MyEncrypt.encrypt(req.getParameter("email"));
		        String pwd = MyEncrypt.encrypt(req.getParameter("password"));

		        System.out.println(email);
		        System.out.println(pwd);

		        try {
		            pstmt = con.prepareStatement(checkEmail);
		            pstmt.setString(1, email);
		            res = pstmt.executeQuery();

		            if (res.next()) {
		                if (pwd.equals(res.getString("password"))) {
		                    String username = res.getString("username");
		                    email = res.getString("email");
		                    String address = res.getString("address");
		                    int userId = res.getInt("Userid");

		                   /* // Fetch or initialize Restaurant ID for the user
		                    int restaurantId = getRestaurantid(userId); // Call the method here
		                    if (restaurantId != -1) { 
		                        session.setAttribute("restaurantId", restaurantId); // Save in session
		                    } else {
		                        System.out.println("No default restaurant found for the user.");
		                    }*/

		                    // Save other user details in session
		                    session.setAttribute("username", MyDecrypt.decrypt(username));
		                    session.setAttribute("email", MyDecrypt.decrypt(email));
		                    session.setAttribute("address", MyDecrypt.decrypt(address));
		                    session.setAttribute("userId", userId);

		                    User user = new User(userId, username, pwd, email, address); // Create User object
		                    session.setAttribute("loggedInUser", user);

		                    Cookie ck1 = new Cookie("username", username);
		                    resp.addCookie(ck1);

		                    req.getRequestDispatcher("GetRestaurant").forward(req, resp); // Redirect
		                } else {
		                    resp.sendRedirect("PasswordMismatch.html");
		                }
		            } else {
		                resp.sendRedirect("Invaliduser.html");
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }

		    // Add the getRestaurantid method here
		    private int getRestaurantid(int userId) {
		        String query = "SELECT restaurantId FROM UserRestaurantMapping WHERE userId = ?";
		        
		        try (PreparedStatement stmt = con.prepareStatement(query)) 
		        {
		            stmt.setInt(1, userId);
		            ResultSet rs = stmt.executeQuery();
		            if (rs.next()) 
		            {
		                return rs.getInt("restaurantId"); // Fetch and return the restaurantId
		            }
		        } catch (Exception e)
		        {
		            e.printStackTrace();
		        }
		        return -1; // Return -1 if no restaurant is found or an error occurs
		    }
		}

		
		
		





   

