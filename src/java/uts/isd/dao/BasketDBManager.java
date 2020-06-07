package uts.isd.dao;

import uts.isd.model.*;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class BasketDBManager {

private Statement st;
   
public BasketDBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find user by email and password in the database   
public Product findProduct(String name) throws SQLException {   

    String fetch = "select * from PRODUCT where productName = '" + name + "'";
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()) {
        String sn = rs.getString(3);
        if (name == sn){
            int productID = rs.getInt(1);
            int categoryID = rs.getInt(2);
            double productPrice = rs.getInt(4);
            String description = rs.getString(5);
            String status = rs.getString(6);
            int quantity = rs.getInt(7);
            
            return new Product( productID,categoryID, name, productPrice, description, status, quantity);
        }
    }            
   return null;  
}
 
//Add a user-data into the database   
public void addProduct(int categoryID, String name, double price, String description, String status, int quantity ) throws SQLException { //code for add-operation       
  st.executeUpdate("INSERT INTO PRODUCT " + "VALUES ('" + categoryID + "', '" + name + "', '" + price + "', '" + description + "', '" + status + "', '" + quantity + "')");   

}

//update a user details in the database   
public void updateProduct(int id, int categoryID, String name, double price, String description, String status, int quantity) throws SQLException {        
  st.executeUpdate("UPDATE PRODUCT SET PRODUCTNAME ='" + name + "', PRODUCTPRICE = '" + price + "', DESCRIPTION='" + description + "', STATUS= '" + status + "', QUANTITY= '" + quantity + "' WHERE PRODUCTID='" + id + "'");            

}       

//delete a user from the database   
public void deleteProduct(int id) throws SQLException{       
   st.executeUpdate("DELETE FROM PRODUCT WHERE PRODUCTID='" + id + "'");

}

public ArrayList<Product> fetchProduct() throws SQLException {
    String fetch = "select * from Product";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Product> temp = new ArrayList();
    
    while (rs.next()){
            int productID = rs.getInt(1);
            int categoryID = rs.getInt(2);
            String productName = rs.getString(3);
            double productPrice = rs.getInt(4);
            String description = rs.getString(5);
            String status = rs.getString(6);
            int quantity = rs.getInt(7);
            temp.add(new Product(productID ,categoryID, productName, productPrice, description, status, quantity));
    } return temp;
}



}