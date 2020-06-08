package uts.isd.dao;

import uts.isd.model.*;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class OrderDBManager {

private Statement st;
   
public OrderDBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

 
public Order findOrder(int customerID) throws SQLException {   

    String fetch = "select * from ORDERS where customerID = '" + customerID + "'";
    ResultSet rs = st.executeQuery(fetch);
    
    while(rs.next()) {
        int id = rs.getInt(2);
        if (id == customerID){
            int orderID = rs.getInt(1);
            Double orderTotal = rs.getDouble(3);
            Timestamp orderDate = rs.getTimestamp(4);
            String orderStatus = rs.getString(5);
            
            return new Order(orderID, customerID, orderTotal, orderDate, orderStatus);
        }
    }            
   return null;   
}


//Add a orderline into the database   
public void addOrder(int orderID, int customerID, double orderTotal, Timestamp orderDate, String orderStatus ) throws SQLException { //code for add-operation       
  st.executeUpdate("INSERT INTO ORDERS " + "VALUES ('" + orderID + "', '" + customerID + "', '" + orderTotal + "','" + orderDate + "','"+ orderStatus + "')");   

}

//update a orderline status in the database   
public void updateOrder(int orderID, int customerID, String orderStatus ) throws SQLException {        
  st.executeUpdate("UPDATE ORDERS SET orderStatus='" + orderStatus + "' WHERE productID='" + orderID + "', customerID='" + customerID +"'");            

}       

//delete a order from the database   
public void deleteOrder(int orderID) throws SQLException{       
   st.executeUpdate("DELETE FROM ORDERS WHERE PRODUCTID='" + orderID + "'");

}

public ArrayList<Order> fetchOrder(int customerID) throws SQLException {
    String fetch = "select * from ORDERS where customerID = '" + customerID;
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Order> temp = new ArrayList();
    
    while (rs.next()){
            int orderID = rs.getInt(1);
            Double orderTotal = rs.getDouble(3);
            Timestamp orderDate = rs.getTimestamp(4);
            String orderStatus = rs.getString(5);
            
            temp.add(new Order(orderID ,customerID, orderTotal, orderDate, orderStatus));
    } return temp;
}



}