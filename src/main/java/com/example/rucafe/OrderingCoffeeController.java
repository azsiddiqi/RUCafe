package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderingCoffeeController implements Initializable {

    @FXML
    private CheckBox caramel;

    @FXML
    private CheckBox cream;

    @FXML
    private ComboBox<String> listCoffeeSizes;

    @FXML
    private ComboBox<String> listQuantity;

    @FXML
    private CheckBox milk;

    @FXML
    private TextField subTotal;

    @FXML
    private CheckBox syrup;

    @FXML
    private CheckBox whippedCream;

    private MainController mainController;

    private Order createOrder = new Order();

    @Override
    public void initialize(URL location, ResourceBundle resource){
        listCoffeeSizes.getItems().addAll("Short", "Tall", "Grande", "Venti");
        listQuantity.getItems().addAll("1", "2", "3", "4", "5");
        subTotal.setText("$0.00");
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    void addToOrder(ActionEvent event) {
        ArrayList<String> totalAddIns = new ArrayList<>();
        if (cream.isSelected() == true) {
            totalAddIns.add("Cream");
        }
        if (syrup.isSelected() == true) {
            totalAddIns.add("Syrup");
        }
        if (milk.isSelected() == true) {
            totalAddIns.add("Milk");
        }
        if (caramel.isSelected() == true) {
            totalAddIns.add("Caramel");
        }
        if (whippedCream.isSelected() == true) {
            totalAddIns.add("Whipped Cream");
        }
        Coffee addCoffee = new Coffee(totalAddIns, listCoffeeSizes.getValue(), Integer.parseInt(listQuantity.getValue()));
        createOrder.add(addCoffee);
        mainController.setCurrentOrder(createOrder);
    }

}
