/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databeans;

import businessLayer.PizzaMap;
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
public class PizzaMapDAO extends DBConnection{
    
    public int AddToppingsMap(PizzaMap ptm) {
        
        try {
            String sql = "INSERT INTO pizza_toppings_map (pizzaId, toppingId) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ptm.getPizzaId());
            ps.setInt(2, ptm.getToppingId());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }
            
        } catch (SQLException ex) {
            System.out.println("Inserting toppings: " + ex.getMessage());
            return -1;
        }
        return -1;
    }
}
