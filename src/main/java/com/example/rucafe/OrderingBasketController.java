package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class OrderingBasketController {

    @FXML
    private ListView<?> listOrderItems;

    @FXML
    private TextField orderTotal;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField subTotal;

    private MainController mainController;

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    void placeOrder(ActionEvent event) {
        mainController.getAllStoreOrders().add(mainController.getCurrentOrder());
        mainController.setCurrentOrder(null);
    }

    @FXML
    void removeSelectedItem(ActionEvent event) {

    }

}
