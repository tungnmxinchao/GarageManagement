/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author TNO
 */
public class SaleInvoice {
    private int invoiceID;
    private Date invoiceDate;
    
    private SalesPerson salePerson;
    private Cars car;
    private Customer customer;

    public SaleInvoice() {
    }

    public SaleInvoice(int invoiceID, Date invoiceDate, SalesPerson salePerson, Cars car, Customer customer) {
        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.salePerson = salePerson;
        this.car = car;
        this.customer = customer;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public SalesPerson getSalePerson() {
        return salePerson;
    }

    public void setSalePerson(SalesPerson salePerson) {
        this.salePerson = salePerson;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "SaleInvoice{" + "invoiceID=" + invoiceID + ", invoiceDate=" + invoiceDate + ", salePerson=" + salePerson + ", car=" + car + ", customer=" + customer + '}';
    }
    
    
    
}
