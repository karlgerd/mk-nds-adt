package example;

import mk.nds.adt.BinTree;

public class BinTreeExample {
    public static void main(String[] args) {
        // BinTree mit Wurzel erzeugen
        BinTree baum = new BinTree("42");
        System.out.println("Baum ist leer: " + baum.isEmpty());
        System.out.println("Wurzelwert: " + (String) baum.getItem());

        // Linken und rechten Teilbaum setzen
        baum.setLeft(new BinTree("L"));
        baum.setRight(new BinTree("R"));

        // Werte der Teilbäume ausgeben
        System.out.println("Linker Teilbaum: " + (String) baum.getLeft().getItem());
        System.out.println("Rechter Teilbaum: " + (String) baum.getRight().getItem());

        // Blatt prüfen
        System.out.println("Ist Wurzel ein Blatt? " + baum.isLeaf());
        System.out.println("Ist linker Teilbaum ein Blatt? " + baum.getLeft().isLeaf());

        // Wert des linken Teilbaums ändern
        baum.getLeft().setItem("LinksNeu");
        System.out.println("Neuer Wert linker Teilbaum: " + (String) baum.getLeft().getItem());

        // Baum leeren mit setEmpty
        baum.setEmpty();
        System.out.println("Baum nach setEmpty ist leer: " + baum.isEmpty());
    }
}
