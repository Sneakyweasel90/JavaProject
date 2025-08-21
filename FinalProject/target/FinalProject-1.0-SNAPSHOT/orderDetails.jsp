<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="businessLayer.PizzaBL"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
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
                width: 80%; /* Allow more space for side-by-side layout */
                max-width: 800px; /* Limit width for larger screens */
                text-align: center;
            }
            h1 {
                color: #333;
            }
            .menu {
                display: flex;
                flex-direction: column; /* Arrange inputs vertically */
                gap: 20px; /* Add spacing between fields */
                justify-content: flex-start; /* Align fields to the top */
                text-align: left; /* Align labels and inputs */
                width: 100%;
            }
            .menu > div {
                display: flex;
                flex-direction: column;
                gap: 5px;
            }
            label {
                font-weight: bold;
            }
            input[type="text"], input[type="email"], input[type="number"] {
                padding: 8px;
                width: 100%;
                border-radius: 5px;
                border: 1px solid #ccc;
            }
            .radio-group {
                display: flex;
                gap: 20px;
            }
            .radio-group input {
                margin-right: 10px;
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
            button:hover {
                background-color: #0056b3;
            }
        </style>
        <script>
            let validateForm = function () {

                const email = document.querySelector("#email").value;
                const postal = document.querySelector("#postalcode").value;
                const phone = document.querySelector("#phonenumber").value;
                const province = document.querySelector("#province").value;

                const regExEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                const regExPostal = /^[ABCEGHJKLMNPRSTVXY][0-9][ABCEGHJKLMNPRSTVWXYZ] ?[0-9][ABCEGHJKLMNPRSTVWXYZ][0-9]$/;
                const regExPhone = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/;
                const regExProvince = /^(AB|BC|MB|NB|NL|NS|NT|NU|ON|PE|QC|SK|YT)$/;

                if (!regExEmail.test(email)) {
                    alert("Email needs to be something@something.com.");
                    document.querySelector("#email").focus();
                    return false;
                }
                if (!regExPostal.test(postal)) {
                    alert("Postal code needs to be in format R3N 3N4 or R3N3N4");
                    document.querySelector("#postalcode").focus();
                    return false;
                }
                if (!regExPhone.test(phone)) {
                    alert("Phone needs to be (123) 456-7890 or 123-456-7890");
                    document.querySelector("#phonenumber").focus();
                    return false;
                }
                if (!regExProvince.test(province)) {
                    alert("Province must be NB or AB");
                    document.querySelector("#province").focus();
                    return false;
                }
                return true;
            }
            window.onload = function () { //this onload event will execute when the page loads
                document.querySelector("#frmOrder").onsubmit = validateForm; //this will "wire" the function to the click event of the button            
            };//end onload
        </script>
    </head>
    <body>
        <div class="container">
            <h1>Order Details</h1>
            <form id="frmOrder" action="order_proc" method="post">
                <div class="menu">
                    <div>
                        <label for="firstname">First Name</label>
                        <input type="text" id="firstname" name="firstname" placeholder="First Name here" required/>
                    </div>

                    <div>
                        <label for="lastname">Last Name</label>
                        <input type="text" id="lastname" name="lastname" placeholder="Last Name here" required/>
                    </div>

                    <div>
                        <label for="phonenumber">Phone Number</label>
                        <input type="text" id="phonenumber" name="phonenumber" placeholder="Phone Number here" required/>
                    </div>

                    <div>
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" placeholder="Email here" required/>
                    </div>

                    <div>
                        <label for="housenumber">House Number</label>
                        <input type="number" id="housenumber" name="housenumber" placeholder="House Number here"required/>
                    </div>

                    <div>
                        <label for="street">Street</label>
                        <input type="text" id="street" name="street" placeholder="Street Name here" required/>
                    </div>

                    <div>
                        <label for="province">Province</label>
                        <input type="text" id="province" name="province" placeholder="Province here" required/>
                    </div>

                    <div>
                        <label for="postalcode">Postal Code</label>
                        <input type="text" id="postalcode" name="postalcode" placeholder="Postal Code here" required/>
                    </div>
                    
                </div>
                <br>
                <button type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
