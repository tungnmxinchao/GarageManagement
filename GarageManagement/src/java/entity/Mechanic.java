/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author TNO
 */
public class Mechanic {
    private int mechanicID;
    private String mechanicName;

    public Mechanic() {
    }

    public Mechanic(int mechanicID, String mechanicName) {
        this.mechanicID = mechanicID;
        this.mechanicName = mechanicName;
    }

    public int getMechanicID() {
        return mechanicID;
    }

    public void setMechanicID(int mechanicID) {
        this.mechanicID = mechanicID;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    @Override
    public String toString() {
        return "Mechanic{" + "mechanicID=" + mechanicID + ", mechanicName=" + mechanicName + '}';
    }
    
    
}
