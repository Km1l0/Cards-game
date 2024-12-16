package com.example.demo1.models;

import com.example.demo1.controllers.GameController;
import javafx.scene.image.Image;
import javafx.scene.control.Alert;
import com.example.demo1.view.alert.AlertBox;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Machine implements Runnable {

    private GameController gameController; // Controlador de la vista
    private Set<Integer> drawnNumbers; // Para evitar cartas duplicadas
    private int turnNumber = 0;
    private List<Card> machineHand; // Mano de la máquina

    public Machine(GameController gameController) {
        this.gameController = gameController;
        this.drawnNumbers = new HashSet<>();
        this.machineHand = new ArrayList<>(); // Inicializamos la mano de la máquina

        // Iniciamos la mano de la máquina con una carta específica, por ejemplo, "2.png"
        Card initialCard = new Card("2.png"); // Nombre de la carta y su valor
        machineHand.add(initialCard); // Agregarla a la mano de la máquina
    }

    // Método para agregar una carta a la mano de la máquina
    public void addCardToMachineHand(Card card) {
        machineHand.add(card);
    }


    // Método para obtener una nueva carta para la máquina
    private void getNewCardForMachine() {
        try {
            int randomNumber;

            // Obtener un número aleatorio hasta que sea uno no repetido
            do {
                randomNumber = (int) (Math.random() * 54) + 1;
            } while (drawnNumbers.contains(randomNumber));

            drawnNumbers.add(randomNumber);

            // Determinar el valor de la carta basado en las listas de Card
            String cardName = randomNumber + ".png";
            int cardValue = getCardValue(cardName);

            // Crear la carta con su nombre y valor
            Card newCard = new Card(cardName); // Usamos el nombre real de la carta
            machineHand.add(newCard);
            // Agregar la carta a la mano de la máquina
            addCardToMachineHand(newCard);

            // Cargar la imagen correspondiente a la carta obtenida
            URL resourceUrl = getClass().getResource("/com/example/images/" + cardName);

            if (resourceUrl == null) {
                throw new IllegalArgumentException("No se pudo encontrar la imagen: " + cardName);
            }

            String imagePath = resourceUrl.toExternalForm();
            Image newCardImage = new Image(imagePath);

            // Se actualiza el ImageView del deck de la mesa con la carta de la máquina
            gameController.updateDeck(newCardImage); // Usa este método para actualizar el ImageView

            // Ahora, invocamos la función para que la máquina obtenga una nueva carta
            // Aquí la invocamos para obtener una carta adicional.

            // Aumenta el turno
            turnNumber++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Método para obtener el valor de la carta basándose en su nombre
    private int getCardValue(String cardName) {
        if (Card.VALUE_2_CARDS.contains(cardName)) {
            return 2;
        } else if (Card.VALUE_3_CARDS.contains(cardName)) {
            return 3;
        } else if (Card.VALUE_4_CARDS.contains(cardName)) {
            return 4;
        } else if (Card.VALUE_5_CARDS.contains(cardName)) {
            return 5;
        } else if (Card.VALUE_6_CARDS.contains(cardName)) {
            return 6;
        } else if (Card.VALUE_7_CARDS.contains(cardName)) {
            return 7;
        } else if (Card.VALUE_8_CARDS.contains(cardName)) {
            return 8;
        } else if (Card.VALUE_0_CARDS.contains(cardName)) {
            return 0;
        } else if (Card.VALUE_10_CARDS.contains(cardName)) {
            return 10;
        } else if (Card.VALUE_M10_CARDS.contains(cardName)) {
            return -10;
        }

        // Si no se encuentra el valor, retornar un valor predeterminado (podrías lanzar una excepción si lo prefieres)
        return 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Espera de 2 segundos entre cada turno de la máquina
                Thread.sleep(2000);

                // La máquina juega su carta
                onMachinePlayCard();
                getNewCardForMachine();  // Llamamos al método nuevamente para obtener una nueva carta.


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método que coloca la única carta de la mano de la máquina en el deck
    public void onMachinePlayCard() {
        if (machineHand.isEmpty()) {
            // En caso de que la máquina no tenga ninguna carta (aunque no debería ocurrir)
            AlertBox alertBox = new AlertBox();
            alertBox.showAlert(
                    "Sin Cartas",
                    "La máquina no tiene cartas",
                    "La máquina no tiene cartas para jugar.",
                    Alert.AlertType.WARNING
            );
            return;
        }

        // Obtener la única carta de la mano de la máquina
        Card machineCard = machineHand.get(0);

        // Colocar la carta en el deck de la mesa
        Image cardImage = new Image(getClass().getResource("/com/example/images/" + machineCard.getName()).toExternalForm());
        gameController.updateDeck(cardImage); // Coloca la carta en el ImageView deckmesa

        // Limpiar la mano de la máquina
        machineHand.clear();

        // Aumentar el turno
        turnNumber++;
        getNewCardForMachine();
        gameController.updateTotalValue(getCardValue(machineCard.getName()));
    }
}
