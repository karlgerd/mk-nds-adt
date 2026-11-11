// Beispiel für die Nutzung von Queue in Processing
import mk.nds.adt.Queue;

Queue<String> schlange;

void setup() {
  size(400, 200);
  schlange = new Queue<String>();
  schlange.enqueue("Erstes Element");
  schlange.enqueue("Zweites Element");
  schlange.enqueue("Drittes Element");

  // Vorderstes Element auslesen (nur wenn die Schlange nicht leer ist)
  if (!schlange.isEmpty()) {
    println("Vorderstes Element: " + schlange.head());
  }

  println("Queue Inhalt:");
  while (!schlange.isEmpty()) {
    String wert = schlange.dequeue();
    println(wert);
  }
}

void draw() {
  background(255);
  text("Queue Beispiel", 20, 30);
}
