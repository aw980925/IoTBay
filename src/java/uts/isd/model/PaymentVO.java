/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author parkjunhyun
 */


import java.sql.Timestamp;

public class PaymentVO {
    
    int paymentID;
    int orderID;
    int userId;
    int amount;
    Timestamp paymentTime;
    
    int customerID;
    int orderTotal;
    Timestamp orderDate;
    String orderStatus;
                        
    public PaymentVO(){
        
    }

    public PaymentVO(int orderID, int userId, int amount) {
        this.orderID = orderID;
        this.userId = userId;
        this.amount = amount;
        
    }
    
    public PaymentVO(int paymentID, int orderID, int userId, int amountpaymentTime, Timestamp paymentTime) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.userId = userId;
        this.amount = amount;
       this.paymentTime = paymentTime;
    }

    public PaymentVO(int paymentID, int orderID, int userId, int amount, Timestamp paymentTime, int customerID, int orderTotal, Timestamp orderDate, String orderStatus) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.userId = userId;
        this.amount = amount;
        this.paymentTime = paymentTime;
        this.customerID = customerID;
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
    
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }

    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}