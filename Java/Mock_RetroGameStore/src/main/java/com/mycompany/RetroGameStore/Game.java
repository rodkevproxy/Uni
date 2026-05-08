public class Game {
    //global variables will always go here 

    String title; 
    String console; 
    double price; 
    double inStock; 

    //constructor 
    public Game(String title, String console, double price, double inStock){
        this.title = title; 
        this.console = console; 
        this.price = price; 
        this.inStock = inStock; 

    }

    //getters 

    public String getTitle () {
        return this.title;
    }

    public String getConsole () {
        return this.console; 
    }

    public double getPrice () {
        return this.price; 
    }

    public double getInStock () { 
        return this.inStock; 
    }

    //setters

    public void setTitle (String title) {
        this.title = title; 
    }

    public void setConsole (String console) { 
        this.console = console; 
    }

    public void setPrice (double price) { 
        this.price = price; 
    }

    public void setInStock (double inStock) { 
        this.inStock = inStock;
    }

    public void printGame () {
        System.out.println("Title: " + this.title + "Console: " + this.console + "Price: " + this.price + "InStock: " + this.inStock);
    }



}
