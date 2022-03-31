package com.example.rucafe;

public class DonutHole extends MenuItem {

    int quantity;
    private String flavor;
    private static final double DONUT_HOLE_PRICE = 0.39;


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
}
