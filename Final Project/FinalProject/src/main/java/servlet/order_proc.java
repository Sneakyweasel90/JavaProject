/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import businessLayer.Cart;
import businessLayer.Customer;
import businessLayer.Order;
import businessLayer.Pizza;
import businessLayer.PizzaBL;
import businessLayer.PizzaMap;
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
@WebServlet(name = "order_proc", urlPatterns = {"/order_proc"})
public class order_proc extends HttpServlet {

    @Inject Customer c;
    @Inject PizzaBL pbl;
    @Inject Pizza p;
    @Inject Order o;
    @Inject PizzaMap pm;

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

            c.setFirstName(request.getParameter("firstname"));
            c.setLastName(request.getParameter("lastname"));
            c.setPhoneNumber(request.getParameter("phonenumber"));
            c.setEmail(request.getParameter("email"));
            c.setPhoneNumber(request.getParameter("housenumber"));
            c.setStreet(request.getParameter("street"));
            c.setProvince(request.getParameter("province"));
            c.setPostalCode(request.getParameter("postalcode"));

            //debugging
//            System.out.println(request.getParameter("firstname"));
//            System.out.println(request.getParameter("lastname"));
//            System.out.println(request.getParameter("phonenumber"));
//            System.out.println(request.getParameter("email"));
//            System.out.println(request.getParameter("housenumber"));
//            System.out.println(request.getParameter("street"));
//            System.out.println(request.getParameter("province"));
//            System.out.println(request.getParameter("postalcode"));

            int intCustomerId = pbl.addCustomer(c);
            //String message = result ? "Customer added successfully" : "Error adding Customer";
            //System.out.println(result);
            //System.out.println(intCustomerId);

            HttpSession session = request.getSession();
            LinkedList<Cart> cartList = (LinkedList<Cart>) session.getAttribute("pizzaCart");

            if (cartList != null && !cartList.isEmpty()) {
                for (Cart cart : cartList) {
                    int crustId = cart.getCrustId();
                    int sizeId = cart.getSizeId();
                    LinkedList<Integer> toppings = cart.getToppings();
                    double totalPrice = cart.getTotalPrice();

                    o.setTotalPrice(totalPrice);
                    o.setCustomerId(intCustomerId);

                    int intOrderId = pbl.addOrder(o);

                    p.setCrustTypeId(crustId);
                    p.setPrice(totalPrice);
                    p.setSizeId(sizeId);
                    p.setOrderId(intOrderId);

                    int intPizzaId = pbl.addPizza(p);

                    if (toppings != null && !toppings.isEmpty()) {
                        for (int toppingId : toppings) {
                            pm.setPizzaId(intPizzaId);
                            pm.setToppingId(toppingId);

                            pbl.addToppingMap(pm);
                        }
                    }
                }

                session.removeAttribute("pizzaCart");
            }

// Redirect the user to the next page
            response.sendRedirect("deliveryTime.jsp?msg=");

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
