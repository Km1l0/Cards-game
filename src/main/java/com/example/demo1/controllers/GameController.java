package com.example.demo1.controllers;

import javafx.event.ActionEvent; // Importación corregida
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameController {

    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    @FXML
    private Label currentValue;

    @FXML
    private ImageView deck;

    @FXML
    private ImageView hand;

    @FXML
    private Button instructionsButton;

    @FXML
    private Button showButton;

    private ImageView selectedCard = null; // Para almacenar la carta seleccionada

    // Método que maneja la selección de cartas
    @FXML
    void onCardClicked(MouseEvent event) {
        // El evento se origina en uno de los ImageView de las cartas
        ImageView clickedCard = (ImageView) event.getSource(); // Obtenemos el ImageView que fue clickeado

        // Si ya había una carta seleccionada, puedes quitarle el estilo (opcional)
        if (selectedCard != null) {
            selectedCard.setStyle(""); // Remueve el estilo de la carta previamente seleccionada
        }

        // Establecer la nueva carta seleccionada
        selectedCard = clickedCard;

        // Agregar un estilo visual para mostrar que la carta está seleccionada (puedes cambiar el borde, opacidad, etc.)
        selectedCard.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(255,0,0,0.96), 10, 0.5, 0, 0);"); // Ejemplo de cambio visual

        // Puedes agregar lógica aquí para usar la carta seleccionada, como sumarla al total de la mesa, etc.
        System.out.println("Carta seleccionada: " + selectedCard);
    }

    @FXML
    void onHandleInstructionsButton(ActionEvent event) {
        // Agrega la lógica para el botón de instrucciones
    }

    @FXML
    void onHandleShowButton(ActionEvent event) {
        // Agrega la lógica para el botón de mostrar
    }

    // Enlazamos los eventos de clic a cada carta en la vista (esto puede hacerse también en el FXML)
    @FXML
    public void initialize() {
        // Usamos los eventos de clic para cada carta
        card1.setOnMouseClicked(this::onCardClicked);
        card2.setOnMouseClicked(this::onCardClicked);
        card3.setOnMouseClicked(this::onCardClicked);
        card4.setOnMouseClicked(this::onCardClicked);
    }
}
