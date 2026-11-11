// Beispiel für die Nutzung von DynArray in Processing
import mk.nds.adt.DynArray;

DynArray<String> reihung;

void setup() {
  size(400, 200);
  reihung = new DynArray<String>();
  reihung.append("A");
  reihung.append("B");
  reihung.append("C");

  // Element an Position 1 einfügen, die folgenden rücken nach hinten
  reihung.insertAt(1, "X");

  println("DynArray Inhalt mit Index:");
  for (int i = 0; i < reihung.getLength(); i++) {
    String wert = reihung.getItem(i);
    println(i + ": " + wert);
  }

  // Element an Position 0 löschen (nur wenn die Reihung nicht leer ist)
  if (!reihung.isEmpty()) {
    reihung.delete(0);
  }

  // Ausgabe mit einer for-each-Schleife.
  // Achtung: Innerhalb der Schleife darf die Reihung nicht durch append,
  // insertAt oder delete verändert werden.
  println("DynArray Inhalt nach delete:");
  for (String wert : reihung) {
    println(wert);
  }
}

void draw() {
}
