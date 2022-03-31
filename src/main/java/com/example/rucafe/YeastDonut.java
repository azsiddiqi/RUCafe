package com.example.rucafe;

public class YeastDonut extends MenuItem {

    private int quantity;
    private String flavor;
    private static final double YEAST_DONUT_PRICE = 1.59;

    public YeastDonut(int quantity, String flavor) {
        this.quantity = quantity;
        this.flavor = flavor;
    }

    public double itemPrice() {
        return YEAST_DONUT_PRICE * this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof YeastDonut) {
            YeastDonut compared = (YeastDonut) obj;
            if (this.itemPrice() == compared.itemPrice() && this.flavor.equals(compared.flavor)) {
                return true;
            }
        }
        return false;
    }

}
