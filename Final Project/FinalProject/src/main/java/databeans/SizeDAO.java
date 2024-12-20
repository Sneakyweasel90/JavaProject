/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databeans;

import businessLayer.Size;
import jakarta.ejb.Stateless;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author neilm
 */
@Stateless
public class SizeDAO extends DBConnection{
    
    public LinkedList<Size> getAllSizes(){
        
        String sql = "SELECT * FROM sizes";
        LinkedList<Size> sizes = new LinkedList<>();
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("sizeid");
                String name = rs.getString("name");
                
                Size pizzaSize = new Size(id, name);
                sizes.add(pizzaSize);
            }
            return sizes;
        } catch (SQLException ex) {
            
        }
        return null; //if nothing comes back
    }
}
