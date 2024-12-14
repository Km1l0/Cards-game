package com.example.demo1.models;

import java.util.HashSet;
import java.util.Set;

public class Card {

    private String imageName;  // Nombre del archivo de la imagen de la carta
    private int value;         // Valor de la carta (por ejemplo, 2, 3, 4, 5, 6, 7, 8, 0, 10)

    // Listas de cartas que tienen un valor específico
    private static final Set<String> VALUE_2_CARDS = new HashSet<>();
    private static final Set<String> VALUE_3_CARDS = new HashSet<>();
    private static final Set<String> VALUE_4_CARDS = new HashSet<>();
    private static final Set<String> VALUE_5_CARDS = new HashSet<>();
    private static final Set<String> VALUE_6_CARDS = new HashSet<>();
    private static final Set<String> VALUE_7_CARDS = new HashSet<>();
    private static final Set<String> VALUE_8_CARDS = new HashSet<>();
    private static final Set<String> VALUE_0_CARDS = new HashSet<>();
    private static final Set<String> VALUE_10_CARDS = new HashSet<>();
    private static final Set<String> VALUE_M10_CARDS = new HashSet<>();

    static {
        // Cartas con valor 2
        VALUE_2_CARDS.add("2.png");
        VALUE_2_CARDS.add("15.png");
        VALUE_2_CARDS.add("28.png");
        VALUE_2_CARDS.add("41.png");

        // Cartas con valor 3
        VALUE_3_CARDS.add("3.png");
        VALUE_3_CARDS.add("16.png");
        VALUE_3_CARDS.add("29.png");
        VALUE_3_CARDS.add("42.png");

        // Cartas con valor 4
        VALUE_4_CARDS.add("4.png");
        VALUE_4_CARDS.add("17.png");
        VALUE_4_CARDS.add("30.png");
        VALUE_4_CARDS.add("43.png");

        // Cartas con valor 5
        VALUE_5_CARDS.add("5.png");
        VALUE_5_CARDS.add("18.png");
        VALUE_5_CARDS.add("31.png");
        VALUE_5_CARDS.add("44.png");

        // Cartas con valor 6
        VALUE_6_CARDS.add("6.png");
        VALUE_6_CARDS.add("19.png");
        VALUE_6_CARDS.add("32.png");
        VALUE_6_CARDS.add("45.png");

        // Cartas con valor 7
        VALUE_7_CARDS.add("7.png");
        VALUE_7_CARDS.add("20.png");
        VALUE_7_CARDS.add("33.png");
        VALUE_7_CARDS.add("46.png");

        // Cartas con valor 8
        VALUE_8_CARDS.add("8.png");
        VALUE_8_CARDS.add("21.png");
        VALUE_8_CARDS.add("34.png");
        VALUE_8_CARDS.add("47.png");

        // Cartas con valor 0
        VALUE_0_CARDS.add("9.png");
        VALUE_0_CARDS.add("22.png");
        VALUE_0_CARDS.add("35.png");
        VALUE_0_CARDS.add("48.png");

        // Cartas con valor 10
        VALUE_10_CARDS.add("10.png");
        VALUE_10_CARDS.add("23.png");
        VALUE_10_CARDS.add("36.png");
        VALUE_10_CARDS.add("49.png");


        VALUE_M10_CARDS.add("11.png");
        VALUE_M10_CARDS.add("22.png");
        VALUE_M10_CARDS.add("33.png");
        VALUE_M10_CARDS.add("24.png");
        VALUE_M10_CARDS.add("25.png");
        VALUE_M10_CARDS.add("26.png");
        VALUE_M10_CARDS.add("37.png");
        VALUE_M10_CARDS.add("38.png");
        VALUE_M10_CARDS.add("39.png");
        VALUE_M10_CARDS.add("50.png");
        VALUE_M10_CARDS.add("51.png");
        VALUE_M10_CARDS.add("52.png");
    }

    // Constructor
    public Card(String imageName) {
        this.imageName = imageName;
        this.value = determineCardValue(imageName);  // Asignamos el valor de la carta
    }

    // Método para determinar el valor de la carta basado en el nombre de la imagen
    private int determineCardValue(String imageName) {
        if (VALUE_2_CARDS.contains(imageName)) {
            return 2;
        } else if (VALUE_3_CARDS.contains(imageName)) {
            return 3;
        } else if (VALUE_4_CARDS.contains(imageName)) {
            return 4;
        } else if (VALUE_5_CARDS.contains(imageName)) {
            return 5;
        } else if (VALUE_6_CARDS.contains(imageName)) {
            return 6;
        } else if (VALUE_7_CARDS.contains(imageName)) {
            return 7;
        } else if (VALUE_8_CARDS.contains(imageName)) {
            return 8;
        } else if (VALUE_0_CARDS.contains(imageName)) {
            return 0;  // Valor 0 para las cartas 9, 22, 35 y 48
        } else if (VALUE_10_CARDS.contains(imageName)) {
            return 10;  // Valor 10 para las cartas 10, 23, 36 y 49
        } else if (VALUE_M10_CARDS.contains(imageName)) {
        return -10;
    }

        return 0;  // Valor predeterminado si no está en ninguna de las listas
    }

    // Getters y Setters
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "imageName='" + imageName + '\'' +
                ", value=" + value +
                '}';
    }}