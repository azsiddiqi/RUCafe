package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class OrderingDonutsController {

    @FXML
    private Button chooseFlavor;

    @FXML
    private ListView<?> listDonutFlavors;

    @FXML
    private ComboBox<?> listDonutTypes;

    @FXML
    private ComboBox<?> listQuantities;

    @FXML
    private ListView<?> listSelectedDonutFlavors;

    @FXML
    private Button removeFlavor;

    @FXML
    private TextField subTotal;

    @FXML
    void addToOrder(ActionEvent event) {

    }

}
