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
public class ServiceTicket {

    private int serviceTicketID;
    private Date dateReceived;
    private Date dateReturned;

    private Customer customer;
    private Cars car;

    public ServiceTicket() {
    }

    public ServiceTicket(int serviceTicketID, Date dateReceived, Date dateReturned, Customer customer, Cars car) {
        this.serviceTicketID = serviceTicketID;
        this.dateReceived = dateReceived;
        this.dateReturned = dateReturned;
        this.customer = customer;
        this.car = car;
    }

    public int getServiceTicketID() {
        return serviceTicketID;
    }

    public void setServiceTicketID(int serviceTicketID) {
        this.serviceTicketID = serviceTicketID;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "ServiceTicket{" + "serviceTicketID=" + serviceTicketID + ", dateReceived=" + dateReceived + ", dateReturned=" + dateReturned + ", customer=" + customer + ", car=" + car + '}';
    }

}
