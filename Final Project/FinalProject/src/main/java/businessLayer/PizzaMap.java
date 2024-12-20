/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessLayer;

import jakarta.ejb.Stateless;

/**
 *
 * @author neilm
 */
@Stateless
public class PizzaMap {
    
    private int toppingId;
    private int pizzaId;
    private int topping_pizza_id;

    @Override
    public String toString() {
        return "Pizza_Topping_Map{" + "toppingId=" + toppingId + ", pizzaId=" + pizzaId + ", topping_pizza_id=" + topping_pizza_id + '}';
    }

    public PizzaMap() {
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getTopping_pizza_id() {
        return topping_pizza_id;
    }

    public void setTopping_pizza_id(int topping_pizza_id) {
        this.topping_pizza_id = topping_pizza_id;
    }
    
    
}
