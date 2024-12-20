/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databeans;

import businessLayer.Customer;
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
public class CustomerDAO extends DBConnection {
    
    public int AddCustomer(Customer c) {
        
        try {
            String sql = "INSERT INTO customer (firstName, lastName, phoneNumber, email, houseNumber, street, province, postalCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getPhoneNumber());
            ps.setString(4, c.getEmail());
            ps.setInt(5, c.getHouseNumber());
            ps.setString(6, c.getStreet());
            ps.setString(7, c.getProvince());
            ps.setString(8, c.getPostalCode());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }
            
        } catch (SQLException ex) {
            System.out.println("Inserting Customer: " + ex.getMessage());
            return -1;
        }
        return -1;
    }
}
