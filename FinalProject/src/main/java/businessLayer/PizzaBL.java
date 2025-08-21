/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessLayer;

import databeans.CrustDAO;
import databeans.CustomerDAO;
import databeans.EmployeeDAO;
import databeans.OrderDAO;
import databeans.PizzaDAO;
import databeans.PizzaMapDAO;
import databeans.SizeDAO;
import databeans.ToppingsDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author neilm
 */
@Named("pizzaBL")
@Stateless
public class PizzaBL {
    
    @Inject CrustDAO crustDAO;
    @Inject ToppingsDAO toppingsDAO;
    @Inject SizeDAO sizeDAO;
    @Inject PizzaDAO pizzaDAO;
    @Inject CustomerDAO customerDAO;
    @Inject OrderDAO orderDAO;
    @Inject PizzaMapDAO pizzaMapDAO;
    @Inject EmployeeDAO employeeDAO;
    
    public ArrayList<CrustTypes> getCrusts() {
        return new ArrayList<>(crustDAO.getAllCrusts());
    }
   
    public ArrayList<Toppings> getToppings() {
        return new ArrayList<>(toppingsDAO.getAllToppings());
    }
    
    public LinkedList<Size> getSize() {
        return new LinkedList<>(sizeDAO.getAllSizes());
    }
    
    public int addPizza(Pizza p) {
        return pizzaDAO.AddPizza(p);
    }
    
    public int addCustomer (Customer c) {
        return customerDAO.AddCustomer(c);
    } 
    
    public int addOrder (Order o) {
        return orderDAO.AddOrder(o);
    }
    
    public int addToppingMap (PizzaMap pm) {
        return pizzaMapDAO.AddToppingsMap(pm);
    }
    
    public LinkedList<Order> getAllOrders() {
        return new LinkedList<>(orderDAO.getAllOrders());
    }
    
    public boolean employeeLogin(Employee e) {
        return employeeDAO.checkEmployee(e);
    }
    
    public boolean changeStatus(Order o) {
        return orderDAO.changeStatus(o);
    }
    
    public LinkedList<Order> getAllPendingOrders() {
        return new LinkedList<>(orderDAO.getAllPendingOrders());
    }
    
    public LinkedList<Order> getAllFilledOrders() {
        return new LinkedList<>(orderDAO.getAllFilledOrders());
    }
}
