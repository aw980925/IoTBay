package uts.isd.model;

import java.io.Serializable;
/*enum cardType{
    Paypal,
    CreditCard;
}
8/
/**
 *
 * @author parkjunhyun
 */
public class Card implements Serializable{
    
   
    private String cardNumber;
    private String expiresOn;
    private String cvvNumber;
    
    
    //private String paymenttype;
    
    
    //insert a constructor that initialize the fields
    
    public Card(String cardNumber, String expiresOn, String cvvNumber) {
      
    //    this.description = description;
        
        this.cardNumber = cardNumber;
        this.expiresOn = expiresOn;
        this.cvvNumber = cvvNumber;
    //    this.amount = amount;
    //    this.paymenttype = paymenttype;
    //    this.paymentStatus = paymentStatus;

    }
    
   

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(String expiresOn) {
        this.expiresOn = expiresOn;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }
    
  /*  public String getPaymentType() {
        return paymenttype;
    }

    public void setPaymentType(String paymentType) {
        this.paymenttype = paymentType;
    }
  */  
  

    
    
    
}

    
  /*  private int paymentID;
    private int paymentDate;
    private double amount;
    private String paymentType;
    private int creaditCardNumber;
    private int expiresOn;
    private int cvvNumber;
*/
