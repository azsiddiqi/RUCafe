package com.example.rucafe;

import java.text.DecimalFormat;

public class CakeDonut extends MenuItem {

    private int quantity;
    private String flavor;
    private static final double CAKE_DONUT_PRICE = 1.79;
    private static final String DONUT_TYPE = "Cake Donut";


    public CakeDonut(int quantity, String flavor) {
        this.quantity = quantity;
        this.flavor = flavor;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public double itemPrice() {
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        return Double.parseDouble(paddingZeroes.format(CAKE_DONUT_PRICE * this.quantity));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CakeDonut) {
            CakeDonut compared = (CakeDonut) obj;
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
