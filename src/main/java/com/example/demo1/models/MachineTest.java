package com.example.demo1.models;

import com.example.demo1.models.Machine; // Importa la clase Machine

public class MachineTest {

    private Machine machine = new Machine(null); // Instancia de la clase Machine

    public static void main(String[] args) {
        MachineTest test = new MachineTest();
        test.testGetCardValue();
        test.testGetCardValueWithRandomCard();
    }

    public void testGetCardValue() {
        // Probamos con una carta de valor -10
        assert getCardValueTest("11.png", -10);
        assert getCardValueTest("12.png", -10);
        assert getCardValueTest("13.png", -10);

        // Probamos con una carta de valor 2
        assert getCardValueTest("2.png", 2);
        assert getCardValueTest("15.png", 2);

        // Probamos con una carta de valor 1
        assert getCardValueTest("1.png", 1);
        assert getCardValueTest("14.png", 1);

        // Probamos con una carta de valor 3
        assert getCardValueTest("3.png", 3);
        assert getCardValueTest("16.png", 3);

        // Probamos con una carta de valor 4
        assert getCardValueTest("4.png", 4);
        assert getCardValueTest("17.png", 4);

        // Probamos con una carta de valor 5
        assert getCardValueTest("5.png", 5);
        assert getCardValueTest("18.png", 5);

        // Probamos con una carta de valor 6
        assert getCardValueTest("6.png", 6);
        assert getCardValueTest("19.png", 6);

        // Probamos con una carta de valor 7
        assert getCardValueTest("7.png", 7);
        assert getCardValueTest("20.png", 7);

        // Probamos con una carta de valor 8
        assert getCardValueTest("8.png", 8);
        assert getCardValueTest("21.png", 8);

        // Probamos con una carta de valor 0
        assert getCardValueTest("9.png", 0);
        assert getCardValueTest("22.png", 0);

        // Probamos con una carta de valor 10
        assert getCardValueTest("10.png", 10);
        assert getCardValueTest("23.png", 10);

        System.out.println("Todas las pruebas pasaron correctamente.");
    }

    // Método de prueba para verificar que la carta devuelve el valor correcto
    private boolean getCardValueTest(String cardName, int expectedValue) {
        int actualValue = machine.getCardValue(cardName);
        if (actualValue != expectedValue) {
            System.out.println("Error: Carta " + cardName + " debería tener valor " + expectedValue + " pero tiene " + actualValue);
            return false;
        }
        return true;
    }

    public void testGetCardValueWithRandomCard() {
        // Generar un número aleatorio entre 1 y 52
        int randomCardNumber = (int) (Math.random() * 52) + 1;
        String cardName = randomCardNumber + ".png";

        // Obtener el valor de la carta aleatoria
        int cardValue = machine.getCardValue(cardName);

        // Mostrar el resultado
        System.out.println("Carta aleatoria: " + cardName + ", Valor: " + cardValue);
    }

    // Nueva prueba para carta no válida (fuera del rango de 1 a 52)
    public void testInvalidCard() {
        // Probar con una carta no válida que no esté en el conjunto
        String invalidCard = "invalidCard.png";
        int cardValue = machine.getCardValue(invalidCard);

        // Comprobar que se maneja correctamente y que el valor es 0 (o algún valor esperado por una carta no válida)
        if (cardValue != 0) {
            System.out.println("Error: La carta no válida " + invalidCard + " debería tener valor 0, pero tiene " + cardValue);
        } else {
            System.out.println("Prueba para carta no válida pasó correctamente.");
        }
    }

    // Nueva prueba para cartas con valor máximo (10)
    public void testMaxValueCard() {
        // Probamos con una carta de valor 10
        assert getCardValueTest("10.png", 10);
        assert getCardValueTest("23.png", 10);
        assert getCardValueTest("36.png", 10);
        assert getCardValueTest("49.png", 10);

        System.out.println("Prueba para cartas de valor máximo pasó correctamente.");
    }

    // Nueva prueba para cartas con valor negativo
    public void testNegativeCardValue() {
        // Probamos con una carta con valor negativo
        assert getCardValueTest("11.png", -10);
        assert getCardValueTest("24.png", -10);
        assert getCardValueTest("37.png", -10);
        assert getCardValueTest("50.png", -10);

        System.out.println("Prueba para cartas con valor negativo pasó correctamente.");
    }
}