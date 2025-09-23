// Beispiel für die Nutzung von Queue in Processing
import mk.nds.adt.Queue;

Queue schlange;

void setup() {
  size(400, 200);
  schlange = new Queue();
  schlange.enqueue("Erstes Element");
  schlange.enqueue("Zweites Element");
  schlange.enqueue("Drittes Element");
  println("Queue Inhalt:");
  while (!schlange.isEmpty()) {
    String s = (String) schlange.dequeue();
    println(s);
  }
}

void draw() {
  background(255);
  text("Queue Beispiel", 20, 30);
}
