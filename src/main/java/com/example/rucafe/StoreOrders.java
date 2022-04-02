package com.example.rucafe;

import java.util.ArrayList;

public class StoreOrders implements Customizable {

    private ArrayList<Order> totalOrders;

    public StoreOrders() {
        this.totalOrders = new ArrayList<>();
    }

    public boolean add(Object obj){
        if (obj instanceof Order) {
            Order addOrder = (Order) obj;
            totalOrders.add(addOrder);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj){
        if (obj instanceof Order) {
            Order removeOrder = (Order) obj;
            totalOrders.remove(removeOrder);
            return true;
        }
        return false;
    }

}
