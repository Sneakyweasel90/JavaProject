/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databeans;

import businessLayer.Order;
import jakarta.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 *
 * @author neilm
 */
@Stateless
public class OrderDAO extends DBConnection {

    public int AddOrder(Order o) {

        try {
            String sql = "INSERT INTO orders (totalPrice, customerId) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, o.getTotalPrice());
            ps.setInt(2, o.getCustomerId());
            ps.executeUpdate(); //return true if successfull

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int orderId = rs.getInt(1);
                return orderId;
            }

        } catch (SQLException ex) {
            System.out.println("Error inserting order: " + ex.getMessage()); // Print error message for debugging
            return -1;
        }
        return -1;
    }

    public LinkedList<Order> getAllOrders() {

        String sql = "SELECT * FROM orders";
        LinkedList<Order> orders = new LinkedList<>();

        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                double totalPrice = rs.getDouble("totalPrice");
                LocalDateTime deliveryDate = rs.getTimestamp("deliveryDateTime").toLocalDateTime();
                LocalDateTime placedDateTime = rs.getTimestamp("placedDateTime").toLocalDateTime();
                int customerId = rs.getInt("customerId");
                String orderStatus = rs.getString("orderStatus");
                
                LocalDateTime deliveryDateAdded = deliveryDate.plusMinutes(30); 

                Order order = new Order(orderId, totalPrice, deliveryDateAdded, placedDateTime, customerId, orderStatus);
                orders.add(order);
            }
            return orders;

        } catch (SQLException ex) {
            System.out.println("Error inserting pizza: " + ex.getMessage()); // Print error message for debugging
            return null;
        }
    }
    
    public boolean changeStatus(Order o) {
        
        String sql = "UPDATE orders SET orderStatus = ? WHERE orderId = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Filled");
            ps.setInt(2, o.getOrderId());
            
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            System.out.println("Error inserting pizza: " + ex.getMessage()); // Print error message for debugging
            return false;
        }
    }
    
    public LinkedList<Order> getAllPendingOrders() {

        String sql = "SELECT * FROM orders WHERE orderStatus = 'PENDING'";
        LinkedList<Order> orders = new LinkedList<>();

        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                double totalPrice = rs.getDouble("totalPrice");
                LocalDateTime deliveryDate = rs.getTimestamp("deliveryDateTime").toLocalDateTime();
                LocalDateTime placedDateTime = rs.getTimestamp("placedDateTime").toLocalDateTime();
                int customerId = rs.getInt("customerId");
                String orderStatus = rs.getString("orderStatus");
                
                LocalDateTime deliveryDateAdded = deliveryDate.plusMinutes(30); 

                Order order = new Order(orderId, totalPrice, deliveryDateAdded, placedDateTime, customerId, orderStatus);
                orders.add(order);
            }
            return orders;

        } catch (SQLException ex) {
            System.out.println("Error inserting pizza: " + ex.getMessage()); // Print error message for debugging
            return null;
        }
    }
    
    public LinkedList<Order> getAllFilledOrders() {

        String sql = "SELECT * FROM orders WHERE orderStatus = 'FILLED'";
        LinkedList<Order> orders = new LinkedList<>();

        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                double totalPrice = rs.getDouble("totalPrice");
                LocalDateTime deliveryDate = rs.getTimestamp("deliveryDateTime").toLocalDateTime();
                LocalDateTime placedDateTime = rs.getTimestamp("placedDateTime").toLocalDateTime();
                int customerId = rs.getInt("customerId");
                String orderStatus = rs.getString("orderStatus");
                
                LocalDateTime deliveryDateAdded = deliveryDate.plusMinutes(30); 

                Order order = new Order(orderId, totalPrice, deliveryDateAdded, placedDateTime, customerId, orderStatus);
                orders.add(order);
            }
            return orders;

        } catch (SQLException ex) {
            System.out.println("Error inserting pizza: " + ex.getMessage()); // Print error message for debugging
            return null;
        }
    }
}
