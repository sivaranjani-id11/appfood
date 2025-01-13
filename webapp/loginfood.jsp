<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        /* General page styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh; /* Full viewport height */
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            background-image: url('https://static.vecteezy.com/system/resources/previews/009/003/028/non_2x/organic-food-and-fruit-shopping-background-free-vector.jpg');
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover; /* Ensures the image covers the entire screen */
        }

        /* Centered form container */
        form {
            background: rgba(255, 255, 255, 0.8); /* White background with slight transparency */
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 350px;
            margin-bottom: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Input fields style */
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }

        /* Submit button style */
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Link styling */
        p {
            text-align: center;
            color: #333;
            margin-top: 10px;
        }

        a {
            color: purple; /* Changed link color to purple */
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Login Page</h1>
    <form action="LoginServletcok" method="post">
        Email: <input type="text" name="email" placeholder="Enter your email"><br>
        Password: <input type="password" name="password" placeholder="Enter your password"><br>
        <input type="submit" value="Login"><br>
    </form>
    <p>If you are a new user, <a href="Registerfood.jsp">Register Here</a></p>
</body>
</html>
