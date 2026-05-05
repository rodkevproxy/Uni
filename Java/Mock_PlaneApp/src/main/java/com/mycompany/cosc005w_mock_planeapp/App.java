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
        planeSeats = new int[4][]; // total rows - multidimensional array
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
                case 10: 
                System.out.println("Thank you for flying with us");                        
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
        boolean foundMatch = false; //boolean flag to display when a payment is not found 
        
        System.out.println("Eneter a payment amout to search for: ");
        int searchAmout = input.nextInt(); 

         for (int i  = 0; i < paymentCounter; i ++) { 
            Payment currentPayment = payments[i]; 
            
        if (currentPayment.getPaymentAmount() == searchAmout){
            System.out.println("- " + currentPayment.getPaymentAmount());

            foundMatch = true; 

        }                 
    }

    if (foundMatch == false ){ 
        System.out.println("No payments were found with that amount ");
    }

    }

    private static void buyTicket() {

        Scanner input = new Scanner(System.in);
        int rowNumber; // Variable to hold the raw input (1-4)

        do {
        System.out.print("Enter row number: ");
        rowNumber = input.nextInt();

        if (rowNumber < 1 || rowNumber > 4){
            System.out.println("Invalid row! Please choose between 1 and 4.");
        }
    } while (rowNumber < 1 || rowNumber > 4); 

        // up to this point we are safe because we know that the row entered will be the correct one 
        // we substract one so it matches the 0 count based java method 

        int row = rowNumber - 1; 

        // Now we need to get the seat and buy the ticket
        System.out.println( "Enter the seat number: " );
        int seat = input.nextInt() - 1;
        
        // Now we need to check if the seat is available or not 

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
            PrintWriter writer = new PrintWriter(new FileWriter("Payment.txt"));

            for(int i = 0; i < paymentCounter; i ++){
                Payment currentPayment = payments[i];

                writer.println("Email: " + currentPayment.getEmail() + " | Amount:  £ " + currentPayment.getPaymentAmount());
            }

            // Close the file when it is done 
            writer.close(); 
            System.out.println("Payments successfully saved to file! ");
        }catch(IOException e){ 
            System.out.println("Erros saving file: " + e.getMessage());
        }
    }




}
