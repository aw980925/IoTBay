package uts.isd.dao;

import uts.isd.model.Product;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class ProductDBManager {

private Statement st;
   
public ProductDBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public Product findProduct(String name, String type) throws SQLException {   

    String fetch = "select * from PRODUCT where productName = '" + name + "'AND TYPE='"+ type + "'";
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()) {
        
        String searchProductName = rs.getString(3);
        String searchProductType = rs.getString(8);
        
//        String sn = rs.getString(3);
        if (searchProductName.equals(name)&&searchProductType.equals(type)){
            int productID = rs.getInt(1);
            int categoryID = rs.getInt(2);
            double productPrice = rs.getInt(4);
            String description = rs.getString(5);
            String status = rs.getString(6);
            int quantity = rs.getInt(7);
            
            return new Product( productID,categoryID, name, productPrice, description, status, quantity, type);
        }
    }            
   return null;  
}
 
public Product findProductID(int PID) throws SQLException {   

    String fetch = "select * from PRODUCT where productID = '" + PID + "'";
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()) {
        int id = rs.getInt(1);
        if (id == PID){
            int categoryID = rs.getInt(2);
            String productName = rs.getString(3);
            double productPrice = rs.getInt(4);
            String description = rs.getString(5);
            String status = rs.getString(6);
            int quantity = rs.getInt(7);
            String productType = rs.getString(8);
            
            return new Product( PID,categoryID, productName, productPrice, description, status, quantity, productType);
        }
    }            
   return null;   
}

//Add a user-data into the database   
public void addProduct(int categoryID, String name, double price, String description, String status,  int quantity , String producttype) throws SQLException { //code for add-operation       
  st.executeUpdate("INSERT INTO PRODUCT " + "VALUES ('" + categoryID + "', '" + name + "', '" + price + "', '" + description + "', '" + status + "', '" + quantity + "', '" + producttype + "')");   

}

//update a user details in the database   
public void updateProduct(int id, int categoryID, String name, double price, String description, String status, int quantity, String producttype) throws SQLException {        
  st.executeUpdate("UPDATE PRODUCT SET PRODUCTNAME ='" + name + "', PRODUCTPRICE = '" + price + "', DESCRIPTION='" + description + "', STATUS= '" + status + "', QUANTITY= '" + quantity + "', PRODUCTTYPE= '" + producttype + "' WHERE PRODUCTID='" + id + "'");            

}       

//delete a user from the database   
public void deleteProduct(int id) throws SQLException{       
   st.executeUpdate("DELETE FROM PRODUCT WHERE PRODUCTID='" + id + "'");

}

public ArrayList<Product> fetchProduct() throws SQLException {
    String fetch = "select * from Product";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Product> product = new ArrayList();
    
    while (rs.next()){
            int productID = rs.getInt(1);
            int categoryID = rs.getInt(2);
            String productName = rs.getString(3);
            double productPrice = rs.getInt(4);
            String description = rs.getString(5);
            String status = rs.getString(6);
            int quantity = rs.getInt(7);
            String productType = rs.getString(8);
            product.add(new Product(productID ,categoryID, productName, productPrice, description, status, quantity, productType));
    } return product;
}



}