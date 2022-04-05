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
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class OrderingDonutsController implements Initializable {

    @FXML
    private ListView<String> listDonutFlavors;

    @FXML
    private ComboBox<String> listDonutTypes;

    @FXML
    private ComboBox<String> listQuantities;

    @FXML
    private ListView<MenuItem> listSelectedDonutFlavors;

    @FXML
    private TextField subTotal;

    private Order createOrder = new Order();

    private ObservableList<String> yeastDonutFlavors;

    private ObservableList<String> cakeDonutFlavors;

    private ObservableList<String> donutHoleFlavors;

    private String saveYeastDonutQuantity;

    private String saveCakeDonutQuantity;

    private String saveDonutHoleQuantity;

    private double price;

    @Override
    public void initialize(URL location, ResourceBundle resource){
        price = 0;
        yeastDonutFlavors = FXCollections.observableArrayList("Strawberry", "Vanilla", "Chocolate", "Glazed", "Mint");
        cakeDonutFlavors = FXCollections.observableArrayList("Frosted", "Blueberry", "Caramel", "Coffee", "Peanut");
        donutHoleFlavors = FXCollections.observableArrayList("Mango", "Cherry", "Crunchy", "Powdered", "Apple");
        listDonutTypes.getItems().addAll("Yeast Donut", "Cake Donut", "Donut Hole");
        listDonutTypes.getSelectionModel().selectFirst();
        listQuantities.getItems().addAll("1", "2", "3", "4", "5");
        listQuantities.getSelectionModel().selectFirst();
        saveYeastDonutQuantity = "1";
        saveCakeDonutQuantity = "1";
        saveDonutHoleQuantity = "1";
        subTotal.setText("$0.00");
        listDonutFlavors.setItems(yeastDonutFlavors);
    }

    @FXML
    void addToOrder(ActionEvent event) {
        MenuItem createDonut;
        if (listDonutTypes.getValue().equals("Cake Donut")) {
            createDonut = new CakeDonut(Integer.parseInt(listQuantities.getValue()), "taw");
        } else if (listDonutTypes.getValue().equals("Donut Hole")) {
            createDonut = new DonutHole(Integer.parseInt(listQuantities.getValue()), "strawberry");
        } else if (listDonutTypes.getValue().equals("Yeast Donut")) {
            createDonut = new YeastDonut(Integer.parseInt(listQuantities.getValue()), "strawberry");
        }
    }

    @FXML
    void changeDisplayedItems(ActionEvent event) {
        if (listDonutTypes.getValue().equals("Yeast Donut")) {
            listDonutFlavors.setItems(yeastDonutFlavors);
            listQuantities.getSelectionModel().select(saveYeastDonutQuantity);
        } else if (listDonutTypes.getValue().equals("Cake Donut")) {
            listDonutFlavors.setItems(cakeDonutFlavors);
            listQuantities.getSelectionModel().select(saveCakeDonutQuantity);
        } else if (listDonutTypes.getValue().equals("Donut Hole")) {
            listDonutFlavors.setItems(donutHoleFlavors);
            listQuantities.getSelectionModel().select(saveDonutHoleQuantity);
        }
    }

    @FXML
    void chooseFlavor(ActionEvent event) {
        MenuItem addDonut = null;
        if (listDonutTypes.getValue().equals("Yeast Donut")) {
            addDonut = new YeastDonut(Integer.parseInt(listQuantities.getValue()),listDonutFlavors.getSelectionModel().getSelectedItem());
        } else if (listDonutTypes.getValue().equals("Cake Donut")) {
            addDonut = new CakeDonut(Integer.parseInt(listQuantities.getValue()),listDonutFlavors.getSelectionModel().getSelectedItem());
        } else if (listDonutTypes.getValue().equals("Donut Hole")) {
            addDonut = new DonutHole(Integer.parseInt(listQuantities.getValue()),listDonutFlavors.getSelectionModel().getSelectedItem());
        }
        price = price + addDonut.itemPrice();
        listSelectedDonutFlavors.getItems().add(addDonut);
        listDonutFlavors.getItems().remove(listDonutFlavors.getSelectionModel().getSelectedItem());
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText("$" + paddingZeroes.format(price));

    }

    @FXML
    void removeFlavor(ActionEvent event) {
        String donutInformation = listSelectedDonutFlavors.getSelectionModel().getSelectedItem().toString();
        String[] splitInformation = donutInformation.split(" ");
        MenuItem removeDonut = listSelectedDonutFlavors.getSelectionModel().getSelectedItem();
        price = price - removeDonut.itemPrice();
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText("$" + paddingZeroes.format(price));
        listSelectedDonutFlavors.getItems().remove(listSelectedDonutFlavors.getSelectionModel().getSelectedItem());
        if (splitInformation[0].equals("Strawberry") || splitInformation[0].equals("Vanilla") ||
                splitInformation[0].equals("Chocolate") || splitInformation[0].equals("Glazed") ||
                splitInformation[0].equals("Mint")) {
            yeastDonutFlavors.add(splitInformation[0]);
        } else if (splitInformation[0].equals("Frosted") || splitInformation[0].equals("Caramel") ||
                splitInformation[0].equals("Blueberry") || splitInformation[0].equals("Coffee") ||
                splitInformation[0].equals("Peanut")) {
            cakeDonutFlavors.add(splitInformation[0]);
        } else if (splitInformation[0].equals("Mango") || splitInformation[0].equals("Cherry") ||
                splitInformation[0].equals("Crunchy") || splitInformation[0].equals("Powdered") ||
                splitInformation[0].equals("Apple")) {
            donutHoleFlavors.add(splitInformation[0]);
        }

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
