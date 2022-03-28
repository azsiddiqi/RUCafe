package com.example.rucafe;

public class Coffee extends MenuItem{
    private int numOfAddIns;
    private int  sizeOfCoffee;

    public Coffee(int numOfAddIns, int sizeOfCoffee) {
        this.numOfAddIns = numOfAddIns;
        this.sizeOfCoffee = sizeOfCoffee;
    }

    @Override
    public double itemPrice() {}
}
