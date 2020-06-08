package uts.isd.model;

import java.io.Serializable;
enum paymentType{
    Paypal,
    CreditCard;
}
/**
 *
 * @author parkjunhyun
 */
public class Payment implements Serializable{
    
    private int paymentID;
    //private int paymentTime;     // will change to timestamp later
    private String description;
    private String cardNumber;
    private String expiresOn;
    private String cvvNumber;
    private String amount;
    private String paymenttype;
    private String paymentStatus;
    
    //insert a constructor that initialize the fields
    
    public Payment(int paymentID, String cardNumber, String expiresOn, String cvvNumber) {
        this.paymentID = paymentID;
    //    this.description = description;
        this.cardNumber = cardNumber;
        this.expiresOn = expiresOn;
        this.cvvNumber = cvvNumber;
    //    this.amount = amount;
        this.paymenttype = paymenttype;
    //    this.paymentStatus = paymentStatus;

    }
    
    //insert getters/setters
    
    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public String getPaymentType() {
        return paymenttype;
    }

    public void setPaymentType(String paymentType) {
        this.paymenttype = paymentType;
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
  

    
    
    
}

    
  /*  private int paymentID;
    private int paymentDate;
    private double amount;
    private String paymentType;
    private int creaditCardNumber;
    private int expiresOn;
    private int cvvNumber;
*/
