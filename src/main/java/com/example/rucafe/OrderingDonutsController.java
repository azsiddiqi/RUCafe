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


/**
 This class allows the user to order donuts with specifications to the flavor, quantity, and donut type of the donut
 order. It has two methods that continuously updates and displays the subtotal of the user's current donut order when
 changes are made to it. It also has a method that adds the donut order to the user's order. When switching between
 donut types, it changes the information that is being displayed. There is also an initialize method that initializes
 the data and a setter method that sets the mainController instance variable.
 @author Karan Patel, Azaan Siddiqi
 */
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

    private double calculatedSubTotal;

    private static final int NOT_FOUND = -1;


    /**
     After the "Order Donuts" button is pressed in the main menu, this method initializes the data fields in the
     "Ordering Donuts" GUI. It sets the donut type list to "Yeast Donut," the quantity to 1, and lists yeast donut
     flavors. It also sets the subtotal to $0.00.
     @param location Resolves relative paths for the root object, null otherwise if the location is unknown.
     @param resource Localizes the root object, null otherwise if the root object wasn't localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        calculatedSubTotal = 0;
        yeastDonutFlavors = FXCollections.observableArrayList("Strawberry", "Vanilla", "Chocolate", "Glazed",
                "Mint");
        cakeDonutFlavors = FXCollections.observableArrayList("Frosted", "Blueberry", "Sugary", "Peach",
                "Peanut");
        donutHoleFlavors = FXCollections.observableArrayList("Mango", "Cherry", "Crunchy", "Powdered", "Apple");
        listDonutTypes.getItems().addAll("Yeast Donut", "Cake Donut", "Donut Hole");
        listDonutTypes.getSelectionModel().selectFirst();
        listQuantities.getItems().addAll("1", "2", "3", "4", "5");
        listQuantities.getSelectionModel().selectFirst();
        subTotal.setText("$0.00");
        listDonutFlavors.setItems(yeastDonutFlavors);
    }


    /**
     Sets the reference of the MainController object to the mainController instance variable, which allows for sharing
     data between the MainController object and the OrderingDonutsController object.
     @param controller the MainController object that is passed from the MainController class.
     */
    public void setMainController(MainController controller) {
        mainController = controller;
    }


    /**
     Adds the specified Donut object(s) to the MainController's currentOrder instance variable, and then it resets the
     "Ordering Donuts" GUI data fields to their default.
     @param event An ActionEvent object that occurs when the "Add to Order" button is pressed in the "Ordering Donuts"
     GUI.
     */
    @FXML
    void addToOrder(ActionEvent event) {
        if (listSelectedDonutFlavors.getItems().isEmpty()) {
            mainController.popUpAlert("Failed to add to order!", "No donut(s) selected!",
                    "Error");
            return;
        }
        for (int i = 0; i < listSelectedDonutFlavors.getItems().size(); i++) {
            mainController.getCurrentOrder().add(listSelectedDonutFlavors.getItems().get(i));
        }
        listDonutTypes.getSelectionModel().selectFirst();
        listSelectedDonutFlavors.getItems().clear();
        yeastDonutFlavors = FXCollections.observableArrayList("Strawberry", "Vanilla", "Chocolate", "Glazed",
                "Mint");
        cakeDonutFlavors = FXCollections.observableArrayList("Frosted", "Blueberry", "Sugary", "Peach",
                "Peanut");
        donutHoleFlavors = FXCollections.observableArrayList("Mango", "Cherry", "Crunchy", "Powdered", "Apple");
        listDonutFlavors.setItems(yeastDonutFlavors);
        listQuantities.getSelectionModel().selectFirst();
        subTotal.setText("$0.00");
        calculatedSubTotal = 0;
        mainController.popUpAlert("Order added!",
                "Donut(s) successfully added to order! Thank you!", "Information");
    }


    /**
     When the displayed donut type is changed in the listDonutTypes ComboBox object, the listDonutFlavors ListView,
     located at the left of the screen, and the image are changed to reflect their respective donut type.
     @param event An ActionEvent object that occurs when the displayed string is changed in the listDonutTypes ComboBox
     object in the "Ordering Donuts" GUI.
     */
    @FXML
    void changeDisplayedItems(ActionEvent event) {
        if (listDonutTypes.getValue().equals("Yeast Donut")) {
            listDonutFlavors.setItems(yeastDonutFlavors);
            donutImage.setImage(new Image("file:src/main/resources/images/yeast_donut.jpg"));
            listQuantities.getSelectionModel().selectFirst();
        } else if (listDonutTypes.getValue().equals("Cake Donut")) {
            listDonutFlavors.setItems(cakeDonutFlavors);
            donutImage.setImage(new Image("file:src/main/resources/images/cake_donut.jpg"));
            listQuantities.getSelectionModel().selectFirst();
        } else if (listDonutTypes.getValue().equals("Donut Hole")) {
            listDonutFlavors.setItems(donutHoleFlavors);
            donutImage.setImage(new Image("file:src/main/resources/images/donut_holes.jpg"));
            listQuantities.getSelectionModel().selectFirst();
        }
        listDonutFlavors.getSelectionModel().selectFirst();
    }


    /**
     After the ">>" button is pressed, it creates a Donut object using the donut flavor, donut type, and quantity that
     was selected. It adds this Donut object to the listSelectedDonutFlavors ListView at the right of the screen, and
     removes the selected donut flavor from the listDonutFlavors ListView at the left of the screen. Then, it
     recalculates and displays the sub total.
     @param event An ActionEvent object that occurs when the ">>" button is pressed in the "Ordering Donuts"
     GUI.
     */
    @FXML
    void chooseFlavor(ActionEvent event) {
        if (listDonutFlavors.getSelectionModel().getSelectedIndex() == NOT_FOUND) {
            mainController.popUpAlert("No item selected!",
                    "An item has not been selected!", "Error");
            return;
        }
        Donut addDonut = new Donut(Integer.parseInt(listQuantities.getValue()),
                listDonutFlavors.getSelectionModel().getSelectedItem(), listDonutTypes.getValue());
        calculatedSubTotal = calculatedSubTotal + addDonut.itemPrice();
        listSelectedDonutFlavors.getItems().add(addDonut);
        listDonutFlavors.getItems().remove(listDonutFlavors.getSelectionModel().getSelectedItem());
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText("$" + paddingZeroes.format(calculatedSubTotal));
    }


    /**
     After the "<<" button is pressed, it removes the selected Donut object from the listSelectedDonutFlavors ListView
     at the right of the screen, and adds its donut flavor to the listDonutFlavors ListView at the left of the screen
     for the respective donut type. Then, it recalculates and displays the sub total.
     @param event An ActionEvent object that occurs when the "<<" button is pressed in the "Ordering Donuts"
     GUI.
     */
    @FXML
    void removeFlavor(ActionEvent event) {
        if (listSelectedDonutFlavors.getSelectionModel().getSelectedIndex() == NOT_FOUND) {
            mainController.popUpAlert("No item selected!",
                    "An item has not been selected!", "Error");
            return;
        }
        Donut removeDonut = listSelectedDonutFlavors.getSelectionModel().getSelectedItem();
        calculatedSubTotal = calculatedSubTotal - removeDonut.itemPrice();
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText("$" + paddingZeroes.format(calculatedSubTotal));
        listSelectedDonutFlavors.getItems().remove(removeDonut);
        if (removeDonut.getDonutType().equals("Yeast Donut")) {
            yeastDonutFlavors.add(removeDonut.getFlavor());
        } else if (removeDonut.getDonutType().equals("Cake Donut")) {
            cakeDonutFlavors.add(removeDonut.getFlavor());
        } else if (removeDonut.getDonutType().equals("Donut Hole")) {
            donutHoleFlavors.add(removeDonut.getFlavor());
        }
    }
}
