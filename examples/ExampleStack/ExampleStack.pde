// Beispiel für die Nutzung von Stack in Processing
import mk.nds.adt.Stack;

Stack<Integer> stapel;

void setup() {
  size(400, 200);
  stapel = new Stack<Integer>();
  stapel.push(10);
  stapel.push(20);
  stapel.push(30);
  println("Stack Inhalt:");
  while (!stapel.isEmpty()) {
    int wert = stapel.pop();
    println(wert);
  }
}

void draw() {
  background(255);
  text("Stack Beispiel", 20, 30);
}
