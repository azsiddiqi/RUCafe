package com.example.rucafe;

public class DonutHole extends MenuItem {

    private int quantity;
    private String flavor;
    private static final double DONUT_HOLE_PRICE = 0.39;
    private static final String DONUT_TYPE = "Donut Hole";


    public DonutHole(int quantity, String flavor) {
        this.quantity = quantity;
        this.flavor = flavor;
    }

    public double itemPrice() {
        return DONUT_HOLE_PRICE * this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DonutHole) {
            DonutHole compared = (DonutHole) obj;
            if (this.itemPrice() == compared.itemPrice() && this.flavor.equals(compared.flavor)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Quantity: " + this.quantity + " Donut Type: " + DONUT_TYPE + " Flavor: " + this.flavor + " Price: " +
                this.itemPrice();
    }
}
