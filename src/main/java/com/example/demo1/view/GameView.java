package com.example.demo1.view;

import com.example.demo1.controllers.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView extends Stage {

    private GameController gameController; // Game controller

    public GameView() throws IOException {
        // Load the FXML file using FXMLLoader
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/Cards-game/game-view.fxml")
        );
        Parent root = loader.load(); // Load the root element from the FXML file

        // Get the associated controller from the FXMLLoader
        this.gameController = loader.getController();

        // Set the window title
        this.setTitle("Batalla Naval");

        // Create the scene with the loaded root element
        Scene scene = new Scene(root);

        // Set the window icon
        this.getIcons().add(new Image(
                getClass().getResourceAsStream("/com/example/Cards-game/images/portada.png")
        ));

        // Set the scene for this stage
        this.setScene(scene);

        // Display the window
        this.show();
    }

    public GameController getGameController() {
        return this.gameController;
    }

    public static GameView getInstance() throws IOException {
        if (GameViewHolder.INSTANCE == null) {
            // Create a new instance if it does not exist
            return GameViewHolder.INSTANCE = new GameView();
        } else {
            // Return the existing instance
            return GameViewHolder.INSTANCE;
        }
    }

    private static class GameViewHolder {
        private static GameView INSTANCE; // Singleton instance of GameView
    }
}
