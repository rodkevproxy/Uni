package com.mycompany.RetroGameStore; // Remember to match your package name!

import java.util.Scanner;
import java.util.FileWriter;
import java.util.PrintWriter;
import java.io.IOException; // Fixed typo here

public class App {

    // --- GLOBAL VARIABLES ---
    static Game[] inventory = new Game[10];
    static int gameCounter = 0;  

    public static void main(String[] args) {
        System.out.println("Welcome to the Retro Game Store!");
        setupStore();
        runMenu(); 
    }

    private static void setupStore() { 
        Game game1 = new Game("Super Mario Kart 8 Deluxe", "Nintendo Switch", 80.00, true);
        inventory[gameCounter] = game1;
        gameCounter++;

        Game game2 = new Game("Mortal Kombat", "PS4", 89.99, true);
        inventory[gameCounter] = game2;
        gameCounter++;

        Game game3 = new Game("Overcooked", "PC", 10.00, true);
        inventory[gameCounter] = game3;
        gameCounter++;

        System.out.println("Shelves are stocked and ready!");
    }

    private static void runMenu() {
        Scanner input = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("\n+--- RETRO STORE MENU ---+");
            System.out.println("1) View All Games");
            System.out.println("2) Buy a Game");
            System.out.println("3) Add New Game to Inventory");
            System.out.println("4) Save Daily Receipts");
            System.out.println("0) Close Store");
            System.out.println("+------------------------+");
            System.out.print("Please select an option: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    viewGames();
                    break;
                case 2:
                    buyGame();
                    break;
                case 3:
                    addNewGame();
                    break;
                case 4:
                    saveReceipts();
                    break;
                case 0:
                    System.out.println("Locking the doors. Goodnight!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    // --- NEW METHOD: View all games ---
    private static void viewGames() {
        System.out.println("\n--- CURRENT INVENTORY ---");
        for (int i = 0; i < gameCounter; i++) {
            inventory[i].printGame();
        }
    }

    // --- NEW METHOD: Add a game ---
    private static void addNewGame() {
        if (gameCounter >= 10) {
            System.out.println("Inventory is full!");
            return;
        }
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter game title: ");
        String title = input.nextLine();
        System.out.print("Enter console: ");
        String console = input.nextLine();
        System.out.print("Enter price: £");
        double price = input.nextDouble();
        
        Game newGame = new Game(title, console, price, true);
        inventory[gameCounter] = newGame;
        gameCounter++;
        System.out.println(title + " has been added to the shelves!");
    }

    private static void buyGame() {
        Scanner input = new Scanner(System.in); 
        boolean gameFound = false;

        System.out.print("What game title are you looking for? ");
        // FIX: Added 'String' to declare the variable
        String titleName = input.nextLine();

        for (int i = 0; i < gameCounter; i++) {  
            Game currentGame = inventory[i];       

            // FIX: lowercase 'e', removed semicolon, added proper curly braces
            if (currentGame.getTitle().equalsIgnoreCase(titleName)) {
                gameFound = true;

                // FIX: Used isInStock()
                if (currentGame.isInStock() == true) {
                    currentGame.setInStock(false);
                    System.out.println("Success! You just got yourself a new title!");
                } else {
                    System.out.println("Sorry, this game is not in stock :/");
                }
            }
        } // The loop ends here
        
        // FIX: Moved this back inside the method, fixed 'flase' typo
        if (gameFound == false) {
            System.out.println("Sorry, we don't have a title with that name.");
        }
    }

    private static void saveReceipts() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("soldGames.txt"));
            
            for (int i = 0; i < gameCounter; i++) {
                Game currentGame = inventory[i];

                // FIX: Check stock status, not title!
                if (currentGame.isInStock() == false) {
                    // Added formatting spaces so it looks nice
                    writer.println("Game: " + currentGame.getTitle() + " | Price: £" + currentGame.getPrice());
                }
            }
            writer.close();
            System.out.println("Receipts have been saved to soldGames.txt");

        } catch (IOException e) { // FIX: Changed Exception to specifically catch IOException
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}