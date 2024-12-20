/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databeans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author neilm
 */
public class DBConnection {
    
    protected Connection conn = null; 
    
    @PostConstruct
    public void GetConnection() {
        //System.out.println("INSIDE GETCONNECTION");
        try {
            ServletContext context = jakarta.enterprise.inject.spi.CDI.current()
                    .select(ServletContext.class).get(); //get the servlet context
            String user = context.getInitParameter("db.username"); 
            String password = context.getInitParameter("db.password"); 
            String dbURL = context.getInitParameter("db.url"); 
            Class.forName("com.mysql.jdbc.Driver"); //dynamically load the class at runtime
            conn = DriverManager.getConnection(dbURL, user, password);
        } //end getConnection
        catch (SQLException ex) {
            
        }
        catch (ClassNotFoundException cnfe) {
//swallow the exception for now
        }   
        
    }
    @PreDestroy //gets called immediately before the object is destroyed
    public void Disconnect() {
        //System.out.println("INSIDE DISCONNECT");
        try {
            conn.close();
        } catch (SQLException ex) {
            
        }
        
    }//end disconnect
}
