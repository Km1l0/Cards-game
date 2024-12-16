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
import com.example.demo1.view.alert.AlertBox;
import com.example.demo1.models.*;

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
    private Label currentValue;

    @FXML
    private Label turn;

    @FXML
    private ImageView deck;

    @FXML
    private Button instructionsButton;

    @FXML
    private Button showButton;

    private Machine machine;  // Instancia de Machine

    public GameController() {
        // Inicializar la máquina (asegúrate de pasar la referencia correcta del GameController)
        this.machine = new Machine(this);
    }

    // Método para obtener la máquina
    public Machine getMachine() {
        return machine;
    }

    // Este método debe ser llamado para hacer que la máquina juegue su carta
    public void onMachinePlayCard() {
        machine.onMachinePlayCard();
    }

    public void updateDeck(Image newCardImage) {
        deck.setImage(newCardImage);
    }

    private ImageView selectedCard = null;
    private Card selectedCardModel = null;
    public int turnNumber = 0;
    private int totalValue = 1;

    // Contenedor para las cartas de la mano de la máquina
    private Set<Card> machineHand = new HashSet<>();

    private int numCartaJugada = 0;
    private int nonValidCard = 0;

    // Método que maneja la selección de cartas
    @FXML
    void onCardClicked(MouseEvent event) {
        ImageView clickedCard = (ImageView) event.getSource();

        if (selectedCard != null) {
            selectedCard.setStyle("");
        }

        selectedCard = clickedCard;

        selectedCard.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(255,0,0,0.96), 10, 0.5, 0, 0);");

        String cardImage = clickedCard.getImage().getUrl();
        String cardName = cardImage.substring(cardImage.lastIndexOf("/") + 1);

        selectedCardModel = new Card(cardName);
        System.out.println(selectedCardModel.toString());
    }



    // Método para mover la carta seleccionada al deck después de presionar el botón
    @FXML
    void onHandleShowButton(ActionEvent event) {
        if (numCartaJugada > 0) {
            AlertBox alertBox = new AlertBox();
            alertBox.showAlert(
                    "Límite de Cartas",
                    "Solo puedes jugar una carta",
                    "Ya has jugado una carta, no puedes jugar más.",
                    Alert.AlertType.WARNING
            );
            return;
        }

        if (selectedCard != null && selectedCardModel != null) {
            int newTotalValue = totalValue + selectedCardModel.getValue();

            if (newTotalValue > 50) {
                nonValidCard++;
                AlertBox alertBox = new AlertBox();
                alertBox.showAlert(
                        "Límite Excedido",
                        "No se puede agregar la carta",
                        "El total de las cartas no puede exceder 50. Intentos restantes: " + (4 - nonValidCard),
                        Alert.AlertType.WARNING
                );

                if (nonValidCard >= 4) {
                    alertBox.showAlert(
                            "Juego Terminado",
                            "Has quedado fuera del juego",
                            "No tienes cartas válidas. ¡Intenta otra vez!",
                            Alert.AlertType.ERROR
                    );
                }

                return;
            }

            deck.setImage(selectedCard.getImage());
            selectedCard.setImage(null);

            totalValue = newTotalValue;
            currentValue.setText(String.valueOf(totalValue));

            numCartaJugada++;

            selectedCard = null;
            selectedCardModel = null;
        } else {
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

            do {
                randomNumber = (int) (Math.random() * 54) + 1;
            } while (drawnNumbers.contains(randomNumber));

            drawnNumbers.add(randomNumber);

            URL resourceUrl = getClass().getResource("/com/example/images/" + randomNumber + ".png");

            if (resourceUrl == null) {
                throw new IllegalArgumentException("No se pudo encontrar la imagen: " + randomNumber + ".png");
            }

            String imagePath = resourceUrl.toExternalForm();
            Image newCardImage = new Image(imagePath);

            // Asignar la carta a las posiciones disponibles
            if (card1.getImage() == null) {
                card1.setImage(newCardImage);
            } else if (card2.getImage() == null) {
                card2.setImage(newCardImage);
            } else if (card3.getImage() == null) {
                card3.setImage(newCardImage);
            } else if (card4.getImage() == null) {
                card4.setImage(newCardImage);
            } else {
                AlertBox alertBox = new AlertBox();
                alertBox.showAlert(
                        "Mano Llena",
                        "No hay espacio disponible",
                        "Por favor juega una carta antes de robar otra.",
                        Alert.AlertType.WARNING
                );
                return;
            }

            numCartaJugada = 0;
            turnNumber++;

            onMachinePlayCard();  // Esto ejecutará la acción de la máquina


            // Actualiza el label de turno
            turn.setText("Turno: " + turnNumber);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }




    private String getCardSuit(String imageName)  {
        if (imageName.equals("1.png") || imageName.equals("2.png") || imageName.equals("3.png") || imageName.equals("4.png") || imageName.equals("5.png") || imageName.equals("6.png") ||
                imageName.equals("7.png") || imageName.equals("8.png") || imageName.equals("9.png") || imageName.equals("10.png") || imageName.equals("11.png") || imageName.equals("12.png") || imageName.equals("13.png")) {
            return "Pica";
        } else if (imageName.equals("15.png") || imageName.equals("16.png") || imageName.equals("17.png") || imageName.equals("18.png") || imageName.equals("19.png") ||
                imageName.equals("20.png") || imageName.equals("21.png") || imageName.equals("22.png") || imageName.equals("23.png") || imageName.equals("24.png") ||
                imageName.equals("25.png") || imageName.equals("26.png")) {
            return "Corazón";
        } else if (imageName.equals("28.png") || imageName.equals("29.png") || imageName.equals("30.png") || imageName.equals("31.png") || imageName.equals("32.png") ||
                imageName.equals("33.png") || imageName.equals("34.png") || imageName.equals("35.png") || imageName.equals("36.png") || imageName.equals("37.png") ||
                imageName.equals("38.png") || imageName.equals("39.png")) {
            return "Diamante";
        } else if (imageName.equals("41.png") || imageName.equals("42.png") || imageName.equals("43.png") || imageName.equals("44.png") || imageName.equals("45.png") ||
                imageName.equals("46.png") || imageName.equals("47.png") || imageName.equals("48.png") || imageName.equals("49.png") || imageName.equals("50.png") ||
                imageName.equals("51.png") || imageName.equals("52.png")) {
            return "Trebol";
        }
        return "Desconocido"; // En caso de que no se encuentre el palo
    }

    private int getCardValue(String imageName) {
        if (imageName.equals("11.png") || imageName.equals("12.png") || imageName.equals("13.png")) {
            return -10;
        } else if (imageName.equals("2.png") || imageName.equals("15.png") || imageName.equals("28.png") || imageName.equals("41.png")) {
            return 2;
        } else if (imageName.equals("3.png") || imageName.equals("16.png") || imageName.equals("29.png") || imageName.equals("42.png")) {
            return 3;
        } else if (imageName.equals("4.png") || imageName.equals("17.png") || imageName.equals("30.png") || imageName.equals("43.png")) {
            return 4;
        } else if (imageName.equals("5.png") || imageName.equals("18.png") || imageName.equals("31.png") || imageName.equals("44.png")) {
            return 5;
        } else if (imageName.equals("6.png") || imageName.equals("19.png") || imageName.equals("32.png") || imageName.equals("45.png")) {
            return 6;
        } else if (imageName.equals("7.png") || imageName.equals("20.png") || imageName.equals("33.png") || imageName.equals("46.png")) {
            return 7;
        } else if (imageName.equals("8.png") || imageName.equals("21.png") || imageName.equals("34.png") || imageName.equals("47.png")) {
            return 8;
        } else if (imageName.equals("9.png") || imageName.equals("22.png") || imageName.equals("35.png") || imageName.equals("48.png")) {
            return 0;
        } else if (imageName.equals("10.png") || imageName.equals("23.png") || imageName.equals("36.png") || imageName.equals("49.png")) {
            return 10;
        }
        return 0; // Si no se encuentra, retornamos valor por defecto
    }
}
