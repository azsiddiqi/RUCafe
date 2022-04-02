package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    Stage secondWindow = new Stage();
    Scene secondView;
    FXMLLoader fxmlLoader;
    private StoreOrders allStoreOrders = new StoreOrders();
    private Order currentOrder;

    @FXML
    void openOrderingBasketView(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(MainController.class.getResource("OrderingBasketView.fxml"));
        secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Ordering Basket");
        secondWindow.setScene(secondView);
        secondWindow.show();
        OrderingBasketController orderingBasketController = fxmlLoader.getController();
        orderingBasketController.setMainController(this);
    }

    @FXML
    void openOrderingCoffeeView(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(MainController.class.getResource("OrderingCoffeeView.fxml"));
        secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Ordering Coffee");
        secondWindow.setScene(secondView);
        secondWindow.show();
        OrderingCoffeeController orderingCoffeeController = fxmlLoader.getController();
        orderingCoffeeController.setMainController(this);
    }

    @FXML
    void openOrderingDonutsView(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(MainController.class.getResource("OrderingDonutsView.fxml"));
        secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Ordering Donuts");
        secondWindow.setScene(secondView);
        secondWindow.show();
    }

    @FXML
    void openStoreOrdersView(ActionEvent event) throws IOException{
        fxmlLoader = new FXMLLoader(MainController.class.getResource("StoreOrdersView.fxml"));
        secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Store Orders");
        secondWindow.setScene(secondView);
        secondWindow.show();
    }

    public void setCurrentOrder(Order createOrder) {
        this.currentOrder = createOrder;
    }

    public Order getCurrentOrder() {
        return this.currentOrder;
    }

    public StoreOrders getAllStoreOrders() {
        return this.allStoreOrders;
    }

}
