package com.example.demo1.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WelcomeView {

    private static WelcomeView instance;
    private ImageView imageView;

    private WelcomeView() {

        try {

            Image image = new Image(getClass().getResourceAsStream("/com/example/images/portada.png"));
            imageView = new ImageView(image);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la imagen.");
        }
    }

    public static WelcomeView getInstance() {
        if (instance == null) {
            instance = new WelcomeView();
        }
        return instance;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
