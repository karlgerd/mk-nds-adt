package example;

import mk.nds.adt.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stapel = new Stack<>();
        System.out.println("Stapel ist leer: " + stapel.isEmpty());

        // Zeichenketten auf den Stapel legen
        stapel.push("Alpha");
        stapel.push("Bravo");
        stapel.push("Charlie");
        System.out.println("Stapel ist leer: " + stapel.isEmpty());

        // Oberstes Element auslesen (nur wenn der Stapel nicht leer ist)
        if (!stapel.isEmpty()) {
            System.out.println("Oberstes Element: " + stapel.top());
        }

        // Alle Elemente mit pop entnehmen und ausgeben
        while (!stapel.isEmpty()) {
            String wert = stapel.pop();
            System.out.println("Entnommen: " + wert);
        }

        // Stapel ist wieder leer
        System.out.println("Stapel ist leer: " + stapel.isEmpty());
    }
}
