package com.example.demo1.controllers;

import javafx.event.ActionEvent; // Importación corregida
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class GameController {

    @FXML
    private Button instructionsButton;

    @FXML
    private Button showButton;

    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    @FXML
    private ImageView deck;

    @FXML
    private ImageView hand;

    @FXML
    private Label currentValue;

    @FXML
    void onHandleInstructionsButton(ActionEvent event) {
        // Agrega la lógica para el botón de instrucciones
    }

    @FXML
    void onHandleShowButton(ActionEvent event) {
        // Agrega la lógica para el botón de mostrar
    }

}
