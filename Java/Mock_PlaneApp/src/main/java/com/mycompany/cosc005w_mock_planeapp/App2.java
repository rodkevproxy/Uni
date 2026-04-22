package com.mycompany.cosc005w_mock_planeapp;

import java.util.Scanner;


public class App2 {

    //Global variables first

    private static int[][] planeSeats = null; 
    private static int[] pricePerRow = null;
    
    public static void main(String[] args) {
        System.out.println( "Welcome to flying java");
        initialiseRows();
        runMenu();
    }

    public static void initialiseRows() {
        planeSeats = new int[4][];
        planeSeats[0] = new int[16]; // row 1 - initialised at 0 all available
        planeSeats[1] = new int[22]; // row 2 - initialised at 0 all available
        planeSeats[2] = new int[22]; // row 2 - initialised at 0 all available
        planeSeats[3] = new int[16]; // row 2 - initialised at 0 all available
        pricePerRow = new int[4];
        pricePerRow[0] = 50;
        pricePerRow[1] = 80;
        pricePerRow[2] = 80;
        pricePerRow[3] = 50;
    }

    
     



}
