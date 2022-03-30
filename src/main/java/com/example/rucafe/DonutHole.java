package com.example.rucafe;

public class DonutHole extends MenuItem {

    int quantity;
    private static final double DONUT_HOLE_PRICE = 0.39;

    public DonutHole(int quantity) {
        this.quantity = quantity;
    }

    public double itemPrice() {
        return DONUT_HOLE_PRICE * this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DonutHole) {
            DonutHole compared = (DonutHole) obj;
            if (this.itemPrice() == compared.itemPrice()) {
                return true;
            }
        }
        return false;
    }
}
