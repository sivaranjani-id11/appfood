<%@ page import="java.util.List" %>
<%@ page import="com.food.Model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <title>Our Menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
         
        h1 {
            text-align: center;
            margin: 20px 0;
            color: #8A2BE2; /* Dark violet color for "Our Menu" */
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }
        .menu-card {
            background: #fff;
            border: 2px solid violet; /* Violet border */
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            width: 300px; /* Fixed width for uniform size */
            height: 450px; /* Fixed height for uniform size */
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .menu-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }
        .menu-image {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }
        .menu-content {
            padding: 15px;
        }
        .menu-content h2 {
            margin: 10px 0;
            font-size: 1.5rem;
            color: #333;
        }
        .menu-content p {
            margin: 5px 0;
            color: #555;
        }
        .menu-content .price {
            font-weight: bold;
            color: #28a745;
        }
        .availability {
            display: inline-block;
            padding: 5px 15px;
            font-size: 0.9rem;
            font-weight: bold;
            color: #fff;
            text-transform: uppercase;
            margin: 10px 0;
            position: relative;
        }
        .availability.available {
            background-color: #28a745;
            clip-path: polygon(0% 0%, 95% 0%, 100% 50%, 95% 100%, 0% 100%);
        }
        .availability.unavailable {
            background-color: #dc3545;
            clip-path: polygon(0% 0%, 95% 0%, 100% 50%, 95% 100%, 0% 100%);
        }
        .add-to-cart {
            display: inline-block;
            padding: 10px 20px;
            font-size: 1rem;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-transform: uppercase;
            transition: background-color 0.3s ease;
        }
        .add-to-cart:disabled {
            background-color: #6c757d;
            cursor: not-allowed;
        }
        .add-to-cart:hover:not(:disabled) {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Our Menu</h1>

    <%
        // Retrieve the menu list from the session
        List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
    %>

    <div class="container">
        <% if (menuList != null && !menuList.isEmpty()) { %>
            <% for (Menu menu : menuList) { %>
                <div class="menu-card">
                    <img src="<%= menu.getImagepath() %>" alt="<%= menu.getName() %>" class="menu-image">
                    <div class="menu-content">
                        <h2><%= menu.getName() %></h2>
                        <p><strong>Description:</strong> <%= menu.getDescription() %></p>
                        <p><span class="price">Price: <%= menu.getPrice() %></span></p>
                        <div class="availability <%= menu.getIsavailable() == 1 ? "available" : "unavailable" %>">
                            <%= menu.getIsavailable() == 1 ? "Available" : "Unavailable" %>
                        </div>
                        
                        <form action="CartServlet" method="post">
                            <input type="hidden" name="menuId" value="<%= menu.getMenuid() %>">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="quantity" value="1">
                            <button class="add-to-cart" <%= menu.getIsavailable() == 1 ? "" : "disabled" %>>Add to Cart</button>
                        </form>
                    </div>
                </div>
            <% } %>
        <% } else { %>
            <p style="text-align: center; font-size: 1.2rem; color: #666;">No menu items available at the moment. Check back later!</p>
        <% } %>
    </div>
</body>
</html>
