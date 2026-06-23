package com.mycompany.cineapp;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class App {

    // --- GLOBAL VARIABLES ---
    static int[][] cinemaSeats;
    
    // Task 4: Snack Array and Counter
    static Snack[] snacks = new Snack[50];
    static int snackCounter = 0;
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Indie Cinema!");
        initialiseSeats();
        runMenu();
    }

    // Task 1: Cinema Layout Refit
    private static void initialiseSeats() {
        cinemaSeats = new int[4][];
        cinemaSeats[0] = new int[6]; 
        cinemaSeats[1] = new int[12]; 
        cinemaSeats[2] = new int[12]; 
        cinemaSeats[3] = new int[8]; 
    }

    private static void runMenu() {
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n+--- MAIN MENU ---+");
            System.out.println("1) Book a movie seat");
            System.out.println("2) Show seating area");
            System.out.println("3) Buy a Snack");
            System.out.println("4) Search Snacks");
            System.out.println("5) Save End of Day Report");
            System.out.println("0) Quit");
            System.out.println("+-----------------+");
            System.out.print("Please select an option: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    bookSeat();
                    break;
                case 2:
                    showSeatingArea();
                    break;
                case 3:
                    buySnack();
                    break;
                case 4:
                    searchSnacks();
                    break;
                case 5:
                    saveSnacksToFile();
                    break;
                case 0:
                    System.out.println("Enjoy the movie!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    // Task 2: Booking Validation
    private static void bookSeat() {
        Scanner input = new Scanner(System.in);
        int rowNumber; 
        
        do {
            System.out.print("Enter row number (1-4): ");
            rowNumber = input.nextInt();

            if (rowNumber < 1 || rowNumber > 4){
                System.out.println("Invalid row number, please select between 1 and 4.");
            }
        } while (rowNumber < 1 || rowNumber > 4);

        int row = rowNumber - 1; 
        
        System.out.print("Enter seat number: ");
        int seat = input.nextInt() - 1;

        if (cinemaSeats[row][seat] == 0) {
            cinemaSeats[row][seat] = 1;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Sorry, that seat is already taken.");
        }
    }

    private static void showSeatingArea() {
        System.out.println("\n--- SCREEN ---");
        for (int row = 0; row < cinemaSeats.length; row++) {
            System.out.print("Row " + (row + 1) + ": ");
            for (int seat = 0; seat < cinemaSeats[row].length; seat++) {
                if (cinemaSeats[row][seat] == 0) {
                    System.out.print("[0] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
    }
    
    // Task 4: Buying Snacks
    private static void buySnack() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a snack name: ");
        String snackName = input.next(); 

        System.out.print("Enter a price: £");
        int snackPrice = input.nextInt();

        Snack newSnack = new Snack(snackName, snackPrice);
        snacks[snackCounter] = newSnack;
        snackCounter++; 
        
        System.out.println("Snack purchased successfully!");
    }
    
    // Task 5: Snack Audit
    private static void searchSnacks() {
        Scanner input = new Scanner(System.in);
        boolean snackMatch = false;

        System.out.print("Enter the maximum price for the snack: £");
        int snackMatchPrice = input.nextInt(); 
        
        System.out.println("--- SNACKS UNDER £" + snackMatchPrice + " ---");

        for (int i = 0; i < snackCounter; i++) {
            Snack currentSnack = snacks[i];
            
            if (currentSnack.getPrice() <= snackMatchPrice) {
                currentSnack.printSnack();
                snackMatch = true;
            }
        }

        if (snackMatch == false) {
            System.out.println("No match was found, please try again.");
        }
        System.out.println("-------------------------");
    }
    
    // Task 6: End of Day Report
    private static void saveSnacksToFile() {
        try { 
            PrintWriter writer = new PrintWriter(new FileWriter("DailySnacks.txt"));

            for (int i = 0; i < snackCounter; i++){
                Snack currentSnack = snacks[i];
                writer.println("Snack: " + currentSnack.getSnackName() + " | Price: £" + currentSnack.getPrice());
            }

            writer.close();
            System.out.println("File has been saved successfully!");
            
        } catch (IOException e) {
            System.out.println("Error saving the file: " + e.getMessage());
        }
    }
}