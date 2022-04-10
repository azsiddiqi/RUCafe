package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;


/**
 This class acts as the main menu of the GUI that stores and communicates information between the other controllers.
 From the MainController's GUI, you can open the "Ordering Donuts" GUI, the "Ordering Coffee" GUI, the "Your Order" GUI,
 and the "Store Orders" GUI. This class also contains getters for the current order being handled, and for all the store
 orders. There is a setter method for setting the current order being handled.
 @author Karan Patel, Azaan Siddiqi
 */
public class MainController {

    private Stage secondWindow = new Stage();
    private StoreOrders allStoreOrders = new StoreOrders();
    private Order currentOrder = new Order(1);


    /**
     Activates and displays the "Your Order" GUI, passes the MainController object to the OrderingBasketController
     object, and calls the initializeData() method inside the OrderingBasketController class.
     @param event An ActionEvent object that occurs when the "Your Order" button is pressed in the main menu GUI.
     @throws IOException this exception is thrown if there is an error with the input and output operations.
     */
    @FXML
    void openOrderingBasketView(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderingBasketView.fxml"));
        Scene secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Ordering Basket");
        secondWindow.setScene(secondView);
        secondWindow.show();
        OrderingBasketController orderingBasketController = fxmlLoader.getController();
        orderingBasketController.setMainController(this);
        orderingBasketController.initializeData();
    }


    /**
     Activates and displays the "Ordering Coffee" GUI and passes the MainController object to the
     OrderingCoffeeController object.
     @param event An ActionEvent object that occurs when the "Order Coffee" button is pressed in the main menu GUI.
     @throws IOException this exception is thrown if there is an error with the input and output operations.
     */
    @FXML
    void openOrderingCoffeeView(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderingCoffeeView.fxml"));
        Scene secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Ordering Coffee");
        secondWindow.setScene(secondView);
        secondWindow.show();
        OrderingCoffeeController orderingCoffeeController = fxmlLoader.getController();
        orderingCoffeeController.setMainController(this);
    }


    /**
     Activates and displays the "Ordering Donuts" GUI and passes the MainController object to the
     OrderingDonutsController object.
     @param event An ActionEvent object that occurs when the "Order Donuts" button is pressed in the main menu GUI.
     @throws IOException this exception is thrown if there is an error with the input and output operations.
     */
    @FXML
    void openOrderingDonutsView(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("OrderingDonutsView.fxml"));
        Scene secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Ordering Donuts");
        secondWindow.setScene(secondView);
        secondWindow.show();
        OrderingDonutsController orderingDonutsController = fxmlLoader.getController();
        orderingDonutsController.setMainController(this);
    }


    /**
     Activates and displays the "Store Orders" GUI, passes the MainController object to the StoreOrdersController
     object, and calls the initializeData() method inside the StoreOrdersController class.
     @param event An ActionEvent object that occurs when the "Store Orders" button is pressed in the main menu GUI.
     @throws IOException this exception is thrown if there is an error with the input and output operations.
     */
    @FXML
    void openStoreOrdersView(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("StoreOrdersView.fxml"));
        Scene secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Store Orders");
        secondWindow.setScene(secondView);
        secondWindow.show();
        StoreOrdersController storeOrdersController = fxmlLoader.getController();
        storeOrdersController.setMainController(this);
        storeOrdersController.initializeData();
    }


    /**
     Creates an Alert object that will contain information based on the 3 strings that are passed in the parameter.
     The Alert object will then be displayed to the user.
     @param headerMessage The information that the header of the Alert object will contain.
     @param contentInsideWindow The information that the content of the Alert object will contain.
     @param typeOfAlert The type of alert that the Alert object will be, such as an Error Alert or an Information Alert.
     */
    public void popUpAlert(String headerMessage, String contentInsideWindow, String typeOfAlert) {
        Alert alert = null;
        if (typeOfAlert.equals("Error")) {
            alert = new Alert(Alert.AlertType.ERROR);
        } else if (typeOfAlert.equals("Information")) {
            alert = new Alert(Alert.AlertType.INFORMATION);
        }
        alert.setTitle(typeOfAlert);
        alert.setHeaderText(headerMessage);
        alert.setContentText(contentInsideWindow);
        alert.showAndWait();
    }


    /**
     Returns the current order that is being handled.
     @return the currentOrder instance variable.
     */
    public Order getCurrentOrder() {
        return this.currentOrder;
    }


    /**
     Sets the current order that is being handled to the one that is passed as a parameter.
     @param createOrder the Order object that the currentOrder instance variable will be set equal to.
     */
    public void setCurrentOrder(Order createOrder) {
        this.currentOrder = createOrder;
    }


    /**
     Returns all the store orders that have been processed.
     @return the allStoreOrders instance variable.
     */
    public StoreOrders getAllStoreOrders() {
        return this.allStoreOrders;
    }

}
