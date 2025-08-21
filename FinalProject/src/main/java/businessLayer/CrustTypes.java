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
public class CrustTypes {
    private int crustId;
    private String name;

    public CrustTypes() {
    }

    public CrustTypes(int crustId, String name) {
        this.crustId = crustId;
        this.name = name;
    }

    public int getCrustId() {
        return crustId;
    }

    public void setCrustId(int crustId) {
        this.crustId = crustId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
