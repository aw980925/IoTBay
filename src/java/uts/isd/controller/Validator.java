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
   import java.io.Serializable;
   import java.util.regex.Matcher;
   import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

   public class Validator implements Serializable{ 
  
   private final String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";       
   private final String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";        
   private final String passwordPattern = "^(?=.*\\d)(?=.*[a-zA-Z])(?!.*[\\W_\\x7B-\\xFF]).{6,15}$"; 
   private final String cardNumberPattern = "^[0-9]*$";
   private final String expiresOnPattern = "^[0-9]*$";
   private final String cvvNumberPattern = "^[0-9]*$";
   //구글에 카드 validation pattern 
/*Password validator Requires 6-20 characters including at least 1 upper or lower alpha, and 1 digit. 
 It should disallow just about everything else, 
 inluding extended characters.*/
   //example : BA99342bob 
   public Validator(){}

   public boolean validate(String pattern, String input){        
      Pattern regEx = Pattern.compile(pattern);        
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }        
   public boolean checkEmpty(String email, String password){       
      return  email.isEmpty() || password.isEmpty();   
   }
    
   public boolean validateEmail(String email){                       
      return validate(emailPattern,email);   
   }
        
   public boolean validateName(String name){
      return validate(namePattern,name); 
   }        
   
   public boolean validatePassword(String password){
      return validate(passwordPattern,password); 
   }          
   
   public boolean validateCardNumber(String password){
      return validate(cardNumberPattern,password); 
   }          
      
   public boolean validateExpiresOn(String password){
      return validate(expiresOnPattern,password); 
   }          
         
   public boolean validateCvvNumber(String password){
      return validate(cvvNumberPattern,password); 
   }          
   
   

   public void clear(HttpSession session) {
       session.setAttribute("emailErr", "Enter email");
       session.setAttribute("passErr", "Enter password");
       session.setAttribute("existErr", "");
       session.setAttribute("cardNumberErr", "Enter card number");
       session.setAttribute("expiresOnErr", "Enter Expire date");
       session.setAttribute("cvvNumberErr", "Enter cvv number");
       
       
//To change body of generated methods, choose Tools | Templates.
    }
}