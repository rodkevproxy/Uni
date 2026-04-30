package com.mycompany.cosc005w_mock_planeapp;

public class Payment {

    // the atributes
    String email; 
    int paymentAmount; 
    
    // constructor 
    public Payment ( String email, int paymentAmount ){ 
        this.email = email; 
        this.paymentAmount = paymentAmount;

    }

    // this two are the getters, getters make a field readable and you can add more logic changes 
    public String getEmail () {
        return this.email;
    }

    public int getPaymentAmount () {
        return this.paymentAmount;
    }

    // this two are the setters

    public void setEmail (String email) {
        this.email = email; 
    }

    public void setPaymentAmount (int paymentAmount){
        this.paymentAmount = paymentAmount;

    }

    public void printPayment () { 
        System.out.println("Email: " + " " + this.email + " " + "| Amount: " + this.paymentAmount);
    }






}   
