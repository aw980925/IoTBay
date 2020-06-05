/*
 * Product is a Javabean that stores productID, productName
 * 
 * 
 */
package uts.isd.model;

import java.io.Serializable;

enum productAvailablilty{
    In_Stock,
    Out_of_Stock;
}
/**
 *
 * @author Hyungju Lee
 */
public class Product implements Serializable{
    
    private int productID;
    private int categoryID;
    private String productName;
    private double productPrice;
    private String description;
    private String status;
    private int quantity;
    
    //insert a constructor that initialize the fields

    public Product(int productID, int categoryID, String productName, double productPrice, String description, String status, int quantity) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.status = status;
        this.quantity = quantity;
    }
    
    //insert getters/setters

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
