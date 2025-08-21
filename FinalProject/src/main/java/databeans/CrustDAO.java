/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databeans;

import businessLayer.CrustTypes;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author neilm
 */
@Stateless
@LocalBean
public class CrustDAO extends DBConnection{
    
    public ArrayList<CrustTypes> getAllCrusts(){
        
        String sql = "SELECT * FROM crusttypes";
        ArrayList<CrustTypes> crusts = new ArrayList<>();
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {
                int crustId = rs.getInt("crustTypeId");
                String name = rs.getString("name");
                
                CrustTypes crust = new CrustTypes(crustId, name);
                crusts.add(crust);
            }
            
            return crusts;
        } catch (SQLException ex) {
            System.out.println("Error inserting pizza: " + ex.getMessage()); // Print error message for debugging
            return null;
        }
    }
}
    
    
