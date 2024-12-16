package com.example.demo1.models;

import java.util.HashSet;
import java.util.Set;

public class Card {

    private String imageName;  // Nombre del archivo de la imagen de la carta
    private int value;         // Valor de la carta (por ejemplo, 2, 3, 4, 5, 6, 7, 8, 0, 10)
    private String suit;       // Palo de la carta (Pica, Corazón, Diamante, Trebol)

    // Listas de cartas que tienen un valor específico
    public static final Set<String> VALUE_2_CARDS = new HashSet<>();
    public static final Set<String> VALUE_3_CARDS = new HashSet<>();
    public static final Set<String> VALUE_4_CARDS = new HashSet<>();
    public static final Set<String> VALUE_5_CARDS = new HashSet<>();
    public static final Set<String> VALUE_6_CARDS = new HashSet<>();
    public static final Set<String> VALUE_7_CARDS = new HashSet<>();
    public static final Set<String> VALUE_8_CARDS = new HashSet<>();
    public static final Set<String> VALUE_0_CARDS = new HashSet<>();
    public static final Set<String> VALUE_10_CARDS = new HashSet<>();
    public static final Set<String> VALUE_M10_CARDS = new HashSet<>();

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
        this.value = determineCardValue(imageName);
        this.suit = determineCardSuit(imageName);
    }

    // Método para determinar el valor de la carta en función del nombre de la imagen
    private int determineCardValue(String imageName) {
        switch (imageName) {
            case "11.png":
            case "12.png":
            case "13.png":
            case "24.png":
            case "25.png":
            case "26.png":
            case "37.png":
            case "38.png":
            case "39.png":
            case "50.png":
            case "51.png":
            case "52.png":
                return -10;
            case "2.png":
            case "15.png":
            case "28.png":
            case "41.png":
                return 2;
            case "1.png":
            case "14.png":
            case "27.png":
            case "40.png":
                return 1;
            case "3.png":
            case "16.png":
            case "29.png":
            case "42.png":
                return 3;
            case "4.png":
            case "17.png":
            case "30.png":
            case "43.png":
                return 4;
            case "5.png":
            case "18.png":
            case "31.png":
            case "44.png":
                return 5;
            case "6.png":
            case "19.png":
            case "32.png":
            case "45.png":
                return 6;
            case "7.png":
            case "20.png":
            case "33.png":
            case "46.png":
                return 7;
            case "8.png":
            case "21.png":
            case "34.png":
            case "47.png":
                return 8;
            case "9.png":
            case "22.png":
            case "35.png":
            case "48.png":
                return 0;
            case "10.png":
            case "23.png":
            case "36.png":
            case "49.png":
                return 10;
            default:
                // Handle invalid image names
                return 0;
        }
    }


    // Método para determinar el palo de la carta en función del nombre de la imagen
    private String determineCardSuit(String imageName) {
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

    // Métodos getter
    public String getImageName() {
        return imageName;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    // Método toString
    @Override
    public String toString() {
        return "Card{" +
                "imageName='" + imageName + '\'' +
                ", value=" + value +
                ", suit='" + suit + '\'' +
                '}';
    }
    public String getName() {
        return imageName; // Devuelve el nombre de la imagen, que es el identificador único de la carta.
    }
}