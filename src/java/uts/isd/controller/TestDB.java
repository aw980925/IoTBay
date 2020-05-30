/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

/**
 *
 * @author yoonkoo
 */
import uts.isd.dao.DBConnector;
import uts.isd.dao.DBManager;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
 
public class TestDB {
private static Scanner in = new Scanner(System.in);
 
public static void main(String[] args) {
try {
DBConnector connector = new DBConnector();
Connection conn = connector.openConnection();
DBManager db = new DBManager(conn);
 
System.out.print("User First Name: ");
String fName = in.nextLine();
System.out.print("User Last name: ");
String lName = in.nextLine();
System.out.print("User password: ");
String password = in.nextLine();
System.out.print("User email: ");
String email = in.nextLine();
System.out.print("User mobile number: ");
String mobileNum = in.nextLine();
System.out.print("User address: ");
String address = in.nextLine();

db.addUser(fName,lName,password,email,mobileNum,address);
System.out.println("User is added to the database.");
connector.closeConnection();
 
} catch (ClassNotFoundException | SQLException ex) {
Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
}
}
}