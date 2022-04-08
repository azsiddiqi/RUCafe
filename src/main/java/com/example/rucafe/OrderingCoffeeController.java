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


/**
 This class allows the user to order coffee with specifications to the size, quantity, and add-ins of the coffee order.
 It has a method that adds the coffee order to the users order and makes it displayed in the "Your Orders" scene. It also
 has a method that continuously updates and displays the subtotal of the user's current coffee order when changes are
 made to it.
 @author Karan Patel, Azaan Siddiqi
 */
public class OrderingCoffeeController implements Initializable {

    @FXML
    private CheckBox caramel;

    @FXML
    private CheckBox cream;

    @FXML
    private ComboBox<String> listCoffeeSizes;

    @FXML
    private ComboBox<Integer> listQuantity;

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


    /**
     After the "Order Coffee" button is pressed in the main menu, this method initializes the data fields in the
     "Order Coffee" GUI. It sets the coffee size to "Short" and the quantity to 1, while not selecting any add-ins.
     Then it displays the subtotal for this default coffee.
     @param location
     @param resource
     */
    @Override
    public void initialize(URL location, ResourceBundle resource){
        totalAddIns = new ArrayList<>();
        listCoffeeSizes.getItems().addAll("Short", "Tall", "Grande", "Venti");
        listCoffeeSizes.getSelectionModel().selectFirst();
        listQuantity.getItems().addAll(1, 2, 3, 4, 5);
        listQuantity.getSelectionModel().selectFirst();
        subTotal.setText("$1.69");
    }


    /**
     Sets the reference of the MainController object to the mainController instance variable, which allows for sharing
     data between the MainController object and the OrderingCoffeeController object.
     @param controller the MainController object that is passed from the MainController class.
     */
    public void setMainController(MainController controller) {
        mainController = controller;
    }


    /**
     Adds the specified Coffee object to the MainController's currentOrder instance variable, while also displaying it
     in the "Your Order" GUI. Then, it resets the "Order Coffee" GUI data fields to their default.
     @param event An ActionEvent object that occurs when the "Add to Order" button is pressed in the "Ordering Coffee"
     GUI.
     */
    @FXML
    void addToOrder(ActionEvent event) {
        Coffee addCoffee = new Coffee(totalAddIns, listCoffeeSizes.getValue(), listQuantity.getValue());
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


    /**
     This method concurrently updates the subtotal of the coffee order as changes are made to it, and displays
     the resulting total in the subTotal TextField.
     @param event An ActionEvent object that occurs when an add-in is selected or deselected, when a size is selected,
     or when a quantity is selected.
     */
    @FXML
    void updateSubTotal(ActionEvent event) {
        Coffee currentCoffee = new Coffee(totalAddIns, listCoffeeSizes.getValue(), listQuantity.getValue());
        if (cream.isSelected() == true ) {
            currentCoffee.add("Cream");
        } else if (cream.isSelected() == false) {
            currentCoffee.remove("Cream");
        }
        if (syrup.isSelected() == true) {
            currentCoffee.add("Syrup");
        } else if (syrup.isSelected() == false){
            currentCoffee.remove("Syrup");
        }
        if (milk.isSelected() == true) {
            currentCoffee.add("Milk");
        } else if (milk.isSelected() == false){
            currentCoffee.remove("Milk");
        }
        if (caramel.isSelected() == true) {
            currentCoffee.add("Caramel");
        } else if (caramel.isSelected() == false){
            currentCoffee.remove("Caramel");
        }
        if (whippedCream.isSelected() == true) {
            currentCoffee.add("Whipped Cream");
        } else if (whippedCream.isSelected() == false){
            currentCoffee.remove("Whipped Cream");
        }
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        subTotal.setText("$" + paddingZeroes.format(currentCoffee.itemPrice()));
    }
}
