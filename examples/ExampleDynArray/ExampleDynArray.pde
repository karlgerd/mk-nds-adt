// Beispiel für die Nutzung von DynArray in Processing
import mk.nds.adt.DynArray;

DynArray arr;

void setup() {
  size(400, 200);
  arr = new DynArray();
  arr.append("A");
  arr.append("B");
  arr.append("C");
  println("DynArray Inhalt:");
  for (int i = 0; i < arr.getLength(); i++) {
    String s = (String) arr.getItem(i);
    println(s);
  }
}

void draw() {
  background(255);
  text("DynArray Beispiel", 20, 30);
}
