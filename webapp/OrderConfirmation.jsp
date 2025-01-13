<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation - Spice House</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e3f2fd; /* Light Blue Background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
            overflow: hidden; /* Prevent scroll from the shower effect */
        }

        .container {
            background-color: #fff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            border: 5px solid #42a5f5; /* Blue border for the card */
            width: 80%;
            max-width: 800px;
            min-height: 500px;
            position: relative;
            z-index: 2;
        }

        h1 {
            font-size: 2.5rem;
            color: #28a745;
            margin-bottom: 20px;
            animation: pulse 1.5s infinite; /* Pulsating animation */
        }

        .order-message {
            font-size: 1.5rem;
            color:#4b0082;
            margin-bottom: 20px;
        }

        .ready-to-taste {
            font-size: 1.5rem;
            color: #e74c3c; /* Red color */
            font-weight: bold;
            margin-bottom: 30px;
        }

        .order-details {
            font-size: 1.2rem;
            color: #4b0082
            margin-bottom: 30px;
        }

        .order-details p {
            margin: 10px 0;
        }

        .image-container img {
            width: 60%;
            max-width: 500px;
            margin-top: 30px;
            animation: slideIn 2s ease-out;
            border: 3px solid #42a5f5; /* Blue border for the image */
            border-radius: 10px;
        }

        .back-home {
            padding: 15px 30px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            font-size: 1.2rem;
            position: relative;
            z-index: 2;
        }

        .back-home:hover {
            background-color: #0056b3;
        }

        /* Confetti Shower Effect */
        .confetti {
            position: absolute;
            width: 10px;
            height: 10px;
            background-color: #ff4081; /* Pink Confetti */
            animation: fall 5s infinite;
            top: -10px;
            border-radius: 50%;
            z-index: 1;
        }

        .confetti:nth-child(2n) {
            background-color: #42a5f5; /* Blue Confetti */
        }

        .confetti:nth-child(3n) {
            background-color: #66bb6a; /* Green Confetti */
        }

        .confetti:nth-child(4n) {
            background-color: #ffa726; /* Orange Confetti */
        }

        @keyframes fall {
            0% {
                transform: translateY(-10px) rotate(0deg);
            }
            100% {
                transform: translateY(100vh) rotate(720deg);
            }
        }

        /* Pulsing Animation for Hurray */
        @keyframes pulse {
            0%, 100% {
                transform: scale(1);
            }
            50% {
                transform: scale(1.1);
            }
        }

        @keyframes slideIn {
            0% {
                transform: translateX(100%);
            }
            100% {
                transform: translateX(0);
            }
        }
    </style>
</head>
<body>

    <!-- Confetti Shower -->
    <div class="confetti" style="left: 10%;"></div>
    <div class="confetti" style="left: 20%;"></div>
    <div class="confetti" style="left: 30%;"></div>
    <div class="confetti" style="left: 40%;"></div>
    <div class="confetti" style="left: 50%;"></div>
    <div class="confetti" style="left: 60%;"></div>
    <div class="confetti" style="left: 70%;"></div>
    <div class="confetti" style="left: 80%;"></div>
    <div class="confetti" style="left: 90%;"></div>

    <!-- Order Confirmation Card -->
    <div class="container">
        <h1>Hurray!!!!</h1>
        <p class="order-message">Your Order Has Been Confirmed!</p>
        <p class="ready-to-taste">Ready to Taste</p>

        <!-- Order details -->
        <div class="order-details">
            <p><strong>Order ID:</strong> <span id="order-id"></span></p>
            <p><strong>Estimated Delivery Time:</strong> 30 minutes</p>
        </div>

        <!-- Animation Image -->
        <div class="image-container">
            <img src="https://media3.giphy.com/media/Y2gbYkm26Kgw4SNheG/giphy.gif?cid=6c09b952o6m87d6d6mmh6x1ng5etat89y70zmjbkv3eozeg2&ep=v1_internal_gif_by_id&rid=giphy.gif&ct=s" alt="Order Successful">
        </div>

        <!-- Back to Home Button -->
        <a href="GetRestaurant" class="back-home">Back to Home</a>
    </div>

    <script>
        // Function to generate a random Order ID
        function generateOrderId() {
            return 'ORD-' + Math.floor(Math.random() * 1000000);
        }

        // Set the generated Order ID in the page
        document.getElementById('order-id').textContent = generateOrderId();
    </script>

</body>
</html>
