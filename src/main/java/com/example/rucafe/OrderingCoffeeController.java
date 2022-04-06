package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
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

    private ArrayList<String> totalAddIns;

    @Override
    public void initialize(URL location, ResourceBundle resource){
        totalAddIns = new ArrayList<>();
        listCoffeeSizes.getItems().addAll("Short", "Tall", "Grande", "Venti");
        listCoffeeSizes.getSelectionModel().selectFirst();
        listQuantity.getItems().addAll("1", "2", "3", "4", "5");
        listQuantity.getSelectionModel().selectFirst();
        subTotal.setText("$1.69");
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    void addToOrder(ActionEvent event) {
        Coffee addCoffee = new Coffee(totalAddIns, listCoffeeSizes.getValue(), Integer.parseInt(listQuantity.getValue()));
        mainController.getCurrentOrder().add(addCoffee);
        cream.setSelected(false);
        syrup.setSelected(false);
        milk.setSelected(false);
        caramel.setSelected(false);
        whippedCream.setSelected(false);
        totalAddIns = new ArrayList<>();
        listCoffeeSizes.getSelectionModel().selectFirst();
        listQuantity.getSelectionModel().selectFirst();
        subTotal.setText("$1.69");
    }

    @FXML
    void updateSubTotal(ActionEvent event) {
        if (cream.isSelected() == true && !totalAddIns.contains("Cream")) {
            totalAddIns.add("Cream");
        }
        else if (cream.isSelected() == false && totalAddIns.contains("Cream")) {
            totalAddIns.remove("Cream");
        }

        if (syrup.isSelected() == true && !totalAddIns.contains("Syrup")) {
            totalAddIns.add("Syrup");
        }
        else if (syrup.isSelected() == false && totalAddIns.contains("Syrup")){
            totalAddIns.remove("Syrup");
        }

        if (milk.isSelected() == true && !totalAddIns.contains("Milk")) {
            totalAddIns.add("Milk");
        }
        else if (milk.isSelected() == false && totalAddIns.contains("Milk")){
            totalAddIns.remove("Milk");
        }

        if (caramel.isSelected() == true && !totalAddIns.contains("Caramel")) {
            totalAddIns.add("Caramel");
        }
        else if (caramel.isSelected() == false && totalAddIns.contains("Caramel")){
            totalAddIns.remove("Caramel");
        }

        if (whippedCream.isSelected() == true && !totalAddIns.contains("Whipped Cream")) {
            totalAddIns.add("Whipped Cream");
        }
        else if (whippedCream.isSelected() == false && totalAddIns.contains("Whipped Cream")){
            totalAddIns.remove("Whipped Cream");
        }

        Coffee addCoffee = new Coffee(totalAddIns, listCoffeeSizes.getValue(), Integer.parseInt(listQuantity.getValue()));
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText("$" + paddingZeroes.format(addCoffee.itemPrice()));
    }
}
