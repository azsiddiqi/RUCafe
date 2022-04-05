package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class StoreOrdersController {

    @FXML
    private ListView<String> listOrderItems;

    @FXML
    private ComboBox<String> listOrderNumber;

    @FXML
    private TextField orderTotal;

    private MainController mainController;

    private Order currentOrder;


    public void initializeData() {
        for (int i = 0; i < mainController.getAllStoreOrders().getTotalOrders().size(); i++) {
            listOrderNumber.getItems().add(String.valueOf(i + 1));
        }
        listOrderNumber.getSelectionModel().selectFirst();
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    void cancelOrder(ActionEvent event) {

    }

    @FXML
    void displayNewOrder(ActionEvent event) {
        double price = 0;
        currentOrder = mainController.getAllStoreOrders().getTotalOrders().get(Integer.parseInt(listOrderNumber.getValue()) - 1);
        listOrderItems.getItems().clear();
        for (int i = 0; i < currentOrder.getTotalMenuItems().size(); i++) {
            price = price + currentOrder.getTotalMenuItems().get(i).itemPrice();
            listOrderItems.getItems().add(currentOrder.getTotalMenuItems().get(i).toString());
        }
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        orderTotal.setText(paddingZeroes.format(price + price * 0.00625));
    }

    @FXML
    void exportOrders(ActionEvent event) {

    }

}
