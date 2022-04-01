package com.example.rucafe;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable {

    private ArrayList<String> totalAddIns;
    private String sizeOfCoffee;
    private int quantity;

    private static final double SHORT_BLACK_COFFEE = 1.69;
    private static final double TALL_BLACK_COFFEE = 2.09;
    private static final double GRANDE_BLACK_COFFEE = 2.49;
    private static final double VENTI_BLACK_COFFEE = 2.89;
    private static final double ONE_ADD_IN_COST = 0.30;

    public Coffee(ArrayList<String> totalAddIns, String sizeOfCoffee, int quantity) {
        this.totalAddIns = totalAddIns;
        this.sizeOfCoffee = sizeOfCoffee;
        this.quantity = quantity;
    }

    public boolean add(Object obj){
        if (obj instanceof String) {
            String addInName = (String) obj;
            if (addInName.equals("Cream") || addInName.equals("Syrup") || addInName.equals("Milk") ||
                    addInName.equals("Caramel") || addInName.equals("Whipped Cream")) {
                totalAddIns.add(addInName);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Object obj){
        if (obj instanceof String) {
            String addInName = (String) obj;
            if (addInName.equals("Cream") || addInName.equals("Syrup") || addInName.equals("Milk") ||
                    addInName.equals("Caramel") || addInName.equals("Whipped Cream")) {
                totalAddIns.remove(addInName);
                return true;
            }
        }
        return false;
    }

    public double itemPrice() {
        if (this.sizeOfCoffee.equals("Short")) {
            return ((totalAddIns.size() * ONE_ADD_IN_COST) + SHORT_BLACK_COFFEE) * this.quantity;
        } else if (this.sizeOfCoffee.equals("Tall")) {
            return ((totalAddIns.size() * ONE_ADD_IN_COST) + TALL_BLACK_COFFEE) * this.quantity;
        } else if (this.sizeOfCoffee.equals("Grande")) {
            return ((totalAddIns.size() * ONE_ADD_IN_COST) + GRANDE_BLACK_COFFEE) * this.quantity;
        } else {
            return ((totalAddIns.size() * ONE_ADD_IN_COST) + VENTI_BLACK_COFFEE) * this.quantity;
        }
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Coffee) {
            Coffee coffee = (Coffee) obj;
            if (coffee.totalAddIns.containsAll(this.totalAddIns) && this.totalAddIns.containsAll(coffee.totalAddIns) &&
                    (coffee.sizeOfCoffee.equals(this.sizeOfCoffee))){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Quantity: " + this.quantity + " Size: " + this.sizeOfCoffee + " Add-ins: " + this.totalAddIns.toString()
                + " Price: " + this.itemPrice();
    }
}
