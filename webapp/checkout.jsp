<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CheckOut</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-image: url('https://image.slidesdocs.com/responsive-images/slides/0-simple-gourmet-western-restaurant-introduction-planning-powerpoint-background_6d04ca1081__960_540.jpg'); /* Background image */
        background-size: cover;
        background-position: center;
        color: white;
    }

    form {
        max-width: 400px;
        margin: auto;
        padding: 20px;
        border: 3px solid #00008b; /* Dark Blue Border */
        border-radius: 10px;
        background: rgba(255, 255, 255, 0.8); /* Semi-transparent background for form */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    .form-group {
        margin-bottom: 15px;
    }

    .form-group label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #333;
    }

    .form-group input,
    .form-group select {
        width: 100%;
        padding: 10px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f9f9f9;
    }

    .form-group input:focus,
    .form-group select:focus {
        border-color: #6a5acd;
        outline: none;
        background-color: #fff;
    }

    .form-group button {
        background-color: #6a5acd;
        color: white;
        padding: 10px;
        border: none;
        cursor: pointer;
        width: 100%;
        border-radius: 5px;
        font-size: 16px;
    }

    .form-group button:hover {
        background-color: #836fff;
    }

    h2 {
        text-align: center;
        color: #00008b; /* Dark Blue color */
    }
</style>
</head>
<body>
    <h2>Checkout</h2>
    <form action="Checkout" method="post">
        <!-- Delivery Address Section -->
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>

        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
        </div>

        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" id="city" name="city" required>
        </div>

        <div class="form-group">
            <label for="state">State:</label>
            <input type="text" id="state" name="state" required>
        </div>

        <div class="form-group">
            <label for="pincode">Pincode:</label>
            <input type="text" id="pincode" name="pincode" required>
        </div>

        <div class="form-group">
            <label for="phone">Phone Number:</label>
            <input type="text" id="phone" name="phone" required>
        </div>

        <!-- Payment Mode Section -->
        <div class="form-group">
            <label for="paymentMode">Payment Mode:</label>
            <select id="paymentMode" name="paymentMode" required>
                <option value="creditCard">Credit Card</option>
                <option value="debitCard">Debit Card</option>
                <option value="netBanking">Net Banking</option>
                <option value="cashOnDelivery">Cash on Delivery</option>
            </select>
        </div>

        <!-- Place Order Button -->
        <div class="form-group">
            <button type="submit">Place Order</button>
        </div>
    </form>
</body>
</html>
