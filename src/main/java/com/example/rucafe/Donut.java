package com.example.rucafe;

public class Donut {
    private double donutPrice;
    private String donutType;

    public Donut(String donutType) {
        if (donutType == "Yeast") {
            this.donutPrice = 1.59;
        } else if (donutType == "Cake") {
            this.donutPrice = 1.79;
        } else if (donutType == "Hole") {
            this.donutPrice = 0.39;
        }
    }

    @Override
    public double itemPrice() {
        return this.donutPrice;
    }
}
