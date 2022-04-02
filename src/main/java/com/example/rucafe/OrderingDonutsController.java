package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    ObservableList<String> yeastDonutFlavors = FXCollections.observableArrayList("a", "b", "c", "d", "e");

    ObservableList<String> cakeDonutFlavors = FXCollections.observableArrayList("ef", "g", "h", "i", "e");

    ObservableList<String> donutHoleFlavors = FXCollections.observableArrayList("d", "d", "d", "d", "d");

    ObservableList<String> selectedYeastDonutFlavors = FXCollections.observableArrayList();

    ObservableList<String> selectedCakeDonutFlavors = FXCollections.observableArrayList();

    ObservableList<String> selectedDonutHoleFlavors = FXCollections.observableArrayList();

    String saveYeastDonutQuantity;

    String saveCakeDonutQuantity;

    String saveDonutHoleQuantity;

    @Override
    public void initialize(URL location, ResourceBundle resource){
        listDonutTypes.getItems().addAll("Yeast Donut", "Cake Donut", "Donut Hole");
        listDonutTypes.getSelectionModel().selectFirst();
        listQuantities.getItems().addAll("1", "2", "3", "4", "5");
        listQuantities.getSelectionModel().selectFirst();
        saveYeastDonutQuantity = "1";
        saveCakeDonutQuantity = "1";
        saveDonutHoleQuantity = "1";
        subTotal.setText("$0.00");
        listDonutFlavors.setItems(yeastDonutFlavors);
        listSelectedDonutFlavors.setItems(selectedYeastDonutFlavors);
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
    void changeDisplayedItems(ActionEvent event) {
        if (listDonutTypes.getValue().equals("Yeast Donut")) {
            listDonutFlavors.setItems(yeastDonutFlavors);
            listSelectedDonutFlavors.setItems(selectedYeastDonutFlavors);
            listQuantities.getSelectionModel().select(saveYeastDonutQuantity);
        } else if (listDonutTypes.getValue().equals("Cake Donut")) {
            listDonutFlavors.setItems(cakeDonutFlavors);
            listSelectedDonutFlavors.setItems(selectedCakeDonutFlavors);
            listQuantities.getSelectionModel().select(saveCakeDonutQuantity);
        } else if (listDonutTypes.getValue().equals("Donut Hole")) {
            listDonutFlavors.setItems(donutHoleFlavors);
            listSelectedDonutFlavors.setItems(selectedDonutHoleFlavors);
            listQuantities.getSelectionModel().select(saveDonutHoleQuantity);
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

    @FXML
    void saveDonutTypeQuantities(ActionEvent event) {
        if (listDonutTypes.getValue().equals("Yeast Donut")) {
            saveYeastDonutQuantity = listQuantities.getValue();
        } else if (listDonutTypes.getValue().equals("Cake Donut")) {
            saveCakeDonutQuantity = listQuantities.getValue();
        } else if (listDonutTypes.getValue().equals("Donut Hole")) {
            saveDonutHoleQuantity = listQuantities.getValue();
        }
    }

}
