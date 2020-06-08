package uts.isd.dao;

import uts.isd.model.*;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class OrderLineDBManager {

private Statement st;
   
public OrderLineDBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

 
public OrderLine findOrderLine(int customerID) throws SQLException {   

    String fetch = "select * from ORDERLINE where customerID = '" + customerID + "'";
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()) {
        int id = rs.getInt(2);
        if (id == customerID){
            int productID = rs.getInt(1);
            int orderQty = rs.getInt(3);
            Double price = rs.getDouble(4);
            
            return new OrderLine(productID, customerID, orderQty, price);
        }
    }            
   return null;   
}


//Add a user-data into the database   
public void addOrderLine(int productID, int customerID, int orderQty, double price ) throws SQLException { //code for add-operation       
  st.executeUpdate("INSERT INTO ORDERLINE " + "VALUES ('" + productID + "', '" + customerID + "', '" + orderQty + "', '" + price + "')");   

}

//update a user details in the database   
public void updateOrderLine(int productID, int customerID, int orderQty, double price ) throws SQLException {        
  st.executeUpdate("UPDATE ORDERLINE SET orderQty='" + orderQty + "', price= '" + price + "' WHERE productID='" + productID + "', customerID='" + customerID +"'");            

}       

//delete a user from the database   
public void deleteOrderLine(int productID) throws SQLException{       
   st.executeUpdate("DELETE FROM ORDERLINE WHERE PRODUCTID='" + productID + "'");

}

public ArrayList<OrderLine> fetchOrderLine(int customerID) throws SQLException {
    String fetch = "select * from ORDERLINE where customerID=" + customerID;
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<OrderLine> temp = new ArrayList();
    
    while (rs.next()){
            int productID = rs.getInt(1);
            int orderQty = rs.getInt(3);
            double orderPrice = rs.getDouble(4);
            
            temp.add(new OrderLine(productID ,customerID, orderQty, orderPrice));
    } return temp;
}



}