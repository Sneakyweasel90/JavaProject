<%-- 
    Document   : index
    Created on : Nov 27, 2024, 8:13:05 AM
    Author     : neilm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businessLayer.Toppings"%>
<%@page import="businessLayer.PizzaBL"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mannions Pizza</title>
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
            button {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 10px 15px;
                border-radius: 5px;
                cursor: pointer;
                width: 20%;
            }
            .red {
                background-color: #ff0000;
                color: white;
                border: none;
                padding: 10px 15px;
                border-radius: 5px;
                cursor: pointer;
                width: 20%;
            }
            button:hover {
                background-color: #0056b3;
            }
        </style>
        <script>
            let validateForm = function () {

                const toppings = document.querySelectorAll('input[name="toppings"]:checked');

                if (toppings.length === 0) {
                    alert("please select a topping");
                    return false;
                }
                return true;
            }
            window.onload = function () { //this onload event will execute when the page loads
                document.querySelector("#addToCart").onsubmit = validateForm; //this will "wire" the function to the click event of the button            
            };//end onload
        </script>
    </head>
    <body>
        <%
            if (request.getParameter("msg") != null) {
                String message = request.getParameter("msg");
                out.println("<script>alert('" + message + "'); window.location.href = 'index.jsp';</script>");
            }
        %>
        <div class="container">
            <h1 style="color: blue;">Mannions Pizza!</h1>
            <h2>Make your Pizza!</h2>
            <form id="addToCart" action="addToCart" method="post">

                <div class="menu">

                    <div>
                        <h2>Select Crust</h2>
                        <select id="crust" name="crust" required>
                            <c:forEach var="crust" items="${pizzaBL.crusts}">
                                <option name="crust" value="${crust.crustId}:${crust.name}">${crust.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <h2>Select Toppings</h2>
                        <div id="toppings">
                            <c:forEach var="topping" items="${pizzaBL.toppings}">
                                <input type="checkbox" name="toppings" value="${topping.toppingId}:${topping.name}"> ${topping.name} $${topping.price}</option><br>
    <!--                            <label>${topping.toppingId} Debugging</label>-->
                            </c:forEach>
                        </div>
                    </div>

                    <div>
                        <h2>Select Size</h2>
                        <select id="size" name="size" required>
                            <c:forEach var="size" items="${pizzaBL.size}">
                                <option name="size" value="${size.sizeId}:${size.name}">${size.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <h2>Quantity</h2>
                        <select name="quantity" required>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>

                </div>
                <br>
                <button type="submit">Add Pizza</button>
                <button class="button" id="delivery" onclick="window.location.href = 'cart.jsp'">Look at your cart!</button>
            </form>
            <br/>
            <button class="red" id="employee" onclick="window.location.href = 'employee.jsp'">Employee Login</button>
        </div>
    </body>
</html>
