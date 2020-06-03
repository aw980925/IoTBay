package uts.isd.controller;

 

import java.sql.*;

import java.util.*;

import uts.isd.model.dao.*;

 

public class TestMongoDB {

 

    private static Scanner in = new Scanner(System.in);

    private MongoDBManager mongo;

 

    public static void main(String[] args) throws SQLException {

        TestMongoDB testDB = new TestMongoDB();

        testDB.connect();

        testDB.runQueries();

    }

 

    //create an instance of MongoDBManager to access the CRUD operations

    public TestMongoDB() {

        this.mongo = new MongoDBManager();

    }

 

    //Connect to a particular collection in the Atlas database

    private void connect() {

        String name = read(">> Access collection");

        this.mongo.connect(name);

        System.out.println(">> Connected to MongoDB-" + name + " collection.\n");

    }

 

    //Read user input commands

    private char readChoice() {

        System.out.print("Operation CRUDS-V or * to exit: ");

        return in.nextLine().charAt(0);

    }

 

    //Execute the test CRUD operations from user commands

    private void runQueries() throws SQLException {

        char c;

 

        while ((c = readChoice()) != '*') {

            switch (c) {

                case 'C':

                    testCreate();

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

                case 'V':

                    view();

                    break;

                case 'E':

                    connect();

                    break;

                default:

                    System.out.println("Unknown Command");

                    break;

            }

        }

    }

 

    //Read parameter values

    private String read(String action) {

        System.out.print("Enter " + action + ": ");

        return in.nextLine();

    }

  

    //Test Create operation

    private void testCreate() {

        mongo.create( <read the necessary parameters> );

        System.out.println("Enrollment is added to the database.");

    }

 

     //Test Read operation

    private void testRead() throws SQLException {

        mongo.read( <read the necessary parameters> );

    }

 

     //Test Update operation

    private void testUpdate() {

        mongo.update( <read the necessary parameters> );

    }

 

    //Test Delete operation

    private void testDelete() {

        mongo.delete( <read the necessary parameters>);

    }

   

    //Test Fetch All operation

    private void showAll() {

        mongo.showCollection();

    }

}