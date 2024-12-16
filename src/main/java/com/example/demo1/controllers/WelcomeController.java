package com.example.demo1.controllers;

import com.example.demo1.view.GameView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private ImageView imageView;

    @FXML
    private Button instructionsButton;

    @FXML
    private ListView<?> listView;

    // Declarar gameStart como estático
    public static boolean gameStart = false;  // Hacerlo estático

    @FXML
    void onHandleInstructionsButton(ActionEvent event) {
        // Agrega la lógica para el botón de instrucciones
    }

    @FXML
    void selectNumberOfPlayers(MouseEvent event) {
        // Lógica para seleccionar el número de jugadores
    }

    @FXML
    void onHandlePlayButton(ActionEvent event) {
        try {
            // Cambiar gameStart a true cuando se inicie el juego
            gameStart = true;  // Ahora cambia gameStart a true cuando se presiona "Jugar"

            // Instancia de la ventana del juego y muestra GameView
            GameView gameView = GameView.getInstance();
            gameView.show(); // Mostrar la vista del juego
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de excepciones si no se puede cargar el FXML de la vista del juego
        }
    }
}