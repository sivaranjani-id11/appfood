<%@ page import="com.food.Model.CartItem, com.food.DaoImpl.Cart" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <style>
        /* General body styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('https://png.pngtree.com/background/20220915/original/pngtree-background-for-food-pastel-picture-image_1918097.jpg');
            background-size: cover; /* Ensures the image covers the entire page */
            background-repeat: no-repeat;
            background-attachment: fixed; /* Keeps the image fixed during scrolling */
        }

        /* Cart Container */
        .cart-container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            border-radius: 10px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }

        /* Heading */
        h1 {
            text-align: center;
            color: darkviolet;
            font-size: 2.5em;
            margin-bottom: 20px;
        }

        /* Empty Cart Section */
        .empty-cart {
            text-align: center;
            padding: 20px;
            background-color: #f8f8f8;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .empty-cart p {
            font-size: 18px;
            color: #777;
        }

        .empty-cart a {
            color: #007BFF;
            text-decoration: none;
            font-weight: bold;
        }

        /* Cart Item Section */
        .item {
            display: flex; /* Use flexbox for the layout */
            border: 3px solid darkviolet; /* Increased border thickness */
            padding: 20px;
            margin-bottom: 15px;
            background-color: #f9f9f9;
            border-radius: 5px;
            align-items: center; /* Vertically align items */
        }

        .item img {
            width: 150px; /* Increased image size */
            height: 150px; /* Increased image size */
            margin-left: 20px; /* Add space between image and text */
            border-radius: 5px;
            
            border: 6px solid  #8A2BE2; ; /* Dark red border */
        }

        .item h3 {
            font-size: 20px;
            color:  #FF0000; 
            margin: 0;
        }

        .item p {
            font-size: 16px;
            color: #555;
            margin: 5px 0;
        }

        /* Container for the text part (price, total, etc.) */
        .item-text {
            flex-grow: 1; /* Allow this section to take remaining space */
        }

        /* Update Quantity Buttons */
        .update-quantity-form {
            display: inline-block;
            margin-top: 10px;
        }

        .update-quantity-form button {
            padding: 5px 10px;
            font-size: 16px;
            border: none;
            background-color: #f0f0f0;
            cursor: pointer;
        }

        .update-quantity-form span {
            padding: 5px 10px;
            font-size: 16px;
            background-color: #f0f0f0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        /* Remove Item Button */
        .remove-item-form button {
            margin-top: 10px;
            padding: 8px 15px;
            font-size: 16px;
            background-color:#8B0000;;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .remove-item-form button:hover {
            background-color: #E5533D;
        }

        /* Total Amount Section */
        .total {
            text-align: right;
            padding: 15px;
            font-size: 18px;
            background-color: #f1f1f1;
            border: 1px solid red; /* Red border */
            border-radius: 5px;
        }

        .total h2 {
            margin: 0;
            font-size: 22px;
            color: #333;
        }

        /* Links */
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 25px;
            font-size: 16px;
            color: white;
            background-color: #007BFF;
            text-decoration: none;
            border-radius: 5px;
        }

        a:hover {
            background-color: #0056b3;
        }

        /* Add More Button */
        a:nth-child(2) {
            background-color: #28a745;
        }

        a:nth-child(2):hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="cart-container">
        <h1>Your Cart</h1>
        <%
            // Retrieve the cart from the session
            Cart cart = (Cart) session.getAttribute("cart");
        
            if (cart == null || cart.getItems().isEmpty()) {
        %>
            <div class="empty-cart">
                <p>Your Cart is Empty</p>
                <a href="menu.jsp">Browse Menu</a>
            </div>
        <%
            } else {
                int restaurantid = 0;
                if (!cart.getItems().isEmpty()) {
                    restaurantid = cart.getItems().values().iterator().next().getRestaurantid();
                }

                double totalAmount = 0;
                for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
                    CartItem item = entry.getValue();
                    totalAmount += item.getPrice() * item.getQuantity();
        %>
                    <div class="item">
                        <!-- Container for text part (name, price, total, etc.) -->
                        <div class="item-text">
                            <h3><%= item.getName() %></h3>
                            <p>Price: Rs.<%= item.getPrice() %></p>
                            <p>Total: Rs.<%= item.getPrice() * item.getQuantity() %></p>

                            <!-- Update Quantity Form -->
                            <form action="CartServlet" method="post" class="update-quantity-form">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="menuId" value="<%= item.getMenuid() %>">
                                <button type="submit" name="quantity" value="<%= item.getQuantity() - 1 %>">-</button>
                                <span><%= item.getQuantity() %></span>
                                <button type="submit" name="quantity" value="<%= item.getQuantity() + 1 %>">+</button>
                            </form>

                            <!-- Remove Item Form -->
                            <form action="CartServlet" method="post" class="remove-item-form">
                                <input type="hidden" name="action" value="remove">
                                <input type="hidden" name="menuId" value="<%= item.getMenuid() %>">
                                <button type="submit">Remove</button>
                            </form>
                        </div>

                        <!-- Display Item Image (on the right side) -->
                        <img src="<%= item.getImagepath() %>" alt="<%= item.getName() %>" />
                    </div>
        <%
                }
        %>
            <div class="total">
                <h2>Total Amount: Rs.<%= totalAmount %></h2>
            </div>
            <a href="menu.jsp?restaurantid=<%= restaurantid %>">Add More</a>
            <a href="checkout.jsp">Proceed to Checkout</a>
        <%
            } 
        %>
    </div>
</body>
</html>
