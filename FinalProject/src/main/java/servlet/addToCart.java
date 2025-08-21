/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import businessLayer.Cart;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedList;

/**
 *
 * @author neilm
 */
@WebServlet(name = "addToCart", urlPatterns = {"/addToCart"})
public class addToCart extends HttpServlet {
    
    @Inject Cart c;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            LinkedList<Integer> toppingIds = new LinkedList<>();
            LinkedList<String> toppings = new LinkedList<>();

            String[] crustDetails = request.getParameter("crust").split(":");
            String crustId = crustDetails[0];
            String crustName = crustDetails[1];

            String[] sizeDetails = request.getParameter("size").split(":");
            String sizeId = sizeDetails[0];
            String sizeName = sizeDetails[1];

            String[] toppingSelected = request.getParameterValues("toppings");
            if (toppingSelected != null) {
                for (String topping : toppingSelected) {
                    String[] toppingDetails = topping.split(":");
                    int toppingId = Integer.parseInt(toppingDetails[0]);
                    String toppingName = toppingDetails[1];
                    toppings.add(toppingName);
                    toppingIds.add(toppingId);
                }
            }

            int amount = Integer.parseInt(request.getParameter("quantity"));
            double pricePerTopping = 1.99;
            double totalPrice = 0.0;

            for (String topping : toppings) {
                if (!topping.equals("Cheese")) {  // Cheese is free
                    totalPrice += pricePerTopping;
                }
            }

            // Calculate total price based on quantity
            totalPrice *= amount * 1.15; //taxes
            
            Cart newPizza = new Cart();
            newPizza.setCrustId(Integer.parseInt(crustId));
            newPizza.setCrustName(crustName);
            newPizza.setSizeId(Integer.parseInt(sizeId));
            newPizza.setSizeName(sizeName);
            newPizza.setToppings(toppingIds);
            newPizza.setToppingName(toppings);
            newPizza.setQuantity(amount);
            newPizza.setTotalPrice(totalPrice);

            //store a variable in session
            HttpSession session = request.getSession();
            
                                        //casting this? Not sure why i need to?
            LinkedList<Cart> cartList = (LinkedList<Cart>) session.getAttribute("pizzaCart");
            if (cartList == null) {
                cartList = new LinkedList<>();
            }
            
            cartList.add(newPizza);
            session.setAttribute("pizzaCart", cartList);

            //Debugging
//            System.out.println("Session Cart");
//            for (Cart pizza : cartList) {
//                System.out.println(pizza);
//            }

            response.sendRedirect("cart.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
