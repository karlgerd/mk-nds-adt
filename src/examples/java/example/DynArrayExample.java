package example;

import mk.nds.adt.DynArray;

public class DynArrayExample {
    public static void main(String[] args) {
        DynArray<String> reihung = new DynArray<>();
        System.out.println("Reihung ist leer: " + reihung.isEmpty());

        // Elemente am Ende anfügen
        reihung.append("Alpha");
        reihung.append("Bravo");
        reihung.append("Charlie");
        System.out.println("Länge nach 3 mal 'append': " + reihung.getLength());

        // Element an Position 1 einfügen, die folgenden rücken nach hinten
        reihung.insertAt(1, "Delta");
        System.out.println("Element an Position 1 nach insertAt: " + reihung.getItem(1));

        // Element an Position 2 ersetzen (nur wenn die Position existiert)
        int position = 2;
        if (position < reihung.getLength()) {
            reihung.setItem(position, "Echo");
            System.out.println("Element an Position 2 nach setItem: " + reihung.getItem(position));
        }

        // Alle Elemente mit Index ausgeben
        System.out.println("Alle Elemente der Reihung:");
        for (int i = 0; i < reihung.getLength(); i++) {
            System.out.println("Index " + i + ": " + reihung.getItem(i));
        }

        // Element an Position 0 löschen (nur wenn die Reihung nicht leer ist)
        if (!reihung.isEmpty()) {
            reihung.delete(0);
        }
        System.out.println("Länge nach 1 mal 'delete': " + reihung.getLength());

        // Alle Elemente mit einer for-each-Schleife ausgeben.
        // Achtung: Innerhalb der Schleife darf die Reihung nicht durch append,
        // insertAt oder delete verändert werden, sonst bricht das Programm mit
        // einer ConcurrentModificationException ab.
        System.out.println("Alle Elemente nach delete:");
        for (String wert : reihung) {
            System.out.println(wert);
        }

        // Zustand prüfen
        System.out.println("Reihung ist leer: " + reihung.isEmpty());
    }
}
