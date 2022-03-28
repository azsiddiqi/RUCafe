package com.example.rucafe;

public class Coffee extends MenuItem implements Customizable {

    private int numberOfAddIns;
    private String sizeOfCoffee;

    private static final double SHORT_BLACK_COFFEE = 1.69;
    private static final double TALL_BLACK_COFFEE = 2.09;
    private static final double GRANDE_BLACK_COFFEE = 2.49;
    private static final double VENTI_BLACK_COFFEE = 2.89;

    public Coffee(int numberOfAddIns, String sizeOfCoffee) {
        this.numberOfAddIns = numberOfAddIns;
        this.sizeOfCoffee = sizeOfCoffee;
    }

    public boolean add(Object obj){
        return false;
    }

    public boolean remove(Object obj){
        return false;
    }

    @Override
    public double itemPrice() {
        if (this.sizeOfCoffee.equals("Short")) {
            return (this.numberOfAddIns * 0.30) + SHORT_BLACK_COFFEE;
        } else if (this.sizeOfCoffee.equals("Tall")) {
            return (this.numberOfAddIns * 0.30) + TALL_BLACK_COFFEE;
        } else if (this.sizeOfCoffee.equals("Grande")) {
            return (this.numberOfAddIns * 0.30) + GRANDE_BLACK_COFFEE;
        } else {
            return (this.numberOfAddIns * 0.30) + VENTI_BLACK_COFFEE;
        }
    }
}
