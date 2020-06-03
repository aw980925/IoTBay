/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import uts.isd.dao.DBConnector;
import uts.isd.dao.DBManager;
import uts.isd.model.User;

/**
 *
 * @author yoonkoo
 */
public class testManager {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;

    public static void main(String[] args) throws SQLException {
        (new testManager()).testRead();
    }

    public testManager() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 private char readChoice() {
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException {
        char c;

        while ((c = readChoice()) != '*') {
            switch (c) {
              
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
               
              
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }



    private void testRead() throws SQLException {
       
        System.out.print("Customer email: ");
        String email = in.nextLine();
        System.out.print("password: ");
        String password= in.nextLine();
        User user = db.findUser(email,password);
        if (user != null) {
            System.out.println(
                    "Customer " + user.getfName() + " " + user.getlName() + " exists in the database.");
        } else {
            System.out.println("Customer does not exits.");
        }

    }

    private void testUpdate() {
        System.out.print("Customer email: ");
        String email = in.nextLine();
        System.out.print("password: ");
        String password= in.nextLine();

        try {
            if (db.findUser(email,password) != null) {
                System.out.print("Customer first name: ");
                String fname = in.nextLine();
                System.out.print("Customer last name: ");
                String lname = in.nextLine();
                System.out.print("Customer password: ");
                String pass = in.nextLine();
                System.out.print("Customer phone number: ");
                String phone = in.nextLine();
                System.out.print("Customer street address: ");
                String streetAddr = in.nextLine();
                System.out.print("Customer unit number: ");
                String unitNo = in.nextLine();
                System.out.print("Customer city: ");
                String city = in.nextLine();
                System.out.print("Customer state: ");
                String state = in.nextLine();
                System.out.print("Customer post code: ");
                String postCode = in.nextLine();
                System.out.print("Customer gender: ");
                String gender = in.nextLine();
                System.out.print("Customer active (true/false): ");
                boolean active = in.nextBoolean();
                in.nextLine(); // Consume newline left-over from nextBoolean()
                //db.updateUser(email, fname, lname, password, gender, unitNo, streetAddr, city, state, postCode, phone, active);
            } else {
                System.out.println("Customer does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(testManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
   
   
    
}

    
