package com.example.rucafe;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class extends the menuItem class and is a blueprint for the coffee menu item. It includes data such as the size,
 * quantity, and add-ins for a coffee order and has functions that return the price of the order, an equals method, and a
 * tostring method. Along with this the class has the capacity to add and remove add-ins from the coffee object.
 * @author Azaan Siddiqi, Karan Patel
 */
public class Coffee extends MenuItem implements Customizable {

    private ArrayList<String> totalAddIns;
    private String sizeOfCoffee;
    private int quantity;

    private static final double SHORT_BLACK_COFFEE = 1.69;
    private static final double TALL_BLACK_COFFEE = 2.09;
    private static final double GRANDE_BLACK_COFFEE = 2.49;
    private static final double VENTI_BLACK_COFFEE = 2.89;
    private static final double ONE_ADD_IN_COST = 0.30;

    /**
     * Coffee menuItem constructor taking in specified parameters denoting add-ins, size, and quantity.
     * @param totalAddIns
     * @param sizeOfCoffee
     * @param quantity
     */
    public Coffee(ArrayList<String> totalAddIns, String sizeOfCoffee, int quantity) {
        this.totalAddIns = totalAddIns;
        this.sizeOfCoffee = sizeOfCoffee;
        this.quantity = quantity;
    }

    /**
     * Adds a specified add-in to the Coffee item totalAddIns arrayList.
     * @param obj
     * @return True if valid add-in False otherwise
     */
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

    /**
     * Removes a specified add-in from Coffee item totalAddIns arrayList.
     * @param obj
     * @return true if valid add-in false otherwise
     */
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

    /**
     Returns the price of a Coffee object, calculated based on size, number of add-ins, and quantity.
     @return double that is the price of the Coffee object.
     */
    @Override
    public double itemPrice() {
        double price;
        if (this.sizeOfCoffee.equals("Short")) {
            price = ((totalAddIns.size() * ONE_ADD_IN_COST) + SHORT_BLACK_COFFEE) * this.quantity;
        } else if (this.sizeOfCoffee.equals("Tall")) {
            price = ((totalAddIns.size() * ONE_ADD_IN_COST) + TALL_BLACK_COFFEE) * this.quantity;
        } else if (this.sizeOfCoffee.equals("Grande")) {
            price = ((totalAddIns.size() * ONE_ADD_IN_COST) + GRANDE_BLACK_COFFEE) * this.quantity;
        } else {
            price = ((totalAddIns.size() * ONE_ADD_IN_COST) + VENTI_BLACK_COFFEE) * this.quantity;
        }
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        return Double.parseDouble(paddingZeroes.format(price));
    }

    /**
     * Compares totalAddIns and sizeOfCoffee instance variables of two different coffee objects to see if coffee type is
     * the same.
     * @param obj
     * @return true if equals false otherwise
     */
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

    /**
     * Represents coffee item as a string.
     * @return String representing coffee item.
     */
    @Override
    public String toString() {
        return "Coffee: (" + this.quantity + ") " + this.sizeOfCoffee + " " + totalAddIns.toString();
    }
}
