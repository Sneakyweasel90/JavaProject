/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessLayer;

import jakarta.ejb.Stateless;
import java.time.LocalDateTime;
/**
 *
 * @author neilm
 */
@Stateless
public class Order {
    private int orderId;
    private double totalPrice;//shows as a float
    private LocalDateTime deliveryDateTime;
    private LocalDateTime placedDateTime;
    private int customerId;
    private String orderStatus;

    public Order() {
    }

    public Order(int orderId, double totalPrice, LocalDateTime deliveryDateTime, LocalDateTime placedDateTime, int customerId, String orderStatus) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.deliveryDateTime = deliveryDateTime;
        this.placedDateTime = placedDateTime;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public LocalDateTime getPlacedDateTime() {
        return placedDateTime;
    }

    public void setPlacedDateTime(LocalDateTime placedDateTime) {
        this.placedDateTime = placedDateTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}
