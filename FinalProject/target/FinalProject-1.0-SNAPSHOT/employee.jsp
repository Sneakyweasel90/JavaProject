<%-- 
    Document   : admin
    Created on : Dec 10, 2024, 1:21:22 p.m.
    Author     : neilm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
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
    </head>
    <body>
        <div class="container">
            <form id="frmEmployee" action="employee_proc" method="post">
                <h1 style="color: blue">Employee Login</h1>
                <div class="form-group">
                    <label for="username">UserName:</label>
                    <input type="text" id="username" name="username" placeholder="Your UserName here" required>
                </div>
                <div class="form-group">
                    <label for="passwword">Password:</label>
                    <input type="password" id="password" name="password" placeholder="Your Email here" required>
                </div>
                <br/>
                <button type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
