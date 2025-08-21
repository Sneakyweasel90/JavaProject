/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businessLayer;

import jakarta.ejb.Stateless;
import java.sql.Date;
/**
 *
 * @author neilm
 */
@Stateless
public class Toppings {
    private int toppingId;
    private String name;
    private Double price;
    private Date createddate;
    private int empAddDate;
    private int isActive;
    
    public Toppings() {
    }

    public Toppings(int toppingId, String name, Double price, Date createddate, int empAddDate, int isActive) {
        this.toppingId = toppingId;
        this.name = name;
        this.price = price;
        this.createddate = createddate;
        this.empAddDate = empAddDate;
        this.isActive = isActive;
    }

    public int getEmpAddDate() {
        return empAddDate;
    }

    public void setEmpAddDate(int empAddDate) {
        this.empAddDate = empAddDate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }


    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }
}
