package com.example.rucafe;

import java.util.ArrayList;

public class Order implements Customizable {

    private ArrayList<MenuItem> totalMenuItems;

    public Order() {
        this.totalMenuItems = new ArrayList<>();
    }

    public boolean add(Object obj){
        if (obj instanceof MenuItem) {
            MenuItem additem = (MenuItem) obj;
            totalMenuItems.add(additem);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj){
        if (obj instanceof MenuItem) {
            MenuItem removeitem = (MenuItem) obj;
            totalMenuItems.remove(removeitem);
            return true;
        }
        return false;
    }
}
