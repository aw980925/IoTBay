package uts.isd.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Product;
import uts.isd.dao.*;


/**
 *
 * @author aiswarya.r
 */
public class testProductDB {
    
        private static Scanner in = new Scanner(System.in);
        private DBConnector connector;
        private Connection conn;
        private ProductDBManager db;

        
    public static void main(String[] args) throws SQLException {
         (new testProductDB()).runQueries();
    }

    public testProductDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new ProductDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testProductDB.class.getName()).log(Level.SEVERE, null, ex);
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
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                case 'S':
                    showAll();
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }
     
        private void testAdd() {
       
        System.out.print("Catalogue ID: 1 or 2");
        int categoryID = in.nextInt();    
        System.out.print("Product name: ");
        String productName = in.next();
        System.out.print("Product price: ");
        Double productPrice = in.nextDouble();
        System.out.print("Product description: ");
        String description = in.next();
        System.out.print("Product status: ");
        String status = in.next();
        System.out.print("Available quantity: ");
        int quantity = in.nextInt();
        String productType = in.next();
        in.nextLine(); 
  
        try {
            db.addProduct(categoryID, productName, productPrice, description, status, quantity, productType);
        } catch (SQLException ex) {
            Logger.getLogger(testProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Device is added to the database.");
    }
        
        
        
        private void testRead() throws SQLException {
        
        System.out.print("Product name: ");
        String productName = in.nextLine();
         System.out.print("Product type: ");
        String productType = in.nextLine();

        
        Product product = db.findProduct(productName, productType);
        
        if (product != null) {
            System.out.println("Device: " + product.getProductName() + " " + " exists in the database.");
        } else {
            System.out.println("Device does not exits.");
        }

    }
        
        
        
        private void testUpdate() {
       // System.out.print("Device name: ");
       // String deviceName = in.nextLine();
       // System.out.print("Device type: ");
       // String type = in.nextLine();
        System.out.print("Product id: ");
        int productID = in.nextInt();
        in.nextLine(); 
 
        try {
            Product product = db.findProductID(productID);
            //String oldDeviceName = device.getDeviceName();
            //String oldDeviceType = device.getType();
            
            if (product != null) {
                int categoryID = product.getCategoryID();
                System.out.print("New Product name: ");
                String productName = in.nextLine();
                System.out.print("New Product price: ");
                Double productPrice = in.nextDouble();
                System.out.print("New Product description: ");
                String description = in.nextLine();
                System.out.print("New Product status: ");
                String status = in.nextLine();
                System.out.print("New Available quantity: ");
                int quantity = in.nextInt();
                 System.out.print("New Product type: ");
        String productType = in.nextLine();
        
                
                db.updateProduct( productID,categoryID, productName, productPrice, description, status, quantity, productType);
                System.out.println("Device with id" + productID + " was updated.");
                
            } else {
                System.out.println("Device does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(testProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
          private void testDelete() {
        
        System.out.print("Product id: ");
        int productID = in.nextInt();
        in.nextLine(); 
        
        
        try {
            if (db.findProductID(productID) != null) {
                db.deleteProduct(productID);
                System.out.println("Device ID" + productID +" was deleted from the database.");
            } else {
                System.out.println("Device does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(testProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        private void showAll() throws SQLException {
        try {
            ArrayList<Product> products = db.fetchProduct();
            System.out.println("Product TABLE: ");
            // lambda expression for every device show all product fields 
            products.stream().forEach((product) -> {
                System.out.printf("%-20s %-20s %-20s %-20s %-10s %-100s \n", product.getProductID(), product.getCategoryID(), product.getProductName(), product.getProductPrice(), product.getDescription(), product.getStatus(), product.getQuantity());
            });
            System.out.println();
         } catch (SQLException ex) {
            Logger.getLogger(testProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}