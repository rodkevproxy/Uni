public class Main {
    public static void main(String[] args) {
        // Activity 2
        int quantity = 3;
        double unitPrice = 24.99;
        String name = "wirelessMouse";
        boolean inStock = true;

        double total = calculateTotal(quantity, unitPrice);
        System.out.println(name + " x " + quantity + " = " + total);
        System.out.println("In stock: " + inStock);

        // Activity 3
        String[] names = {"Mouse", "Keyboard", "GraphicCard", "Monitor"};
        // FIXED: Removed the comma in 599.99
        double[] prices = {24.99, 150.99, 1299.99, 599.99};
        double catalogueTotal = 0;

        for (int i = 0; i < names.length; i++) {
            catalogueTotal += prices[i];
            if (prices[i] > 100) {
                System.out.println(names[i] + " - " + prices[i] + " - Premium");
            } else {
                // FIXED: Changed prices[i] to names[i] so it prints the name instead of the price twice
                System.out.println(names[i] + " - " + prices[i] + " - Standard");
            }
        }
        // FIXED: Added missing closing brace for the Activity 3 loop here

        // FIXED: Moved the total print statement outside the loop so it only prints once at the end
        System.out.println("Catalogue: " + catalogueTotal);

        // Activity 4
        Product[] catalogue = {
                new Product(1L, "Wireless Keyboard", 129.99),
                new Product(2L, "New monitor", 566.99),
                new Product(3L, "New Laptop", 2699.99),
                new Product(4L, "Mechanical Keyboard", 444.99)
        };

        // FIXED: Added the 'double' type declaration
        double catalogueTotalItems = 0;
        for (int i = 0; i < catalogue.length; i++) {
            System.out.println(catalogue[i].describe());
            // FIXED: Matched variable names. 'catalogueTotalObjects' did not exist.
            catalogueTotalItems = catalogueTotalItems + catalogue[i].getPrice();
        }
        System.out.println("Catalogue Total: " + catalogueTotalItems);

        Product dearest = findMostExpensive(catalogue);
        // FIXED: Added a space for formatting
        System.out.println("Most Expensive: " + dearest.getName());
    }

    // Methods

    // Activity 2
    public static double calculateTotal(int quantity, double unitPrice) {
        return quantity * unitPrice;
    }

    // Activity 5
    public static Product findMostExpensive(Product[] catalogue) {
        Product dearest = catalogue[0];
        // FIXED: Started loop at i = 1. Comparing catalogue[0] to catalogue[0] is redundant.
        for (int i = 1; i < catalogue.length; i++) {
            if (catalogue[i].getPrice() > dearest.getPrice()) {
                dearest = catalogue[i];
            }
        }
        return dearest;
    }
}