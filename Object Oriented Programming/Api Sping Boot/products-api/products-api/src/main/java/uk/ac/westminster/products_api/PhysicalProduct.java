package uk.ac.westminster.products_api;

import java.io.Serializable;

// A PhysicalProduct IS-A Product: it is a product that has
// to be picked, packed and shipped.
public class PhysicalProduct extends Product implements Discountable{
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {
    }
    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price); // must be the first statement
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }
    public double getWeightKg() { return weightKg; }
    public String getDimensions() { return dimensions; }
    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String getSummary() {
        return getName() + "Weight: " + getWeightKg() + "Kg";
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return this.discountedPrice;
    }
}