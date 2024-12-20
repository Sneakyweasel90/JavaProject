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
public class Pizza {
    private int sizeId;
    private int isFinished;
    private int crustTypeId;
    private double price; //this is supposed to be a float but making it a double
    private int orderId;
    
    public Pizza() {
    }

    public Pizza(int sizeId, int isFinished, int crustTypeId, double price, int orderId) {
        this.sizeId = sizeId;
        this.isFinished = isFinished;
        this.crustTypeId = crustTypeId;
        this.price = price;
        this.orderId = orderId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public int getCrustTypeId() {
        return crustTypeId;
    }

    public void setCrustTypeId(int crustTypeId) {
        this.crustTypeId = crustTypeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
}
