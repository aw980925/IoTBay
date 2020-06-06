package uts.isd.dao;

import uts.isd.model.Product;
import java.sql.*;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class ProductDBManager {

private Statement pd;
   
public ProductDBManager(Connection conn) throws SQLException {       
   pd = conn.createStatement();   
}

//Find user by email and password in the database   
public Product findProduct(String PID) throws SQLException {   

    String fetch = "select * from PRODUCT where productID = '" + PID + "'";
    ResultSet rs = pd.executeQuery(fetch);
    
    while(rs.next()) {
        String productInfo = rs.getString(1);
    }
   //setup the select sql query string       
   //execute this query using the statement field       
   //add the results to a ResultSet       
   //search the ResultSet for a user using the parameters               
   return null;   
}

//Add a user-data into the database   
public void addProduct(String email, String name, String password, String gender, String favcol) throws SQLException {                   //code for add-operation       
  pd.executeUpdate("sql query");   

}

//update a user details in the database   
public void updateProduct( String email, String name, String password, String gender, String favcol) throws SQLException {       
   //code for update-operation   

}       

//delete a user from the database   
public void deleteProduct(String email) throws SQLException{       
   //code for delete-operation   

}


}