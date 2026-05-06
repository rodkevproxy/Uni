package com.mycompany.cosc005w_mock_planeapp;

public class Snack {
    String snackName; 
    int price; 

// constructor 
public Snack (String snackName, int price ){
    this.snackName = snackName; 
    this.price = price; 

}

public String getSnackName () {
    return this.snackName; 
}

public int getPrice () {
    return this.price;
}

public void setSnackNanme (String snackName) {
    this.snackName = snackName;
} 

public void setPrice (int price) {
    this.price = price;
}

public void printSnack () {

System.out.println ("Snack: " + this.snackName + "Price: " + this.price);

}

}


