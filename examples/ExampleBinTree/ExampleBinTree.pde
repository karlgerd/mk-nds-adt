// Beispiel für die Nutzung von BinTree in Processing
import mk.nds.adt.BinTree;

BinTree baum;

void setup() {
  size(400, 200);
  baum = new BinTree();
  // Werte setzen mit setItem, setLeft, setRight
  baum.setItem(5);
  BinTree left = new BinTree();
  left.setItem(3);
  baum.setLeft(left);
  BinTree right = new BinTree();
  right.setItem(7);
  baum.setRight(right);
  println("Inorder Traversierung:");
  inorderPrint(baum);
}

void draw() {
  background(255);
  text("BinTree Beispiel", 20, 30);
}

// Hilfsmethode für Inorder-Traversierung
void inorderPrint(BinTree node) {
  if (node.isEmpty()) return;
  inorderPrint(node.getLeft());
  println((int)node.getItem());
  inorderPrint(node.getRight());
}
