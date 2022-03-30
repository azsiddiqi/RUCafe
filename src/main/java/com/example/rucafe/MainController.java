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

    @FXML
    void openOrderingBasketView(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(MainController.class.getResource("OrderingBasketView.fxml"));
        secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Ordering Basket");
        secondWindow.setScene(secondView);
        secondWindow.show();
    }

    @FXML
    void openOrderingCoffeeView(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(MainController.class.getResource("OrderingCoffeeView.fxml"));
        secondView = new Scene(fxmlLoader.load(), 500, 554);
        secondWindow.setTitle("Ordering Coffee");
        secondWindow.setScene(secondView);
        secondWindow.show();
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

}
