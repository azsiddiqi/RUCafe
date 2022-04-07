package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

/**
 This class takes the current order that is being processed, and it can either remove any items from the order or place
 the order all while displaying the current items and price of the order.
 @author Karan Patel, Azaan Siddiqi
 */
public class OrderingBasketController  {

    @FXML
    private ListView<String> listOrderItems;

    @FXML
    private TextField orderTotal;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField subTotal;

    private MainController mainController;

    private Order currentOrder;

    private static final double SALES_TAX = 0.06625;


    /**
     After the "Your Orders" button is pressed in the main menu, this method fills the opened window with information
     pertaining to the current order. It fills the listOrderItems ListView object with all the items in the current
     order, and it sets the sub total, sales tax, and order total.
     */
    public void initializeData(){
        double price = 0;
        currentOrder = mainController.getCurrentOrder();
        for (int i = 0; i < currentOrder.getTotalMenuItems().size(); i++) {
            price = price + currentOrder.getTotalMenuItems().get(i).itemPrice();
            listOrderItems.getItems().add(currentOrder.getTotalMenuItems().get(i).toString());
        }
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText("$" + paddingZeroes.format(price));
        salesTax.setText("$" + paddingZeroes.format(price * SALES_TAX));
        orderTotal.setText("$" + paddingZeroes.format(price + price * SALES_TAX));
        listOrderItems.getSelectionModel().selectFirst();
    }


    /**
     Sets the reference of the MainController object to the mainController instance variable, which allows for sharing
     data between the MainController object and the OrderingBasketController object.
     @param controller the MainController object that is passed from the MainController class.
     */
    public void setMainController(MainController controller) {
        mainController = controller;
    }


    /**
     Places an order by passing the current order to the allStoreOrders instance variable in the MainController object.
     Then, it resets the GUI and relevant data fields.
     @param event An ActionEvent object that occurs when the "Place Order" button is pressed on the "Your Order" GUI.
     */
    @FXML
    void placeOrder(ActionEvent event) {
        if (listOrderItems.getItems().isEmpty()) {
            mainController.alertPopUp("No items in the shopping cart!", "No items in the shopping cart!");
            return;
        }
        mainController.getAllStoreOrders().add(mainController.getCurrentOrder());
        mainController.setCurrentOrder(new Order());
        listOrderItems.getItems().clear();
        subTotal.setText("$0.00");
        salesTax.setText("$0.00");
        orderTotal.setText("$0.00");
    }


    /**
     Removes the selected MenuItem object from both the current order and from the ListView object. Then, it
     recalculates the price.
     @param event An ActionEvent object that occurs when the "Remove Selected Item" button is pressed on the
     "Your Order" GUI.
     */
    @FXML
    void removeSelectedItem(ActionEvent event) {
        if (listOrderItems.getSelectionModel().getSelectedIndex() == -1) {
            mainController.alertPopUp("No item selected!", "No item selected!");
            return;
        }
        double price = 0;
        currentOrder.remove(currentOrder.getTotalMenuItems().get(listOrderItems.getSelectionModel().getSelectedIndex()));
        listOrderItems.getItems().remove(listOrderItems.getSelectionModel().getSelectedIndex());
        for (int i = 0; i < currentOrder.getTotalMenuItems().size(); i++) {
            price = price + currentOrder.getTotalMenuItems().get(i).itemPrice();
        }
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText(paddingZeroes.format(price));
        salesTax.setText(paddingZeroes.format(price * SALES_TAX));
        orderTotal.setText(paddingZeroes.format(price + price * SALES_TAX));

    }

}
