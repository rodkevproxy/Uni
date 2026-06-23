/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cosc005w_mock_planeapp;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * // Before you start, complete the following information: 
 * NAME: 
 * SURNAME:
 * STUDENT ID: SESSION (Day + time):
 */
    public class App {

    // Global variables
    private static int[][] planeSeats = null;
    private static int[] pricePerRow = null;
    static Payment[] payments = new Payment[76];
    static int paymentCounter = 0; 

    public static void main(String[] args) {
        System.out.println("Welcome to Flying Java!");
        initialiseRows();
        runMenu();
    }

    public static void initialiseRows() {
        planeSeats = new int[4][];   // total rows - multidimensional array
        planeSeats[0] = new int[18]; // row 1 - initialised at 0 all available
        planeSeats[1] = new int[20]; // row 2 - initialised at 0 all available
        planeSeats[2] = new int[20]; // row 2 - initialised at 0 all available
        planeSeats[3] = new int[18]; // row 2 - initialised at 0 all available
        pricePerRow = new int[4];
        pricePerRow[0] = 50;
        pricePerRow[1] = 80;
        pricePerRow[2] = 80;
        pricePerRow[3] = 50;
    }
 
    public static void runMenu() {
        int option;
        boolean cont = true;

        while (cont) {
            option = getOption();
            switch (option) {
                case 0:
                    cont = false;
                    break;
                case 1:
                    buyTicket();
                    break;
                case 2:
                    showSeatingArea();
                    break;
                case 3: 
                    searchPayment(); // very important to add!          
                case 4: 
                    saveToFile();                      
                default:
                    System.out.println("Option not available. Please select a valid option: ");
            }
        }
    }

    private static int getOption() {

        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int option = -1;
        do {
            System.out.println();
            System.out.println("+---------------------------------------------+");
            System.out.println("|                MAIN MENU                    |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  1) Buy a plane ticket                      |");
            System.out.println("|  2) Show seating area and available seats   |");
            System.out.println("|  3) Search for a payment                    |");
            System.out.println("|  4) Save all payments                       |");
            System.out.println("|  0) Quit                                    |");
            System.out.println("+---------------------------------------------+");
            System.out.print("Please select an option: ");
            try {
                option = input.nextInt();
                valid = true;
            } catch (Exception e) {
                System.out.println("This option not valid.");
            }
        } while (!valid);
        return option;

    }

    private static void searchPayment() {
        Scanner input = new Scanner(System.in);
        boolean found = false; //boolean flag to display when a payment is not found 
        
        System.out.println("Eneter a payment amout to search for: ");
        int amout = input.nextInt(); 

         for (int i  = 0; i < paymentCounter; i ++) { 
            
        if (payments[i].getPaymentAmount() == amout){
            System.out.println("- " + payments[i].getEmail());

            found = true; 

        }                 
    }

    if (found == false ){ 
        System.out.println("No payments were found with that amount ");
    }

    }

    private static void buyTicket() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter row number: ");
        int row = input.nextInt() - 1;

        while (row < 0 || row > planeSeats.length ){

            System.out.println("Row number should be from 1 to 4");
            row = input.nextInt() - 1;
        }

        System.out.println("Enter your seat number");
        int seat = input.nextInt() - 1;

        while (seat < 0 || seat > planeSeats[row].length){
            System.out.println("Row number should be between 1 and " + planeSeats[row].length);
            row = input.nextInt() - 1;
        }


        if (planeSeats[row][seat] == 0) {
            System.out.println("Seat Available! Please enter your email"); 
            String userEmail = input.next(); 

            int price = 0; 
            if (row == 0) {price = 50; }
            else if (row == 1) {price = 80; }
            else if (row == 2) {price = 80; }
            else if (row == 3) {price = 50; }

            Payment newPayment = new Payment(userEmail, price); 
            payments[paymentCounter] = newPayment; 
            paymentCounter ++; 

            planeSeats[row][seat] = 1;
            System.out.println("Purchase succesfull!"); 
            showSeatingArea(); 
        } else { 
            System.out.println("This seat is already taken. ");
        }
    }


    private static void showSeatingArea() {

        int rows = planeSeats.length;
        char aisle = '|';

        System.out.println("=".repeat(76));
        System.out.println("                              PLANE SEATING MAP ");
        System.out.println("=".repeat(76));

        for (int row = 0; row < rows; row++) {
            System.out.print("Row " + (row+1) + "(£" + pricePerRow[row]+ ")  ");
            int seatsPerRow = planeSeats[row].length;
            for (int seat = 0; seat < seatsPerRow; seat++) {
                if (seat == 9) { // Create aisles
                    System.out.print(" " + aisle + " ");
                }
                if (planeSeats[row][seat] == 0) { //available
                    System.out.print("[O]");
                } else { // not available
                    System.out.print("[X]");
                }
            }
            System.out.println();
        }
        System.out.println("=".repeat(76));
        System.out.println("LEGEND: [O] = Seat available, [X] = Seat not available, | = Aisle");
        System.out.println("=".repeat(76));
        System.out.println();

    }

    private static void saveToFile() {
        try{
            // open a new file called payments.txt 
            FileWriter writer = new FileWriter("Payment.txt");
            PrintWriter printWriter = new PrintWriter(writer);
            for(Payment payment : payments){
                if (payment != null){
                printWriter.println("Email: " + payment.getEmail() + " | Amount:  £ " + payment.getPaymentAmount());
                printWriter.close();
                System.out.println("Payment has been saved");
                }

                
            }

            // Close the file when it is done 
            writer.close(); 
            System.out.println("Payments successfully saved to file! ");
        }catch(IOException e){ 
            System.out.println("Erros saving file");
            e.printStackTrace();
        }
    }




}
