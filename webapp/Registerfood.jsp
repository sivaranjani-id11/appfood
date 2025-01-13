<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Here</title>
<style>
    /* Body with image background */
    body {
        font-family: Arial, sans-serif;
        background-image: url("https://i.pinimg.com/originals/33/ef/8b/33ef8b9c0b902154a6cd4103a21275ef.jpg");
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Form container */
    form {
        background: rgba(255, 255, 255, 0.9); /* White with slight opacity */
        padding: 20px 30px;
        border-radius: 8px;
        border: 2px solid #8a2be2; /* Purple border */
        box-shadow: 0 0 10px #8a2be2; /* Purple glow effect */
        width: 300px;
        text-align: center;
        transition: box-shadow 0.3s ease-in-out;
    }

    form:hover {
        box-shadow: 0 0 15px #6a0dad; /* Enhanced glow on hover */
    }

    /* Form header - "Register Here" in green */
    form h2 {
        margin-bottom: 20px;
        color: #28a745; /* Green color */
    }

    /* Input fields */
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
    }

    /* Register Button */
    input[type="submit"] {
        background-color: #28a745; /* Green button */
        color: white;
        border: none;
        padding: 10px;
        font-size: 16px;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }

    input[type="submit"]:hover {
        background-color: #218838; /* Darker green on hover */
    }

    /* Login link */
    .login-button a {
        display: block;
        margin-top: 10px;
        color: #28a745; /* Green color */
        text-decoration: none;
        font-weight: bold;
    }

    .login-button a:hover {
        text-decoration: underline;
        color: #218838; /* Darker green on hover */
    }
</style>
</head>
<body>

<!-- Registration Form -->
<form action="Registration" method="post">
    <h2>Register Here</h2>
    <input type="text" name="username" placeholder="Username" required><br>
    <input type="password" name="password" placeholder="Password" required><br>
    <input type="password" name="cpassword" placeholder="Confirm Password" required><br>
    <input type="text" name="email" placeholder="Email" required><br>
    <input type="text" name="address" placeholder="Address" required><br>
    <input type="submit" value="Register"><br>
    
    <!-- Login Link -->
    <div class="login-button">
        <p>Already Registered? <a href="loginfood.jsp">Login</a></p>
    </div>
</form>

</body>
</html>
