class Main {
    public static void main(String[] args) {
        int quantity = 3;
        double unitPrice = 24.99;
        String name = "wirelessMouse";
        boolean inStock = true;

        double total = calculateTotal(quantity, unitPrice);
        System.out.println(name + " x " + quantity + " = " + total);
        System.out.println("In stock: " + inStock);

        // Activity 3
        String[] names = {"Mouse", "Keyboard", "GraphicCard", "Monitor"};
        double[] prices = {24.99, 150.99, 1299.99, 599,.99};
        double catalogueTotal = 0;
        for (int i = 0; i < names.length; i ++){
            catalogueTotal += prices[i];
            if (prices[i] > 100){
                System.out.println(names[i] + " - " + prices[i] + " - Premium");
            }else{
                System.out.println(prices[i] + " - " + prices[i] + " - Standard");
            }
            System.out.println("Catalogue: " + catalogueTotal);



        }



    }
    //Methods
    //Activity 2
    public static double calculateTotal(int quantity, double unitPrice) {
        return quantity * unitPrice;
        //Incompatible types
    }


}
