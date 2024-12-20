/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databeans;

import businessLayer.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author neilm
 */
public class EmployeeDAO extends DBConnection {

    public boolean checkEmployee(Employee e) {

        String sql = "SELECT username, password FROM employee WHERE username = ? AND password = ?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getUsername());
            ps.setString(2, e.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error logging in: " + ex.getMessage()); // Print error message for debugging
            return false;
        }
    }
}
