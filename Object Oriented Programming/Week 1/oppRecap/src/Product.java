public class Product {
    private Long id;
    private String name;
    private double price;

    //Constructors
    public Product(Long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    //Getters
    public Long getId() {return id;}
    public String getName() {return name;}
    public double getPrice() {return price;}

    // Activity 5: the object describes itself.
    public String describe() {
        if (price > 100) {
            return id + " - " + name + " - " + price + " - premium";
        } else {
            return id + " - " + name + " - " + price + " - standard";
        }
    }
}
