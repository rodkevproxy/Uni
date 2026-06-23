package com.mycompany.cineapp;

public class Snack {
    
    // Attributes
    String snackName; 
    int price; 

    // Constructor 
    public Snack(String snackName, int price){
        this.snackName = snackName; 
        this.price = price; 
    }

    // Getters
    public String getSnackName() {
        return this.snackName; 
    }

    public int getPrice() {
        return this.price;
    }

    // Setters
    public void setSnackName(String snackName) {
        this.snackName = snackName;
    } 

    public void setPrice(int price) {
        this.price = price;
    }

    // Print Method
    public void printSnack() {
        System.out.println("Snack: " + this.snackName + " | Price: £" + this.price);
    }

}


