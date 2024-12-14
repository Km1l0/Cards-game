package com.example.demo1;

import com.example.demo1.view.WelcomeView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args); // Calls the launch method to start the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            WelcomeView.getInstance(); // Gets the instance of WelcomeView
        } catch (IOException e) {
            e.printStackTrace(); // Muestra el error en caso de fallo
        }
    }
}
