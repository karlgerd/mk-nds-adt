// Beispiel für die Nutzung von BinTree in Processing
import mk.nds.adt.BinTree;

BinTree<Integer> baum;

void setup() {
  size(400, 200);
  baum = new BinTree<Integer>();
  // Werte setzen mit setItem, setLeft, setRight
  baum.setItem(5);
  BinTree<Integer> left = new BinTree<Integer>();
  left.setItem(3);
  baum.setLeft(left);
  BinTree<Integer> right = new BinTree<Integer>();
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
void inorderPrint(BinTree<Integer> node) {
  if (node.isEmpty()) return;
  inorderPrint(node.getLeft());
  println(node.getItem());
  inorderPrint(node.getRight());
}
