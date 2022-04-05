package com.example.rucafe;

public class YeastDonut extends MenuItem {

    private int quantity;
    private String flavor;
    private static final double YEAST_DONUT_PRICE = 1.59;
    private static final String DONUT_TYPE = "Yeast Donut";

    public YeastDonut(int quantity, String flavor) {
        this.quantity = quantity;
        this.flavor = flavor;
    }

    public String getFlavor() {
        return this.flavor;
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

    @Override
    public String toString() {
        return this.flavor + " (" + this.quantity + ")";
    }

}
