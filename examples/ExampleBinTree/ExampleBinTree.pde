// Beispiel für die Nutzung von BinTree in Processing
import mk.nds.adt.BinTree;

BinTree<Integer> baum;

void setup() {
  size(400, 200);
  baum = new BinTree<Integer>();
  // Werte setzen mit setItem, setLeft, setRight
  baum.setItem(5);
  BinTree<Integer> links = new BinTree<Integer>();
  links.setItem(3);
  baum.setLeft(links);
  BinTree<Integer> rechts = new BinTree<Integer>();
  rechts.setItem(7);
  baum.setRight(rechts);

  // Weiteren Knoten über den vorhandenen leeren Teilbaum ergänzen
  baum.getRight().getLeft().setItem(6);

  println("Inorder-Ausgabe:");
  inorderAusgeben(baum);
}

void draw() {
  background(255);
  text("BinTree Beispiel", 20, 30);
}

// Gibt die Inhalte rekursiv in der Reihenfolge links - Wurzel - rechts aus
void inorderAusgeben(BinTree<Integer> teilbaum) {
  // Ein leerer Baum hat keinen Inhalt, daher wird vorher abgefragt.
  if (!teilbaum.isEmpty()) {
    inorderAusgeben(teilbaum.getLeft());
    int wert = teilbaum.getItem();
    println(wert);
    inorderAusgeben(teilbaum.getRight());
  }
}
