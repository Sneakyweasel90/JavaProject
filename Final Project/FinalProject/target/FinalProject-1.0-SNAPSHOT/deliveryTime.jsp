<%-- 
    Document   : deliveryTime
    Created on : Dec 6, 2024, 3:21:26 p.m.
    Author     : neilm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businessLayer.PizzaBL"%>
<%@page import="businessLayer.Order"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f8f9fa;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .container {
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                width: 80%;
                max-width: 800px;
                text-align: center;
            }
            h1 {
                color: #333;
            }
            .menu {
                display: flex;
                flex-direction: row;
                flex-wrap: wrap;
                gap: 20px;
                justify-content: space-between;
            }
            .menu > div {
                flex: 1;
                min-width: 200px;
                text-align: left;
            }
            select, input[type="checkbox"] {
                margin: 5px 0;
            }
            label {
                display: block;
                margin-bottom: 5px;
            }
            .button {
                background-color: #007bff;
                color: white;
                text-decoration: none;
                padding: 10px 15px;
                border-radius: 5px;
                cursor: pointer;
                display: inline-block;
            }
            .button:hover {
                background-color: #0056b3;
            }
            .toppings-container {
                display: inline; /* Align with text */
            }
            .topping-item {
                display: inline; /* Inline each topping */
                margin-left: 5px; /* Add some spacing */
            }
        </style>
    </head>
</head>
<body>
    <div class="container">
        <h1 style="color: blue;">Delivery Time</h1>
        <div>
            <h2 style="color: blue;">Your Pizzas</h2>
            <div>
                <c:forEach var="orders" items="${pizzaBL.allOrders}">
                    <p><strong>Order Total Price:</strong> $${String.format("%.2f", orders.totalPrice)}</p>
                    <p><strong>Order Status:</strong> ${orders.orderStatus}</p>
                    <p><strong>Placed Date:</strong> ${orders.placedDateTime}</p>
                    <p><strong>Delivery Date:</strong> ${orders.deliveryDateTime}</p>
                    <hr/>
                </c:forEach>
            </div>
            <button class="button" id="delivery" onclick="window.location.href = 'index.jsp'">Order another Pizza?</button>

        </div>
</body>
</html>