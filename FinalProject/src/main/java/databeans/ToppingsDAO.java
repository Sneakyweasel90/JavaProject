/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databeans;

import businessLayer.Toppings;
import jakarta.ejb.Stateless;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author neilm
 */
@Stateless
public class ToppingsDAO extends DBConnection{
    
    public ArrayList<Toppings> getAllToppings(){
        
        String sql = "SELECT * FROM toppings";
        ArrayList<Toppings> myToppings = new ArrayList<>();
        
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("toppingId");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Date created = rs.getDate("createDate");
                int emp = rs.getInt("empAddedBy");
                int isActive = rs.getInt("isActive");
                
                Toppings top = new Toppings(id, name, price, created, emp, isActive);
                
                //System.out.println(top);
                myToppings.add(top);
            }
            return myToppings;
        } catch (SQLException ex) {
            
        }
        return null; //if nothing comes back
    }
}
