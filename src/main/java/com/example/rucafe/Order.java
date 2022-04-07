package com.example.rucafe;

import java.util.ArrayList;


/**
 This class is used to create Order objects that each contain an arraylist of MenuItem objects. There is a constructor
 that initializes an Order object, and there is a getter method that returns the arraylist of MenuItem objects. You can
 add a MenuItem object to the arraylist and remove a MenuItem object from the arraylist.
 @author Karan Patel, Azaan Siddiqi
 */
public class Order implements Customizable {

    private ArrayList<MenuItem> totalMenuItems;


    /**
     Creates an order object that initializes the arraylist of MenuItem objects.
     */
    public Order() {
        this.totalMenuItems = new ArrayList<>();
    }


    /**
     Returns an arraylist containing all the MenuItem objects of a specific Order object.
     @return an arraylist containing all the MenuItem objects of a specific Order object
     */
    public ArrayList<MenuItem> getTotalMenuItems() {
        return this.totalMenuItems;
    }


    /**
     Adds a MenuItem object to the arraylist of MenuItem objects for a specific Order object.
     @param obj the MenuItem object to be added to the arraylist of MenuItem objects.
     @return true if the object in the parameter is a MenuItem object and it was successfully added to the arraylist,
     false otherwise.
     */
    public boolean add(Object obj){
        if (obj instanceof MenuItem) {
            MenuItem additem = (MenuItem) obj;
            totalMenuItems.add(additem);
            return true;
        }
        return false;
    }


    /**
     Removes a MenuItem object from the arraylist of MenuItem objects for a specific Order object.
     @param obj the MenuItem object to be removed from the arraylist of MenuItem objects.
     @return true if the object in the parameter is a MenuItem object and it was successfully removed from the
     arraylist, false otherwise.
     */
    public boolean remove(Object obj){
        if (obj instanceof MenuItem) {
            MenuItem removeitem = (MenuItem) obj;
            totalMenuItems.remove(removeitem);
            return true;
        }
        return false;
    }
}
