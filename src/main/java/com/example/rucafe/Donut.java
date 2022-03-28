package com.example.rucafe;

public class Donut extends MenuItem {

    private double donutPrice;
    private String donutType;
    private int quantity;

    private static final double YEAST_DONUT_PRICE = 1.59;
    private static final double CAKE_DONUT_PRICE = 1.79;
    private static final double DONUT_HOLE_PRICE = 0.39;

    public Donut(String donutType, int quantity) {
        this.donutType = donutType;
        this.quantity = quantity;
        if (donutType == "Yeast") {
            this.donutPrice = YEAST_DONUT_PRICE;
        } else if (donutType == "Cake") {
            this.donutPrice = CAKE_DONUT_PRICE;
        } else if (donutType == "Hole") {
            this.donutPrice = DONUT_HOLE_PRICE;
        }
    }

    @Override
    public double itemPrice() {
        return this.donutPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Donut) {
            Donut compared = (Donut) obj;
            if (this.donutPrice == compared.donutPrice && this.donutType.equals(compared.donutType)) {
                return true;
            }
        }
        return false;
    }

}
