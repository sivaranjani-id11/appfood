<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.food.Model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodApp - Explore Restaurants</title>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <!-- Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        /* General Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f3e5f5;
            color: #333;
            line-height: 1.6;
        }

        /* Navigation Bar */
        nav {
            background-color: #7b1fa2;
            color: #fff;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        nav .logo {
            font-size: 1.8rem;
            font-weight: 600;
        }

        nav ul {
            list-style: none;
            display: flex;
        }

        nav ul li {
            margin: 0 15px;
        }

        nav ul li a {
            text-decoration: none;
            color: #fff;
            font-size: 1rem;
            transition: color 0.3s ease;
        }

        nav ul li a:hover {
            color: #d1c4e9;
        }

        /* Search Bar */
        .search-container {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }

        .search-container input {
            width: 50%;
            padding: 10px 15px;
            border: 2px solid #7b1fa2;
            border-radius: 5px 0 0 5px;
            font-size: 1rem;
            outline: none;
        }

        .search-container button {
            padding: 10px 20px;
            background-color: #7b1fa2;
            border: none;
            border-radius: 0 5px 5px 0;
            color: #fff;
            cursor: pointer;
            font-size: 1rem;
            transition: background 0.3s ease;
        }

        .search-container button:hover {
            background-color: #6a1b9a;
        }

        /* Restaurant Cards */
        .container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            padding: 20px;
            max-width: 1200px;
            margin: auto;
        }

        .card {
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-8px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .restaurant-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-bottom: 2px solid #7b1fa2;
        }

        .card-content {
            padding: 15px;
        }

        .card-content h2 {
            font-size: 1.4rem;
            margin-bottom: 10px;
            color: #7b1fa2;
        }

        .card-content p {
            font-size: 0.9rem;
            color: #666;
            margin: 5px 0;
        }

        .badge {
            display: inline-block;
            padding: 5px 10px;
            background-color: #4CAF50;
            color: #fff;
            border-radius: 5px;
            font-size: 0.8rem;
        }

        /* Footer */
        footer {
            background-color: #4a148c;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <!-- Navigation Bar -->
    <nav>
        <div class="logo">FoodApp</div>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">Restaurants</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </nav>

    <!-- Search Bar -->
    <div class="search-container">
        <input type="text" placeholder="Search for restaurants, cuisines, or dishes..." />
        <button><i class="fa fa-search"></i> Search</button>
    </div>

    <!-- Restaurant Cards -->
    <div class="container">
        <%
            List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
            if (restaurantList != null && !restaurantList.isEmpty()) {
                for (Restaurant restaurant : restaurantList) {
        %>
            <a href="menu?restaurantid=<%= restaurant.getRestaurantid() %>" style="text-decoration: none; color: inherit;">
                <div class="card">
                    <img src="<%= restaurant.getImagepath() %>" alt="<%= restaurant.getName() %>" class="restaurant-image" />
                    <div class="card-content">
                        <h2><%= restaurant.getName() %></h2>
                        <p><strong>Cuisine:</strong> <%= restaurant.getCusinetype() %></p>
                        <p><strong>Delivery Time:</strong> <%= restaurant.getDeliverytime() %> min</p>
                        <p><strong>Address:</strong> <%= restaurant.getAddress() %></p>
                        <p><strong>Rating:</strong> ⭐ <%= restaurant.getRating() %>/5</p>
                        <span class="badge"><%= restaurant.getIsactive() == 1 ? "Active" : "Inactive" %></span>
                    </div>
                </div>
            </a>
        <%
                }
            } else {
        %>
            <p style="text-align: center; font-size: 1.2rem; color: #666;">No restaurants available at the moment. Check back later!</p>
        <%
            }
        %>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 FoodApp. All Rights Reserved.</p>
    </footer>

</body>
</html>
