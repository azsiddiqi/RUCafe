package com.example.rucafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;


/**
 This class maintains all the store's orders by either canceling any of the orders, switching the order that is being
 displayed, or exporting the orders to a text file.
 @author Karan Patel, Azaan Siddiqi
 */
public class StoreOrdersController {

    @FXML
    private ListView<String> listOrderItems;

    @FXML
    private ComboBox<Integer> listOrderNumber;

    @FXML
    private TextField orderTotal;

    private MainController mainController;

    private Order currentOrder;

    private static final double SALES_TAX = 0.06625;


    /**
     After the "Store Orders" button is pressed in the main menu, this method fills the listOrderNumber ComboBox object
     with the order numbers of every order in the MainController's allStoreOrders instance variable. It also sets the
     total to $0.00 and selects the first number to be displayed on the listOrderNumber ComboBox.
     */
    public void initializeData() {
        orderTotal.setText("$0.00");
        for (int i = 0; i < mainController.getAllStoreOrders().getTotalOrders().size(); i++) {
            listOrderNumber.getItems().add(mainController.getAllStoreOrders().getTotalOrders().get(i).getOrderNumber());
        }
        listOrderNumber.getSelectionModel().selectFirst();
    }


    /**
     Sets the reference of the MainController object to the mainController instance variable, which allows for sharing
     data between the MainController object and the StoreOrdersController object.
     @param controller the MainController object that is passed from the MainController class.
     */
    public void setMainController(MainController controller) {
        mainController = controller;
    }


    /**
     Cancels the current order that is being displayed on the "Store Orders" GUI by removing it from the allStoreOrders
     instance variable in the MainController object, and clearing any information related to that order from the GUI.
     @param event An ActionEvent object that occurs when the "Cancel Order" button is pressed on the "Store Orders" GUI.
     */
    @FXML
    void cancelOrder(ActionEvent event) {
        if (listOrderItems.getItems().isEmpty() || listOrderNumber.getItems().isEmpty()) {
            mainController.alertPopUp("Failed to cancel order!", "There are no orders to cancel!", "Error");
            return;
        }
        orderTotal.setText("$0.00");
        listOrderItems.getItems().clear();
        mainController.getAllStoreOrders().getTotalOrders().remove(listOrderNumber.getSelectionModel().getSelectedIndex());
        listOrderNumber.getItems().remove(listOrderNumber.getSelectionModel().getSelectedItem());
        listOrderNumber.getSelectionModel().selectFirst();
        mainController.alertPopUp("Successfully cancelled order!", "Order successfully canceled!", "Information");
    }


    /**
     When another number is selected in the listOrderNumber ComboBox object, this method lists the items related to that
     order number as well as the total price of that order.
     @param event An ActionEvent object that occurs when another number is selected in the listOrderNumber ComboBox
     object on the "Store Orders" GUI.
     */
    @FXML
    void displayNewOrder(ActionEvent event) {
        if (listOrderNumber.getSelectionModel().getSelectedIndex() == -1) {
            return;
        }
        currentOrder = mainController.getAllStoreOrders().getTotalOrders().get(listOrderNumber.getSelectionModel().getSelectedIndex());
        listOrderItems.getItems().clear();
        for (int i = 0; i < currentOrder.getTotalMenuItems().size(); i++) {
            listOrderItems.getItems().add(currentOrder.getTotalMenuItems().get(i).toString());
        }
        double calculatedSubTotal = currentOrder.calculateSubTotal();
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        orderTotal.setText("$" + paddingZeroes.format(calculatedSubTotal + calculatedSubTotal * SALES_TAX));
    }


    /**
     Exports all the information regarding each store order, such as its order number, items, and total price, to a
     text file.
     @param event An ActionEvent object that occurs when the "Export Orders" button is pressed on the "Store Orders"
     GUI.
     */
    @FXML
    void exportOrders (ActionEvent event) throws IOException {
        if (mainController.getAllStoreOrders().getTotalOrders().size() == 0) {
            mainController.alertPopUp("Failed to export orders!", "No orders to export!", "Error");
            return;
        }
        File file = new File("src/ExportedOrders.txt");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        DecimalFormat paddingZeroes = new DecimalFormat("#,##0.00");
        for (int i = 0; i < mainController.getAllStoreOrders().getTotalOrders().size(); i++) {
            printWriter.println("Order Number: " + mainController.getAllStoreOrders().getTotalOrders().get(i).getOrderNumber());
            double calculatedSubTotal = Double.parseDouble((paddingZeroes.format(mainController.getAllStoreOrders().getTotalOrders()
                    .get(i).calculateSubTotal())));
            printWriter.println("Total: $" + paddingZeroes.format((calculatedSubTotal + calculatedSubTotal * SALES_TAX)));
            for (int j = 0; j < mainController.getAllStoreOrders().getTotalOrders().get(i).getTotalMenuItems().size(); j++) {
                printWriter.println(" " + mainController.getAllStoreOrders().getTotalOrders().get(i).getTotalMenuItems().get(j).toString());
            }
            printWriter.println();
        }
        printWriter.close();
        fileWriter.close();
        mainController.alertPopUp("Successfully exported orders!", "All orders have been successfully exported!", "Information");

    }

}
