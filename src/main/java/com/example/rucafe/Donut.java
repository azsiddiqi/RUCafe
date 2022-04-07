package com.example.rucafe;

import java.text.DecimalFormat;

public class Donut extends MenuItem {

    private int quantity;
    private String flavor;
    private String donutType;
    private static final double YEAST_DONUT_PRICE = 1.59;
    private static final double CAKE_DONUT_PRICE = 1.79;
    private static final double DONUT_HOLE_PRICE = 0.39;


    public Donut(int quantity, String flavor, String donutType) {
        this.quantity = quantity;
        this.flavor = flavor;
        this.donutType = donutType;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public String getDonutType() {
        return this.donutType;
    }

    @Override
    public double itemPrice() {
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        if (donutType.equals("Yeast Donut")) {
            return Double.parseDouble(paddingZeroes.format(YEAST_DONUT_PRICE * this.quantity));
        } else if (donutType.equals("Cake Donut")) {
            return Double.parseDouble(paddingZeroes.format(CAKE_DONUT_PRICE * this.quantity));
        } else {
            return Double.parseDouble(paddingZeroes.format(DONUT_HOLE_PRICE * this.quantity));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Donut) {
            Donut compared = (Donut) obj;
            if (this.itemPrice() == compared.itemPrice() && this.flavor.equals(compared.flavor) &&
                    this.donutType.equals(compared.donutType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.donutType + ": " + this.flavor + " (" + this.quantity + ")";
    }
}
