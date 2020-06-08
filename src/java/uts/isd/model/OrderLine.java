/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author aaron
 */
public class OrderLine implements Serializable{
    
    private int productID;
    private int customerID;
    private int orderQty;
    private double orderPrice;

    public OrderLine(int productID, int customerID, int orderQty, double orderPrice) {
        this.productID = productID;
        this.customerID = customerID;
        this.orderQty = orderQty;
        this.orderPrice = orderPrice;
    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

        public int customerID() {
        return customerID;
    }

    public void setCustmerID(int customerID) {
        this.customerID = customerID;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getOrderPrice() {
        
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        
        this.orderPrice = orderPrice;
    }
    
    
}
