/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author aaron
 */

import java.io.Serializable;
import java.sql.Timestamp;


public class Order implements Serializable{
    private int orderID;
    private int customerID;
    private double orderTotal;
    private Timestamp orderDate;
    private String orderStatus;
    
    
    public Order(int orderID, int customerID, double orderTotal, Timestamp orderDate, String orderStatus){
    
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
        
    }public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
        
    }public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}
