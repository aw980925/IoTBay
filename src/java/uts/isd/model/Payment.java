package uts.isd.model;

import java.io.Serializable;
/**
 *
 * @author parkjunhyun
 */
public class Payment implements Serializable{
    
    private int paymentID;
    private int paymentTime;     // will change to timestamp later
    private String description;
    private int cardNumber;
    private int expiresOn;
    private int cvvNumber;
    private int amount;
    private String paymentType;
    private String paymentStatus;

    //insert a constructor that initialize the fields

    public Payment(int paymentID, int paymentTime, String description, int cardNumber, int expiresOn, int cvvNumber, int amount, String paymentType, String paymentStatus) {
        this.paymentID = paymentID;
        this.paymentTime = paymentTime;
        this.description = description;
        this.cardNumber = cardNumber;
        this.expiresOn = expiresOn;
        this.cvvNumber = cvvNumber;
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
    }
    
    //insert getters/setters

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(int paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(int expiresOn) {
        this.expiresOn = expiresOn;
    }

    public int getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(int cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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
