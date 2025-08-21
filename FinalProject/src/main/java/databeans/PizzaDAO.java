/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databeans;

import businessLayer.Pizza;
import jakarta.ejb.Stateless;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author neilm
 */
@Stateless
public class PizzaDAO extends DBConnection {

    public int AddPizza(Pizza p) {

        try {
            String sql = "INSERT INTO pizza (sizeId, crustTypeId, price, orderId) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getSizeId());
            ps.setInt(2, p.getCrustTypeId());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getOrderId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int pizzaId = rs.getInt(1);
                return pizzaId;
            }

        } catch (SQLException ex) {
            System.out.println("Error inserting pizza: " + ex.getMessage()); // Print error message for debugging
            return -1;
        }
        return -1;
    }
}
