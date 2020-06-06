package uts.isd.model;



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
enum usertype{
    Customer,
    Staff;
}
public class User implements Serializable {
    
    //private String userID;

    private int id;
    private String fName;
    private String lName;
    private String password;
    private String email;
    private String mobileNum;
    private String address;
    private String usertype;
    private boolean active;
   // ArrayList<String> ID_List = new ArrayList<String>();
    
//Constructor
    public User(int id, String fName, String lName, String password, String email, String mobileNum, String address,String usertype,boolean active) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.email = email;
        this.mobileNum = mobileNum;
        this.address = address;
        this.usertype = usertype;
        this.active = active;
        //this.userID = createUserID();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

  /*public String getUserID() {
        return userID;
    }
  
   public String createUserID(){
   
     int num = 1000+ new Random().nextInt(9000);
     String number = Integer.toString(num);
        //1000<n<9999 
    //if same id exists in the array
    if(!checkSameID(number))
    {
        createUserID();
    } //generate userID again
   
        ID_List.add(number);
        return number;
        
     // if not saved to ID_List
    
 }
  
   //check there is same ID in the listarray
   public boolean checkSameID(String number){
       
           for(int i=0;i<ID_List.size();i++)
        {
            if(ID_List.get(i).equals(number))
            return false;
            
        }
           return true;
      
   }*/
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


    
  
}
