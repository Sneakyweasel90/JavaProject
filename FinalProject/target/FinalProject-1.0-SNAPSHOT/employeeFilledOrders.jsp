<%-- 
    Document   : employeeFilledOrders
    Created on : Dec 10, 2024, 3:39:10 p.m.
    Author     : neilm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businessLayer.PizzaBL"%>
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
                width: 100%;
                max-width: 1200px;
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
            button {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 15px 20px;
                font-size: 16px;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;
            }
            .red {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 15px 20px;
                font-size: 16px;
                border-radius: 5px;
                cursor: pointer;
                width: 20%;
            }
            button:hover {
                background-color: #ff0000;
            }
            .order {
                color: red;
            }
        </style>
    </head>
    <%
        if (request.getParameter("msg") != null) {
            String message = request.getParameter("msg");
            out.println("<script>alert('" + message + "'); window.location.href = 'employeeChangeOrders.jsp';</script>");
        }
        if (session.getAttribute("employee") == null) {
            response.sendRedirect("employee.jsp");
        }
    %>
    <body>
        <div class="container">
            <h2>Change An Order</h2>
            <div class="menu">
                <table border="1" style="width: 100%; border-collapse: collapse">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Total Price</th>
                            <th>Placed Date</th>
                            <th>Delivery Date</th>
                            <th>Customer ID</th>
                            <th>Order Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="orders" items="${pizzaBL.allFilledOrders}">
                            <tr>
                                <td>${orders.orderId}</td>
                                <td>$${orders.totalPrice}</td>
                                <td>${orders.placedDateTime}</td>
                                <td>${orders.deliveryDateTime}</td>
                                <td>${orders.customerId}</td>
                                <td class="order">${orders.orderStatus}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button class="red" id="employee" onclick="window.location.href = 'employeeChangeOrders.jsp'">Pending Orders</button>
                <form method="post">
                    <button type="submit" class="button" name="logout">Log Out</button>
                </form> 
            </div>
        </div>
    </body>
    <%
        if (request.getMethod().equalsIgnoreCase("POST") && request.getParameter("logout") != null) {
            session.removeAttribute("empployee"); // remove the employee from session
            response.sendRedirect("employee.jsp");
        }
    %>
</html>
