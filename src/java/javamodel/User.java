package javamodel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 13093950 Heeyoon Koo
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class User implements Serializable {
    
    private String userID;
    private String fName;
    private String lName;
    private String password;
    private String email;
    private String mobileNum;
    private String address;
    ArrayList<String> usersID = new ArrayList<String>();
    
//Constructor
    public User(String fName, String lName, String password, String email, String mobileNum, String address) {
        
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.email = email;
        this.mobileNum = mobileNum;
        this.address = address;
    }
//Getters and Setters
 
   public String createUserID(){
   
     int num = 1000+ new Random().nextInt(9000);
     String number = Integer.toString(num);
        //1000<n<9999 
        usersID.add(number);
        //array loop check, if theres same id
        // get random number again
        return number;
     }
   public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //enum user activity
    //enum user file 
    enum userActivity 
    {
        Active,
        Non_Active,
        Blocked;
        
    }
    enum userType
    {
        Customer,
        Non_Registered,
        Staff;
        
    }
    
  
}
