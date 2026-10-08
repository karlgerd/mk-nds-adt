package example;

import mk.nds.adt.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue warteschlange = new Queue();
        System.out.println("Warteschlange ist leer: " + warteschlange.isEmpty());

        // Zeichenketten in die Warteschlange einfügen
        warteschlange.enqueue("Alpha");
        warteschlange.enqueue("Bravo");
        warteschlange.enqueue("Charlie");
        System.out.println("Warteschlange ist leer: " + warteschlange.isEmpty());

        // Vorderstes Element auslesen
        System.out.println("Vorderstes Element: " + (String) warteschlange.head());

        // Alle Elemente mit dequeue entfernen und ausgeben
        while (!warteschlange.isEmpty()) {
            System.out.println("Entfernt: " + (String) warteschlange.dequeue());
        }

        // Queue ist wieder leer
        System.out.println("Warteschlange ist leer: " + warteschlange.isEmpty());
    }
}
