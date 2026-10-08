package example;

import mk.nds.adt.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack stapel = new Stack();
        System.out.println("Stapel ist leer: " + stapel.isEmpty());

        // Zeichenketten auf den Stapel legen
        stapel.push("Alpha");
        stapel.push("Bravo");
        stapel.push("Charlie");
        System.out.println("Stapel ist leer: " + stapel.isEmpty());

        // Oberstes Element auslesen
        System.out.println("Oberstes Element: " + (String) stapel.top());

        // Alle Elemente mit pop entfernen und ausgeben
        while (!stapel.isEmpty()) {
            System.out.println("Entfernt: " + (String) stapel.pop());
        }

        // Stapel ist wieder leer
        System.out.println("Stapel ist leer: " + stapel.isEmpty());
    }
}
