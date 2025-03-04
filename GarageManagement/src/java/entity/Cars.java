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
public class Cars {
    private int carId;
    private String serialNumber;
    private String model;
    private String colour;
    private int year;

    public Cars() {
    }

    public Cars(int carId, String serialNumber, String model, String colour, int year) {
        this.carId = carId;
        this.serialNumber = serialNumber;
        this.model = model;
        this.colour = colour;
        this.year = year;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Cars{" + "carId=" + carId + ", serialNumber=" + serialNumber + ", model=" + model + ", colour=" + colour + ", year=" + year + '}';
    }
    
    
}
