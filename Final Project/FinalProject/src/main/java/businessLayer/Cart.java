/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessLayer;

import java.util.LinkedList;

/**
 *
 * @author neilm
 */
public class Cart {
    
    private int sizeId;
    private String sizeName;
    private int toppingId;
    private LinkedList<String> toppingName;
    private int crustId;
    private String crustName;
    private LinkedList<Integer> toppings;
    private int quantity;
    private double totalPrice;

    @Override
    public String toString() {
        return "Cart{" + "sizeId=" + sizeId + ", sizeName=" + sizeName + ", toppingId=" + toppingId + ", toppingName=" + toppingName + ", crustId=" + crustId + ", crustName=" + crustName + ", toppings=" + toppings + ", quantity=" + quantity + ", totalPrice=" + totalPrice + '}';
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public LinkedList<String> getToppingName() {
        return toppingName;
    }

    public void setToppingName(LinkedList<String> toppingName) {
        this.toppingName = toppingName;
    }

    public int getCrustId() {
        return crustId;
    }

    public void setCrustId(int crustId) {
        this.crustId = crustId;
    }

    public String getCrustName() {
        return crustName;
    }

    public void setCrustName(String crustName) {
        this.crustName = crustName;
    }

    public LinkedList<Integer> getToppings() {
        return toppings;
    }

    public void setToppings(LinkedList<Integer> toppings) {
        this.toppings = toppings;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart() {
    }
   
}
