package com.example.demo1.view;

import com.example.demo1.controllers.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView extends Stage {

        private GameController gameController;

        public GameView() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/game-view.fxml"));
            Parent root = loader.load();
            this.gameController = loader.getController();
            this.setTitle("Craps Game");
            Scene scene = new Scene(root);
            this.setScene(scene);
            this.show();
        }

        public GameController getGameController() {
            return this.gameController;
        }

        public static GameView getInstance() throws IOException {
            return GameViewHolder.INSTANCE = new GameView();
        }

        private static class GameViewHolder {
            private static GameView INSTANCE;
        }}