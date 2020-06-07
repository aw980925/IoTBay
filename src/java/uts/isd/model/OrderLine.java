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
    
    private int OrderLineNo;
    private int productID;
    private double unitPrice;
    private int orderQty;
    private double orderPrice;

    public int getOrderLineNo() {
        return OrderLineNo;
    }

    public void setOrderLineNo(int OrderLineNo) {
        this.OrderLineNo = OrderLineNo;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getOrderPrice() {
        
        orderPrice = unitPrice * orderQty;
        
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = unitPrice * orderQty;
    }
    
    
}
