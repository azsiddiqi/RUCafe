package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderingDonutsController implements Initializable {

    @FXML
    private ListView<String> listDonutFlavors;

    @FXML
    private ComboBox<String> listDonutTypes;

    @FXML
    private ComboBox<String> listQuantities;

    @FXML
    private ListView<String> listSelectedDonutFlavors;

    @FXML
    private TextField subTotal;

    private Order createOrder = new Order();

    @Override
    public void initialize(URL location, ResourceBundle resource){
        listDonutTypes.getItems().addAll("Yeast Donut", "Cake Donut", "Donut Hole");
        listQuantities.getItems().addAll("1", "2", "3", "4", "5");
        subTotal.setText("$0.00");
        listDonutFlavors.getItems().addAll("A", "B", "C", "D");
    }

    @FXML
    void addToOrder(ActionEvent event) {
        MenuItem createDonut;
        if (listDonutTypes.getPromptText().equals("Cake Donut")) {
            createDonut = new CakeDonut(Integer.parseInt(listQuantities.getPromptText()), "taw");
        } else if (listDonutTypes.getPromptText().equals("Donut Hole")) {
            createDonut = new DonutHole(Integer.parseInt(listQuantities.getPromptText()), "strawberry");
        } else if (listDonutTypes.getPromptText().equals("Yeast Donut")) {
            createDonut = new YeastDonut(Integer.parseInt(listQuantities.getPromptText()), "strawberry");
        }
    }

    @FXML
    void chooseFlavor(ActionEvent event) {
        listSelectedDonutFlavors.getItems().add(listDonutFlavors.getSelectionModel().getSelectedItem());
        listDonutFlavors.getItems().remove(listDonutFlavors.getSelectionModel().getSelectedItem());
    }

    @FXML
    void removeFlavor(ActionEvent event) {
        listDonutFlavors.getItems().add(listSelectedDonutFlavors.getSelectionModel().getSelectedItem());
        listSelectedDonutFlavors.getItems().remove(listSelectedDonutFlavors.getSelectionModel().getSelectedItem());

    }

}
