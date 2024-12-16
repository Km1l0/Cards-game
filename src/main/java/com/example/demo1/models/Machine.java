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
                randomNumber = (int) (Math.random() * 52) ;
            } while (drawnNumbers.contains(randomNumber));

            drawnNumbers.add(randomNumber);

            // Determinar el valor de la carta basado en las listas de Card
            String cardName = randomNumber + ".png";
            int cardValue = getCardValue(cardName);
            System.out.println("CONTENIDO JUSTO DESPUES DE INT CARD VALUE, ESTA ES LA CARTA RANDOM QUE DA: " + randomNumber +".png" );
            System.out.println("CONTENIDO JUSTO DESPUES DE INT CARD VALUE, ESTE ES EL VALOR DE LA CARTA DE ARRIBA: " + cardValue);

            // Crear la carta con su nombre y valor
            Card newCard = new Card(cardName); // Usamos el nombre real de la carta
            machineHand.add(newCard);
            System.out.println("ESTA ES LA CARTA QUE SE INGRESA CON EL CARDNAME ANTERIORMENTE OBTENIDO: " + newCard);
            // Agregar la carta a la mano de la máquina

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
            onMachinePlayCard();
            machineHand.clear();
            turnNumber++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Método para obtener el valor de la carta basándose en su nombre
    int getCardValue(String cardName) {
        if (cardName.equals("11.png") || cardName.equals("12.png") || cardName.equals("13.png") ||
                cardName.equals("24.png") || cardName.equals("25.png") || cardName.equals("26.png") ||
                cardName.equals("37.png") || cardName.equals("38.png") || cardName.equals("39.png") ||
                cardName.equals("50.png") || cardName.equals("51.png") || cardName.equals("52.png")) {
            return -10;
        } else if (cardName.equals("2.png") || cardName.equals("15.png") ||
                cardName.equals("28.png") || cardName.equals("41.png")) {
            return 2;
        } else if (cardName.equals("1.png") || cardName.equals("14.png") ||
                cardName.equals("27.png") || cardName.equals("40.png")) {
            return 1;

        } else if (cardName.equals("3.png") || cardName.equals("16.png") ||
                cardName.equals("29.png") || cardName.equals("42.png")) {
            return 3;
        } else if (cardName.equals("4.png") || cardName.equals("17.png") ||
                cardName.equals("30.png") || cardName.equals("43.png")) {
            return 4;
        } else if (cardName.equals("5.png") || cardName.equals("18.png") ||
                cardName.equals("31.png") || cardName.equals("44.png")) {
            return 5;
        } else if (cardName.equals("6.png") || cardName.equals("19.png") ||
                cardName.equals("32.png") || cardName.equals("45.png")) {
            return 6;
        } else if (cardName.equals("7.png") || cardName.equals("20.png") ||
                cardName.equals("33.png") || cardName.equals("46.png")) {
            return 7;
        } else if (cardName.equals("8.png") || cardName.equals("21.png") ||
                cardName.equals("34.png") || cardName.equals("47.png")) {
            return 8;
        } else if (cardName.equals("9.png") || cardName.equals("22.png") ||
                cardName.equals("35.png") || cardName.equals("48.png")) {
            return 0;
        } else if (cardName.equals("10.png") || cardName.equals("23.png") ||
                cardName.equals("36.png") || cardName.equals("49.png")) {
            return 10;
        }




        return 0; // Si no se encuentra, retornamos valor por defecto
    }
    @Override
    public void run() {
        while (true) {
            try {
                // Espera de 2 segundos entre cada turno de la máquina
                Thread.sleep(2000);

                // La máquina juega su carta
                onMachinePlayCard();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método que coloca la única carta de la mano de la máquina en el deck
    public void onMachinePlayCard() {
        if (machineHand.isEmpty()) {
            getNewCardForMachine();
        }

        // Obtener la única carta de la mano de la máquina
        Card machineCard = machineHand.get(0);

        // Colocar la carta en el deck de la mesa
        Image cardImage = new Image(getClass().getResource("/com/example/images/" + machineCard.getName()).toExternalForm());
        gameController.updateDeck(cardImage); // Coloca la carta en el ImageView deckmesa

        // Limpiar la mano de la máquina
        // Aumentar el turno
        turnNumber++;
        System.out.println("ESTE ES EL ASIGNADO FINAL EN MACHINE CARD: " + machineCard.getValue());
        gameController.updateTotalValue(machineCard.getValue());

    }
}
