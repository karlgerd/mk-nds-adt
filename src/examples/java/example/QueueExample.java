package example;

import mk.nds.adt.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> schlange = new Queue<>();
        System.out.println("Schlange ist leer: " + schlange.isEmpty());

        // Zeichenketten hinten an die Schlange anhängen
        schlange.enqueue("Alpha");
        schlange.enqueue("Bravo");
        schlange.enqueue("Charlie");
        System.out.println("Schlange ist leer: " + schlange.isEmpty());

        // Vorderstes Element auslesen (nur wenn die Schlange nicht leer ist)
        if (!schlange.isEmpty()) {
            System.out.println("Vorderstes Element: " + schlange.head());
        }

        // Alle Elemente mit dequeue entnehmen und ausgeben
        while (!schlange.isEmpty()) {
            String wert = schlange.dequeue();
            System.out.println("Entnommen: " + wert);
        }

        // Schlange ist wieder leer
        System.out.println("Schlange ist leer: " + schlange.isEmpty());
    }
}
