<%-- 
    Document   : orderType
    Created on : Dec 6, 2024, 10:56:21 a.m.
    Author     : neilm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Type</title>
        <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center; /* Horizontally center */
            align-items: center;   /* Vertically center */
            background-color: #f8f9fa;
        }
        .container {
            text-align: center; /* Center content inside the container */
        }
        .button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            margin: 10px; /* Add space between buttons */
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
        </style>
        
    </head>
    <body>
        <div class="container">
            <h1>Delivery Options</h1>
            <div class="menu">
                <div>
                    <button class="button" id="pickup" onclick="window.location.href = 'https://paypal.com'">Pickup</button>
                    <button class="button" id="delivery" onclick="window.location.href = 'orderDetails.jsp'">Delivery</button>
                </div>
                </form>
            </div>
    </body>
</html>
