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
    private ComboBox<Integer> listOrderNumber;

    @FXML
    private TextField orderTotal;

    private MainController mainController;

    private Order currentOrder;


    public void initializeData() {
        orderTotal.setText("$0.00");
        for (int i = 0; i < mainController.getAllStoreOrders().getTotalOrders().size(); i++) {
            listOrderNumber.getItems().add(i + 1);
        }
        listOrderNumber.getSelectionModel().selectFirst();
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    void cancelOrder(ActionEvent event) {
        orderTotal.setText("$0.00");
        listOrderItems.getItems().clear();
        mainController.getAllStoreOrders().getTotalOrders().remove(listOrderNumber.getSelectionModel().getSelectedIndex());
        listOrderNumber.getItems().remove(listOrderNumber.getSelectionModel().getSelectedItem());
        listOrderNumber.getSelectionModel().selectFirst();
    }

    @FXML
    void displayNewOrder(ActionEvent event) {
        double price = 0;
        if (listOrderNumber.getSelectionModel().getSelectedIndex() == -1) {
            return;
        }
        currentOrder = mainController.getAllStoreOrders().getTotalOrders().get(listOrderNumber.getSelectionModel().getSelectedIndex());
        listOrderItems.getItems().clear();
        for (int i = 0; i < currentOrder.getTotalMenuItems().size(); i++) {
            price = price + currentOrder.getTotalMenuItems().get(i).itemPrice();
            listOrderItems.getItems().add(currentOrder.getTotalMenuItems().get(i).toString());
        }
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        orderTotal.setText("$" + paddingZeroes.format(price + price * 0.06625));
    }

    @FXML
    void exportOrders(ActionEvent event) {

    }

}
