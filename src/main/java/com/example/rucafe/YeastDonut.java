package com.example.rucafe;

public class YeastDonut extends MenuItem {

    private int quantity;
    private static final double YEAST_DONUT_PRICE = 1.59;

    public YeastDonut(int quantity) {
        this.quantity = quantity;
    }

    public double itemPrice() {
        return YEAST_DONUT_PRICE * this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof YeastDonut) {
            YeastDonut compared = (YeastDonut) obj;
            if (this.itemPrice() == compared.itemPrice()) {
                return true;
            }
        }
        return false;
    }

}
