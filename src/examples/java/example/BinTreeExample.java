package example;

import mk.nds.adt.BinTree;

public class BinTreeExample {
    public static void main(String[] args) {
        // Baum mit Wurzel erzeugen
        BinTree<String> baum = new BinTree<>("D");
        System.out.println("Baum ist leer: " + baum.isEmpty());
        System.out.println("Wurzelwert: " + baum.getItem());

        // Linken und rechten Teilbaum setzen
        baum.setLeft(new BinTree<>("B"));
        baum.setRight(new BinTree<>("F"));

        // Weitere Knoten über die vorhandenen leeren Teilbäume ergänzen
        baum.getLeft().getLeft().setItem("A");
        baum.getLeft().getRight().setItem("C");
        baum.getRight().getLeft().setItem("E");

        // Werte der Teilbäume ausgeben
        System.out.println("Linker Teilbaum: " + baum.getLeft().getItem());
        System.out.println("Rechter Teilbaum: " + baum.getRight().getItem());

        // Blatt prüfen
        System.out.println("Ist die Wurzel ein Blatt? " + baum.isLeaf());
        System.out.println("Ist der Knoten A ein Blatt? " + baum.getLeft().getLeft().isLeaf());

        // Baum rekursiv in der Reihenfolge links - Wurzel - rechts ausgeben
        System.out.print("Inorder-Ausgabe: ");
        inorderAusgeben(baum);
        System.out.println();

        // Baum leeren mit setEmpty
        baum.setEmpty();
        System.out.println("Baum nach setEmpty ist leer: " + baum.isEmpty());
    }

    /**
     * Gibt die Inhalte des Baums rekursiv in der Reihenfolge
     * linker Teilbaum - Wurzel - rechter Teilbaum aus.
     */
    static void inorderAusgeben(BinTree<String> baum) {
        // Ein leerer Baum hat keinen Inhalt, daher wird vorher abgefragt.
        if (!baum.isEmpty()) {
            inorderAusgeben(baum.getLeft());
            System.out.print(baum.getItem() + " ");
            inorderAusgeben(baum.getRight());
        }
    }
}
