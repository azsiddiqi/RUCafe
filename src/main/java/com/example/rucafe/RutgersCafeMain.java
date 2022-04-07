package com.example.rucafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 This class activates the Rutgers Cafe GUI by using the launch() command in the main method, and by creating an
 FXMLLoader object and a Scene object in the start method that is displayed to the user through a Stage object.
 @author Karan Patel, Azaan Siddiqi
 */
public class RutgersCafeMain extends Application {


    /**
     Creates an FXMLLoader object and a Scene object which is then used by the Stage object in order to display the
     Rutgers Cafe GUI.
     @param stage the Stage object that displays the Scene object that is created in the method.
     @throws IOException this exception is thrown if there is an error with the input and output operations.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RutgersCafeMain.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 554);
        stage.setTitle("Rutgers Cafe");
        stage.setScene(scene);
        stage.show();
    }


    /**
     Calls the launch() method which begins the Rutgers Cafe GUI application.
     @param args array to store the java command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}