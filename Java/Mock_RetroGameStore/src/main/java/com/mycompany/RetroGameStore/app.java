import java.util.Scanner;

public class App {

    // --- GLOBAL VARIABLES ---
    // (Task 2: Your inventory array will go here!)

    static Game[] inventory = new Game [10];
    static int gameCounter = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Retro Game Store!");

        setupStore();
        runMenu(); 

    }

    private static void setupStore() { 

        Game game1 = new Game("Super Mario KArt 8 Deluxe", "Nintendo Switch", 80, true);
        inventory[gameCounter] = game1;
        gameCounter ++;

        Game game2 = new Game("Mortal Kombat ", "PS4", 89.99, true);
        inventory[gameCounter] = game2;
        gameCounter ++;

        Game gmae3 = new Game("Overcocked", "PC", 10.00, true);
        inventory[gameCounter] = gmae3;
        gameCounter ++;

        System.out.println("Shelves are stocked and ready! ");

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
    // --- YOUR METHODS WILL GO DOWN HERE ---
    
    // private static void runMenu() { ... }


    // private static void setupStore() { ... }


    // private static void buyGame() { ... }


    // private static void saveReceipts() { ... }


    // Check notes

    //Review the structures for methods and everything 
}