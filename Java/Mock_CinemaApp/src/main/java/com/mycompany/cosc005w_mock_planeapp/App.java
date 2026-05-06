package com.mycompany.cosc005w_mock_planeapp;

import java.util.Scanner;

public class App {
    // --- GLOBAL VARIABLES ---
    static int[][] cinemaSeats;
    static Snack[] snacks = new Snack[50];
    static int snackCounter = 0;        
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Indie Cinema!");
        initialiseSeats();
        runMenu();
    }

    private static void initialiseSeats() {
        // Currently sets up a small cinema with 3 rows of 10 seats each.
        cinemaSeats = new int[3][];
        cinemaSeats[0] = new int[6];
        cinemaSeats[0] = new int[12]; 
        cinemaSeats[1] = new int[12]; 
        cinemaSeats[2] = new int[8]; 
    }

    private static void runMenu() {
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n+--- MAIN MENU ---+");
            System.out.println("1) Book a movie seat");
            System.out.println("2) Show seating area");
            System.out.println("3) Search snacks");
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
                case 4: 
                    searchSnacks();
                case 0:
                    System.out.println("Enjoy the movie!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    private static void bookSeat() {
        Scanner input = new Scanner(System.in);
        int rowNumber; 
        do{
            System.out.print("Enter row number: ");
            rowNumber = input.nextInt();

            if (rowNumber < 1 || rowNumber > 4){
                System.out.println("Invalid row number, please select between 1 and 4 ");

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

    private static void buySnack () {

        // first as always we initialize the scanner and ask the user for the values and input

        Scanner imput = new Scanner (System.in);
        System.out.println("Enter a snack name: ");
        String snackName = input.next(); 

        System.out.println("Enter a price: ");
        int snackPrice = input.nextInt();

        // Create the object to store it in our array 

        Snack newSnack = new Snack (snackName, snackPrice);

        // Now we add the object to the array 

        snacks[snackCounter] = newSnack;

        snackCounter++; 

        }

    private static void searchSnacks() {
        Scanner input = new Scanner (System.in);
        boolean snackMatch = false;

        System.out.println("Enter the maximum price for the snack");
        int snackMatchPrice = input.nextInt(); 

        for (int i = 0; i < snackCounter; i ++) {
            Snack currentSnack = snacks[i];
            
            if (currentSnack.getPrice() <= snackMatchPrice ){
                currentSnack.printSnack();
            }
            snackMatch = true; 

        }



        if (snackMatch == false) {
            System.out.println("No match was found, please try again. ");
        }




    }
 
}
