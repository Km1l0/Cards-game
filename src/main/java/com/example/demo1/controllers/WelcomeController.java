package com.example.demo1.controllers;

import javafx.event.ActionEvent; // Importación corregida
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class WelcomeController {

    @FXML
    private ImageView imageView;

    @FXML
    private Button instructionsButton;

    @FXML
    private ListView<?> listView;

    @FXML
    void onHandleInstructionsButton(ActionEvent event) {
        // Agrega la lógica para el botón de instrucciones
    }

    @FXML
    void onHandlePlayButton(ActionEvent event) {
        // Agrega la lógica para el botón de jugar
    }

}
