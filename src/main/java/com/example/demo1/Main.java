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
    public void start(Stage primaryStage) throws IOException {
        // No es necesario capturar IOException aquí ya que no se lanza
        WelcomeView.getInstance(); // Obtiene la instancia de WelcomeView
    }
}
