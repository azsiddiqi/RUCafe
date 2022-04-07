package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainController {

    private Stage secondWindow = new Stage();
    private StoreOrders allStoreOrders = new StoreOrders();
    private Order currentOrder = new Order();

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

    public void alertPopUp(String titleOfWindow, String contentInsideWindow) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titleOfWindow);
        alert.setContentText(contentInsideWindow);
        Optional<ButtonType> finalResult = alert.showAndWait();
    }

    public Order getCurrentOrder() {
        return this.currentOrder;
    }

    public void setCurrentOrder(Order createOrder) {
        this.currentOrder = createOrder;
    }


    public StoreOrders getAllStoreOrders() {
        return this.allStoreOrders;
    }

}
