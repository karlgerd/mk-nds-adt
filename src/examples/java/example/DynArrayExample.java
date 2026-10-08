package example;

import mk.nds.adt.DynArray;

public class DynArrayExample {
    public static void main(String[] args) {
        DynArray reihung = new DynArray();
        System.out.println("Reihung ist leer: " + reihung.isEmpty());

        // Elemente hinzufügen
        reihung.append("Alpha");
        reihung.append("Bravo");
        reihung.append("Charlie");
        System.out.println("Länge nach 3 mal 'append': " + reihung.getLength());

        // Element an Position 1 einfügen
        reihung.insertAt(1, "Delta");
        System.out.println("Element an Position 1 nach insertAt: " + (String) reihung.getItem(1));

        // Element an Position 2 ersetzen
        reihung.setItem(2, "Echo");
        System.out.println("Element an Position 2 nach setItem: " + (String) reihung.getItem(2));

        // Alle Elemente ausgeben
        System.out.println("Alle Elemente der Reihung:");
        for (int i = 0; i < reihung.getLength(); i++) {
            System.out.println("Index " + i + ": " + (String) reihung.getItem(i));
        }

        // Element an Position 0 löschen
        reihung.delete(0);
        System.out.println("Länge nach 1 mal 'delete': " + reihung.getLength());

        // Alle Elemente nach dem Löschen ausgeben
        System.out.println("Alle Elemente nach delete:");
        for (int i = 0; i < reihung.getLength(); i++) {
            System.out.println("Index " + i + ": " + (String) reihung.getItem(i));
        }

        // Zustand prüfen
        System.out.println("Reihung ist leer: " + reihung.isEmpty());
    }
}

