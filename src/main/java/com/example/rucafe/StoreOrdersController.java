package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrdersController {

    @FXML
    private ListView<?> listOrderItems;

    @FXML
    private ComboBox<?> listOrderNumber;

    @FXML
    private TextField orderTotal;

    @FXML
    void cancelOrder(ActionEvent event) {

    }

    @FXML
    void exportOrders(ActionEvent event) {

    }

}
