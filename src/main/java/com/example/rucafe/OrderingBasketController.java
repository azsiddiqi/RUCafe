package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

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


    public void initializeData(){
        double price = 0;
        currentOrder = mainController.getCurrentOrder();
        for (int i = 0; i < currentOrder.getTotalMenuItems().size(); i++) {
            price = price + currentOrder.getTotalMenuItems().get(i).itemPrice();
            listOrderItems.getItems().add(currentOrder.getTotalMenuItems().get(i).toString());
        }
        DecimalFormat PaddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText(PaddingZeroes.format(price));
        salesTax.setText(PaddingZeroes.format(price * 0.06625));
        orderTotal.setText(PaddingZeroes.format(price + price * 0.00625));
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    void placeOrder(ActionEvent event) {
        mainController.getAllStoreOrders().add(mainController.getCurrentOrder());
        mainController.setCurrentOrder(new Order());
        listOrderItems.getItems().clear();
        subTotal.setText("$0.00");
        salesTax.setText("$0.00");
        orderTotal.setText("$0.00");
    }

    @FXML
    void removeSelectedItem(ActionEvent event) {
        double price = 0;
        currentOrder.remove(currentOrder.getTotalMenuItems().get(listOrderItems.getSelectionModel().getSelectedIndex()));
        listOrderItems.getItems().remove(listOrderItems.getSelectionModel().getSelectedIndex());
        for (int i = 0; i < currentOrder.getTotalMenuItems().size(); i++) {
            price = price + currentOrder.getTotalMenuItems().get(i).itemPrice();
        }
        DecimalFormat PaddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText(PaddingZeroes.format(price));
        salesTax.setText(PaddingZeroes.format(price * 0.06625));
        orderTotal.setText(PaddingZeroes.format(price + price * 0.00625));

    }

}
