package com.example.demo1.controllers;

import com.example.demo1.view.GameView;
import javafx.event.ActionEvent; // Importación corregida
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

    @FXML
    void onHandleInstructionsButton(ActionEvent event) {
        // Agrega la lógica para el botón de instrucciones
    }

    @FXML
    void selectNumberOfPlayers(MouseEvent event) {

    }

    @FXML
    void onHandlePlayButton(ActionEvent event)  {
        try {
            // Instancia de la ventana del juego y muestra GameView
            GameView gameView = GameView.getInstance();
            gameView.show(); // Mostrar la vista del juego
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de excepciones si no se puede cargar el FXML de la vista del juego
        }
    }
}
        // Agrega la lógica para el botón de jugar

