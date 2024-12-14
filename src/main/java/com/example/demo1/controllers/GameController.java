package com.example.demo1.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.example.demo1.models.Card;
import com.example.demo1.view.alert.AlertBoxInterface;
import com.example.demo1.view.alert.AlertBox;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

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
    private Card selectedCardModel = null; // Para almacenar el modelo de la carta seleccionada

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
        selectedCardModel = new Card(cardName);  // Al crearla, automáticamente se asigna el valor correcto

        // Imprimir la carta seleccionada en la terminal
        System.out.println(selectedCardModel.toString());

    }
    private int numCartaJugada = 0;
    private int nonValidCard = 0;


    // Método para mover la carta seleccionada al deck después de presionar el botón
    @FXML
    void onHandleShowButton(ActionEvent event) {
        // Si ya se ha jugado una carta, no permitir jugar más
        if (numCartaJugada > 0) {
            // Mostrar alerta indicando que solo se puede jugar una carta
            AlertBox alertBox = new AlertBox();
            alertBox.showAlert(
                    "Límite de Cartas",
                    "Solo puedes jugar una carta",
                    "Ya has jugado una carta, no puedes jugar más.",
                    Alert.AlertType.WARNING
            );
            return; // Salir del método sin realizar cambios
        }

        if (selectedCard != null && selectedCardModel != null) {
            // Calcula el nuevo total para verificar
            int newTotalValue = totalValue + selectedCardModel.getValue();

            if (newTotalValue > 50) {
                // Incrementar el contador de intentos fallidos
                nonValidCard++;

                // Mostrar alerta de que se excedió el límite y cuántos intentos restantes
                AlertBox alertBox = new AlertBox();
                alertBox.showAlert(
                        "Límite Excedido",
                        "No se puede agregar la carta",
                        "El total de las cartas no puede exceder 50. Intentos restantes: " + (4 - nonValidCard),
                        Alert.AlertType.WARNING
                );

                // Si se alcanzaron 4 intentos fallidos, mostrar mensaje de "fuera"
                if (nonValidCard >= 4) {
                    alertBox.showAlert(
                            "Juego Terminado",
                            "Has quedado fuera del juego",
                            "No tienes cartas válidas. ¡Intenta otra vez!",
                            Alert.AlertType.ERROR
                    );

                    // Aquí podrías agregar cualquier lógica adicional para finalizar el juego
                    // como deshabilitar botones o bloquear más intentos

                }

                return; // Salir del método sin realizar cambios
            }

            // Mover la carta seleccionada al deck
            deck.setImage(selectedCard.getImage());

            // Eliminar la imagen de la carta seleccionada del ImageView original
            selectedCard.setImage(null);

            // Actualizar el total del valor
            totalValue = newTotalValue;
            currentValue.setText(String.valueOf(totalValue));

            // Incrementar el contador de cartas jugadas
            numCartaJugada++;

            // Resetear la selección
            selectedCard = null;
            selectedCardModel = null;
        } else {
            // Si no hay carta seleccionada, mostramos una alerta
            AlertBox alertBox = new AlertBox();
            alertBox.showAlert(
                    "Sin Selección",
                    "No hay carta seleccionada",
                    "Seleccione una carta antes de intentar moverla.",
                    Alert.AlertType.INFORMATION
            );
        }
    }


    // Métodos para manejar botones adicionales
    @FXML
    void onHandleInstructionsButton(ActionEvent event) {
        // Agrega la lógica para el botón de instrucciones
    }

    private Set<Integer> drawnNumbers = new HashSet<>();

    @FXML
    void DrawToHand(MouseEvent event) {
        try {
            int randomNumber;

            // Generar un número aleatorio entre 1 y 54 que no se haya generado antes
            do {
                randomNumber = (int) (Math.random() * 54) + 1;
            } while (drawnNumbers.contains(randomNumber));  // Si el número ya fue generado, generar uno nuevo

            // Agregar el número generado al conjunto de números ya obtenidos
            drawnNumbers.add(randomNumber);

            // Crear la ruta de la imagen basada en el número generado
            URL resourceUrl = getClass().getResource("/com/example/images/" + randomNumber + ".png");

            if (resourceUrl == null) {
                throw new IllegalArgumentException("No se pudo encontrar la imagen: " + randomNumber + ".png");
            }

            String imagePath = resourceUrl.toExternalForm();
            Image newCardImage = new Image(imagePath);

            // Buscar el primer ImageView disponible (que tenga valor null)
            if (card1.getImage() == null) {
                card1.setImage(newCardImage);
            } else if (card2.getImage() == null) {
                card2.setImage(newCardImage);
            } else if (card3.getImage() == null) {
                card3.setImage(newCardImage);
            } else if (card4.getImage() == null) {
                card4.setImage(newCardImage);
            } else {
                // Si todos los ImageView están ocupados, mostrar una alerta
                AlertBox alertBox = new AlertBox();
                alertBox.showAlert(
                        "Mano Llena",
                        "No hay espacio disponible",
                        "Por favor juega una carta antes de robar otra.",
                        Alert.AlertType.WARNING
                );
            }

            // Restablecer el contador de cartas jugadas a 0 después de robar una carta
            numCartaJugada = 0;

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
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
