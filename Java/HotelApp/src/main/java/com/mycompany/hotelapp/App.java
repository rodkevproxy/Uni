/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hotelapp;

import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;


/**
 * 4COSC005W - Software Development II Lab-based assessment - LibraryApp
 * (Template)
 *
 * Before you start, complete the following information: 
 * NAME: Kevin 
 * SURNAME: Rodas 
 * STUDENT ID: w2151939
 *
 * IMPORTANT: - Do not use external websites / AI tools during the assessment -
 * This project is intentionally incomplete; Follow your task sheet.
 *
 * Email, Phone number 
 * 
 * 
 */
public class App {

    // Global Scanner
    private static Scanner input = new Scanner(System.in);
    private static Booking[] bookings = new Booking [76];
    private static int bookingCounter = 0; 

    // here the main two global arrays and variables added were the counter used for one the tasks so it wil show up when the array is full, and also 
    // the array itself was added as part of the global additions requested during the exam. 
    //



    // Global 2D array for hotel rooms
    // 0 = Available, 1 = Occupied
    private static int[][] rooms;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            HOTEL ROOM MANAGER");
        System.out.println("==================================================");
        System.out.println(" Welcome to the Hotel Room Manager");
        System.out.println(" Manage room occupancy and guest records");
        System.out.println("==================================================");

        initialiseRooms();
        runMenu();
    }

    public static void initialiseRooms() {

        rooms = new int[3][]; // 3 floors

        rooms[0] = new int[10]; // Floor 1 has 10 rooms
        rooms[1] = new int[15]; // Floor 2 has 15 rooms
        rooms[2] = new int[12]; // Floor 3 has 12 rooms

        // All rooms are automatically initialised to 0 (available)
    }

    public static void runMenu() {

        int option;

        do {
            option = getOption();

            switch (option) {
                case 1:
                    checkInGuest();
                    break;

                case 2:
                    checkOutGuest();
                    break;

                case 3:
                    showRooms();
                    break;
                    // as part of the task 6 the was another two options added here, (with this the task 6 was done )

                case 0:
                    System.out.println("Thank you for using Hotel Room Manager.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 0);
    }

    public static int getOption() {

        //this menu also had a small adittion, two more options were added as part of the task 6


        System.out.println();
        System.out.println("+--------------------------------------+");
        System.out.println("|              MAIN MENU               |");
        System.out.println("+--------------------------------------+");
        System.out.println("| 1) Check in guest                    |");
        System.out.println("| 2) Check out guest                   |");
        System.out.println("| 3) Show room availability            |");
        System.out.println("| 4) Search client                     |");
        System.out.println("| 5) Save all bookings                 |");
        System.out.println("| 0) Quit                              |");
        System.out.println("+--------------------------------------+");
        System.out.print("Please select an option: ");

        return input.nextInt();
    }

    public static void checkInGuest() {

        // Both of the same verifications are valid wether they are check in or check out, both of the same functions need the same validations and methods. 
        //

        System.out.print("Enter floor number: ");
        int floorNumber = input.nextInt();

        while(floorNumber < 0 || floorNumber > rooms.length){
            System.out.println("Floor number should be from 1 to 3 inclusive! ");
            floorNumber = input.nextInt();
        }
        
        System.out.print("Enter room number: ");
        int roomNumber = input.nextInt();

        int floorIndex = floorNumber - 1;
        int roomIndex = roomNumber - 1;

        if (rooms[floorIndex][roomIndex] == 0) {

            System.out.println("Please enter your email");
            String userEmail = input.next();
            roomNumber = rooms[room];
            





            rooms[floorIndex][roomIndex] = 1;
            System.out.println("Check-in successful.");
        } else {
            System.out.println("Room already occupied.");
        }
    }

    public static void checkOutGuest() {

        System.out.print("Enter floor number: ");
        int floorNumber = input.nextInt();

        System.out.print("Enter room number: ");
        int roomNumber = input.nextInt();

        int floorIndex = floorNumber - 1;
        int roomIndex = roomNumber - 1;

        if (rooms[floorIndex][roomIndex] == 1) {
            rooms[floorIndex][roomIndex] = 0;
            System.out.println("Check-out successful.");
        } else {
            System.out.println("Room already available.");
        }
    }

    public static void showRooms() {

        System.out.println();
        System.out.println("==================================================");
        System.out.println("HOTEL ROOM STATUS");
        System.out.println("==================================================");
        System.out.println("LEGEND: [O] = Available, [X] = Occupied");
        System.out.println("--------------------------------------------------");

        for (int floor = 0; floor < rooms.length; floor++) {

            System.out.print("Floor " + (floor + 1) + " ");

            for (int room = 0; room < rooms[floor].length; room++) {

                if (rooms[floor][room] == 0) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[X]");
                }
            }

            System.out.println();
        }

        System.out.println("==================================================");
    }

}
