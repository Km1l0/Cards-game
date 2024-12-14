package com.example.demo1.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeView extends Stage {

    public WelcomeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/welcome-view.fxml"));
        Parent root = loader.load();
        this.setTitle("Cincuentazo");
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }

    public static WelcomeView getInstance() throws IOException {
        return WelcomeViewHolder.INSTANCE = new WelcomeView();
    }

    private static class WelcomeViewHolder {
        private static WelcomeView INSTANCE;
    }
}
