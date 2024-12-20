<%-- 
    Document   : cart
    Created on : Dec 3, 2024, 6:22:13 p.m.
    Author     : neilm
--%>

<%@page import="businessLayer.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<%@page import="businessLayer.Pizza"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
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
    <body>
        <div class="container">
            <h1 style="color: ">Your Cart</h1>

            <%
                LinkedList<Cart> cartList = (LinkedList<Cart>) session.getAttribute("pizzaCart");
                if (cartList != null && !cartList.isEmpty()) {
                    for (Cart cart : cartList) {
            %>
            <div>
                <p><strong>Crust:</strong> <%= cart.getCrustName()%></p>
                <p><strong>Size:</strong> <%= cart.getSizeName()%></p>
                <p><strong>Toppings:</strong></p>
                <ul>
                    <% for (String topping : cart.getToppingName()) {%>
                    <li><%= topping%></li>
                        <% }%>
                </ul>
                <p><strong>Quantity:</strong> <%= cart.getQuantity()%></p>
                <p><strong>Total Price:</strong> $<%= String.format("%.2f", cart.getTotalPrice())%></p>
            </div>
            <hr>
            <%
                }
            } else {
            %>
            <p>Your cart is empty!</p>
            <%
                }
            %>
            <a href="orderType.jsp" class="button">Proceed to Checkout</a>
            <a href="index.jsp" class="button">Add another pizza!</a>
            <form method="post">
                <button type="submit" class="button" name="clearCart">Clear Cart</button>
            </form>
        </div>
    </body>
    <%
        if (request.getMethod().equalsIgnoreCase("POST") && request.getParameter("clearCart") != null) {
            session.removeAttribute("pizzaCart"); // remove the cart from session
            response.sendRedirect("cart.jsp");
        }
    %>
</html>

