package com.example.rucafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class OrderingDonutsController implements Initializable {

    @FXML
    private ImageView donutImage;

    @FXML
    private ListView<String> listDonutFlavors;

    @FXML
    private ComboBox<String> listDonutTypes;

    @FXML
    private ComboBox<String> listQuantities;

    @FXML
    private ListView<Donut> listSelectedDonutFlavors;

    @FXML
    private TextField subTotal;

    private MainController mainController;

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
        listDonutFlavors.getSelectionModel().selectFirst();
    }

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    @FXML
    void addToOrder(ActionEvent event) {
        if (listSelectedDonutFlavors.getItems().isEmpty()) {
            mainController.alertPopUp("Failed to add to order!", "No donut(s) selected!", "Error");
            return;
        }
        for (int i = 0; i < listSelectedDonutFlavors.getItems().size(); i++) {
            mainController.getCurrentOrder().add(listSelectedDonutFlavors.getItems().get(i));
        }
        saveYeastDonutQuantity = "1";
        saveCakeDonutQuantity = "1";
        saveDonutHoleQuantity = "1";
        listDonutTypes.getSelectionModel().selectFirst();
        listSelectedDonutFlavors.getItems().clear();
        yeastDonutFlavors = FXCollections.observableArrayList("Strawberry", "Vanilla", "Chocolate", "Glazed", "Mint");
        cakeDonutFlavors = FXCollections.observableArrayList("Frosted", "Blueberry", "Caramel", "Coffee", "Peanut");
        donutHoleFlavors = FXCollections.observableArrayList("Mango", "Cherry", "Crunchy", "Powdered", "Apple");
        listDonutFlavors.setItems(yeastDonutFlavors);
        listDonutFlavors.getSelectionModel().selectFirst();
        listQuantities.getSelectionModel().select(saveYeastDonutQuantity);
        subTotal.setText("$0.00");
        mainController.alertPopUp("Order added!", "Donut(s) successfully added to order! Thank you!", "Information");
    }

    @FXML
    void changeDisplayedItems(ActionEvent event) {
        if (listDonutTypes.getValue().equals("Yeast Donut")) {
            listDonutFlavors.setItems(yeastDonutFlavors);
            listQuantities.getSelectionModel().select(saveYeastDonutQuantity);
            donutImage.setImage(new Image("file:src/main/resources/images/yeast_donut.jpg"));
        } else if (listDonutTypes.getValue().equals("Cake Donut")) {
            listDonutFlavors.setItems(cakeDonutFlavors);
            donutImage.setImage(new Image("file:src/main/resources/images/cake_donut.jpg"));
            listQuantities.getSelectionModel().select(saveCakeDonutQuantity);
        } else if (listDonutTypes.getValue().equals("Donut Hole")) {
            listDonutFlavors.setItems(donutHoleFlavors);
            listQuantities.getSelectionModel().select(saveDonutHoleQuantity);
            donutImage.setImage(new Image("file:src/main/resources/images/donut_holes.jpg"));
        }
        listDonutFlavors.getSelectionModel().selectFirst();
    }

    @FXML
    void chooseFlavor(ActionEvent event) {
        if (listDonutFlavors.getSelectionModel().getSelectedIndex() == -1) {
            mainController.alertPopUp("No item selected!", "An item has not been selected!", "Error");
            return;
        }
        Donut addDonut = new Donut(Integer.parseInt(listQuantities.getValue()),
                listDonutFlavors.getSelectionModel().getSelectedItem(), listDonutTypes.getValue());
        price = price + addDonut.itemPrice();
        listSelectedDonutFlavors.getItems().add(addDonut);
        listDonutFlavors.getItems().remove(listDonutFlavors.getSelectionModel().getSelectedItem());
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText("$" + paddingZeroes.format(price));

    }

    @FXML
    void removeFlavor(ActionEvent event) {
        if (listSelectedDonutFlavors.getSelectionModel().getSelectedIndex() == -1) {
            mainController.alertPopUp("No item selected!", "An item has not been selected!", "Error");
            return;
        }
        Donut removeDonut = listSelectedDonutFlavors.getSelectionModel().getSelectedItem();
        price = price - removeDonut.itemPrice();
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText("$" + paddingZeroes.format(price));
        listSelectedDonutFlavors.getItems().remove(listSelectedDonutFlavors.getSelectionModel().getSelectedItem());
        if (removeDonut.getDonutType().equals("Yeast Donut")) {
            yeastDonutFlavors.add(removeDonut.getFlavor());
        } else if (removeDonut.getDonutType().equals("Cake Donut")) {
            cakeDonutFlavors.add(removeDonut.getFlavor());
        } else if (removeDonut.getDonutType().equals("Donut Hole")) {
            donutHoleFlavors.add(removeDonut.getFlavor());
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
