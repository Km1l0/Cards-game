package com.example.demo1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.example.demo1.models.Card;  // Importamos la clase Card

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
    private Label currentValue;  // Este es el label donde mostraremos el valor de la carta seleccionada

    @FXML
    private ImageView deck;

    @FXML
    private ImageView hand;

    @FXML
    private Button instructionsButton;

    @FXML
    private Button showButton;

    private ImageView selectedCard = null; // Para almacenar la carta seleccionada

    private int totalValue = 0;  // Variable para almacenar el total de los valores

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

        // Agregar un estilo visual para mostrar que la carta está seleccionada
        selectedCard.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(255,0,0,0.96), 10, 0.5, 0, 0);");

        // Obtener el nombre de la carta desde la imagen (por ejemplo, "2.png")
        String cardImage = clickedCard.getImage().getUrl();
        String cardName = cardImage.substring(cardImage.lastIndexOf("/") + 1);

        // Crear una instancia de la clase Card con la imagen y el valor
        Card card = new Card(cardName);  // Al crearla, automáticamente se asigna el valor correcto

        // Imprimir la carta seleccionada en la terminal
        System.out.println(card.toString());

        // Actualizar el valor en el Label (esto mostrará el valor de la carta en la interfaz)
    }

    // Método para manejar el botón de mostrar, sumando el valor de la carta seleccionada
    @FXML
    void onHandleShowButton(ActionEvent event) {
        if (selectedCard != null) {
            // Obtener el valor de la carta seleccionada
            String cardImage = selectedCard.getImage().getUrl();
            String cardName = cardImage.substring(cardImage.lastIndexOf("/") + 1);
            Card selectedCardObj = new Card(cardName);

            // Sumar el valor de la carta seleccionada al total
            totalValue += selectedCardObj.getValue();

            // Actualizar el valor total en el Label
            currentValue.setText(":" + totalValue);
        }
    }

    // Métodos para manejar botones (instrucciones, mostrar, etc. - de momento vacíos)
    @FXML
    void onHandleInstructionsButton(ActionEvent event) {
        // Lógica para el botón de instrucciones
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