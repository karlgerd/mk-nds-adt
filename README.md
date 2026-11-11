# mk-nds-adt

`mk-nds-adt` stellt die vier Java-Datentypen `BinTree`, `DynArray`, `Queue` und
`Stack` für den Informatikunterricht in Niedersachsen bereit. Alle vier Klassen
sind mit generischen Typen umgesetzt: Der Inhaltstyp wird beim Anlegen
angegeben, zum Beispiel `Stack<String>` oder `DynArray<Integer>`, sodass beim
Auslesen keine Typ-Casts nötig sind (siehe [Inhaltstypen](#inhaltstypen)).

Die Klassen orientieren sich an den *Ergänzenden Hinweisen für das Fach Informatik* des
Niedersächsischen Kultusministeriums (Neufassung, Stand Juni 2025). Maßgeblich
sind die offiziellen Vorgaben; diese Bibliothek ist eine Implementierung
dieser Vorgaben und kein Ersatz für das Dokument.

Die Bibliothek ist eine reine Java-Bibliothek ohne Laufzeitabhängigkeiten und
lässt sich in jeder Java-Entwicklungsumgebung verwenden. Zusätzlich wird sie
als fertige Bibliothek für Processing bereitgestellt.

**Voraussetzung:** Java 11 oder neuer. Für Processing bedeutet das:
Processing 4 (Processing 3 läuft mit Java 8 und kann die Bibliothek nicht
laden).

## Was brauche ich?

| Ich möchte … | Das passende Paket | Verwendung |
| --- | --- | --- |
| die Klassen in einem Java-Projekt verwenden | `mk-nds-adt-3.0.0.jar` auf der [Release-Seite](https://github.com/karlgerd/mk-nds-adt/releases) | JAR als Bibliothek zum Projekt hinzufügen. Die optionale `mk-nds-adt-3.0.0-javadoc.jar` enthält die API-Dokumentation. |
| nur die Java-Dateien übernehmen | `mk-nds-adt-3.0.0-sources.jar` auf der [Release-Seite](https://github.com/karlgerd/mk-nds-adt/releases) | JAR wie ein ZIP-Archiv öffnen und die vier Dateien aus `mk/nds/adt/` in den Java-Quellordner kopieren. Tests und Beispiele sind nicht enthalten. |
| Processing verwenden | `ADTNiedersachsen.zip` auf der [Release-Seite](https://github.com/karlgerd/mk-nds-adt/releases) | ZIP entpacken und den enthaltenen Ordner `ADTNiedersachsen` in den Processing-Bibliotheksordner kopieren. Processing anschließend neu starten. |

Die Pakete werden bei einem [GitHub-Release](https://github.com/karlgerd/mk-nds-adt/releases)
bereitgestellt. Der Inhalt der Sources-JAR ist auf die vier Bibliotheksdateien
beschränkt.

### Einbindung in gängige Schul- und Java-Entwicklungsumgebungen

- **IntelliJ IDEA:** Im Projekt unter *File → Project Structure → Modules →
  Dependencies* die JAR als Bibliothek hinzufügen. Alternativ die Java-Dateien
  aus der Sources-JAR in den Quellordner kopieren.
- **Eclipse:** Über *Build Path → Add External Archives…* die JAR hinzufügen.
  Alternativ die vier Java-Dateien in den Quellordner des Projekts legen.
- **BlueJ:** Die JAR reicht aus. Sie kann in den persönlichen Ordner `userlib`
  kopiert oder in BlueJ über *Einstellungen → Bibliotheken* hinzugefügt werden.
  BlueJ danach gegebenenfalls neu starten.
- **VS Code:** Mit der Java-Erweiterung die JAR als referenzierte Bibliothek
  hinzufügen (Java-Projektansicht oder `java.project.referencedLibraries`).
- **Processing:** Die Processing-ZIP enthält die von Processing erwartete
  Struktur. Den Ordner `ADTNiedersachsen` aus dem Archiv in den Ordner `libraries`
  im Processing-Sketchbook kopieren und Processing neu starten.

## Inhaltstypen

Alle Klassen liegen im Paket `mk.nds.adt` und sind generisch. Beim Anlegen
wird in spitzen Klammern angegeben, welchen Inhaltstyp die Elemente haben:

```java
Stack<String> stapel = new Stack<>();
stapel.push("A");
String oben = stapel.top();   // kein Typ-Cast nötig
```

Der Compiler prüft dann, dass nur passende Inhalte abgelegt werden, und beim
Auslesen ist kein Typ-Cast erforderlich.

### Primitive Datentypen wie `int`, `double` oder `boolean`

In spitzen Klammern dürfen nur Klassen stehen, keine primitiven Datentypen.
Für jeden primitiven Datentyp gibt es in Java eine passende *Hüllklasse*:

| primitiver Datentyp | Hüllklasse |
| --- | --- |
| `int` | `Integer` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `char` | `Character` |
| `long` | `Long` |

Die Hüllklasse wird nur bei der Angabe des Inhaltstyps benötigt. Im übrigen
Programm wird wie gewohnt mit den primitiven Werten gearbeitet: Java wandelt
einen `int`-Wert beim Ablegen automatisch in ein `Integer`-Objekt um und beim
Auslesen wieder zurück (*Autoboxing* bzw. *Unboxing*).

```java
Stack<Integer> stapel = new Stack<>();
stapel.push(42);              // int-Wert wird direkt übergeben
int wert = stapel.pop();      // Ergebnis wird direkt als int verwendet
int summe = wert + 8;

DynArray<Boolean> antworten = new DynArray<>();
antworten.append(true);
if (antworten.getItem(0)) {
    System.out.println("Die erste Antwort ist wahr.");
}
```

### Ausgelesene Zahlen vergleichen

Beim Vergleichen mit `==` ist eine Eigenschaft von Java zu beachten, die alle
generischen Datenstrukturen betrifft, zum Beispiel auch Javas eigene
`ArrayList<Integer>`: Operationen wie `getItem`, `top` oder `dequeue` liefern
Objekte der Hüllklasse, also etwa ein `Integer`-Objekt und keinen `int`-Wert.
Stehen auf **beiden** Seiten von `==` solche Objekte, prüft Java, ob es sich um
*dasselbe Objekt* handelt, und nicht, ob die Zahlenwerte übereinstimmen.

Sobald dagegen mindestens eine Seite ein primitiver Wert ist, vergleicht Java
wie gewohnt die Zahlenwerte. Daraus ergibt sich eine einfache Arbeitsweise:

**Ausgelesene Zahlen zuerst in einer Variablen vom primitiven Typ speichern und
dann mit dieser Variablen rechnen und vergleichen.**

```java
DynArray<Integer> reihung = new DynArray<>();
reihung.append(1000);
reihung.append(1000);

int erster = reihung.getItem(0);
int zweiter = reihung.getItem(1);
if (erster == zweiter) {                 // vergleicht die Zahlenwerte
    System.out.println("Die Werte sind gleich.");
}
```

Diese Schreibweise ist ohnehin gut lesbar und entspricht dem üblichen Vorgehen
in Algorithmen. Ebenso unproblematisch sind Vergleiche mit einer Zahl oder
einer `int`-Variablen:

```java
if (reihung.getItem(0) == 1000) { ... }        // korrekt
if (reihung.getItem(0) > reihung.getItem(1)) { ... }   // korrekt: <, >, <=, >=
                                                       // vergleichen immer Zahlenwerte
```

Nur der direkte Vergleich zweier ausgelesener Inhalte mit `==` oder `!=`, also
`reihung.getItem(0) == reihung.getItem(1)`, sollte vermieden werden. Dass er
in kleinen Tests manchmal trotzdem das erwartete Ergebnis liefert, liegt an
einer internen Optimierung von Java für kleine Zahlen; darauf darf man sich
nicht verlassen. Wer zwei Inhalte direkt vergleichen möchte, verwendet
`equals` – so, wie man es auch von Zeichenketten kennt:

```java
if (reihung.getItem(0).equals(reihung.getItem(1))) { ... }
```

### Nutzung ohne Angabe des Inhaltstyps

Die Klassen können auch ohne Angabe eines Inhaltstyps deklariert und erzeugt
werden:

```java
Stack stapel = new Stack();
stapel.push("A");
String wert = (String) stapel.pop();
```

Die Inhalte sind dann vom Typ `Object`, beim Auslesen ist daher ein Typ-Cast
nötig. Das Programm lässt sich trotzdem übersetzen und ausführen.

Je nach Entwicklungsumgebung erscheint dabei ein kurzer Hinweis des Compilers,
etwa „uses unchecked or unsafe operations“ oder eine Warnung zu einem
„raw type“. Das ist kein Fehler, sondern nur der Hinweis, dass der Compiler die
Inhaltstypen nicht prüfen kann. In Processing wird in der Regel kein solcher
Hinweis angezeigt.

## Kurze Beispiele

### BinTree

```java
import mk.nds.adt.BinTree;

BinTree<String> baum = new BinTree<>("Wurzel");
baum.setLeft(new BinTree<>("Links"));
System.out.println(baum.getLeft().getItem());
```

### DynArray

```java
import mk.nds.adt.DynArray;

DynArray<String> reihung = new DynArray<>();
reihung.append("A");
reihung.insertAt(1, "B");
for (String wert : reihung) {
    System.out.println(wert);
}
```

### Queue

```java
import mk.nds.adt.Queue;

Queue<String> schlange = new Queue<>();
schlange.enqueue("A");
System.out.println(schlange.dequeue());
```

### Stack

```java
import mk.nds.adt.Stack;

Stack<Integer> stapel = new Stack<>();
stapel.push(1);
int wert = stapel.pop();
```

In Processing sollte der Inhaltstyp beim Erzeugen ausgeschrieben werden,
also `new Stack<Integer>()` statt `new Stack<>()`.

## Verhalten bei Fehlern

Laut den Ergänzenden Hinweisen müssen mögliche Laufzeitfehler, etwa das
Entnehmen bei einem leeren Stapel, bei der Verwendung durch entsprechende
Abfragen explizit ausgeschlossen werden. Wird eine Operation trotzdem
unzulässig aufgerufen, lösen die Klassen eine Ausnahme mit deutscher
Fehlermeldung aus:

| Situation | Ausnahme |
| --- | --- |
| Lesen oder Entnehmen, obwohl kein Element vorhanden ist (`top`/`pop` beim leeren Stapel, `head`/`dequeue` bei leerer Schlange, `getItem`/`isLeaf`/`getLeft`/`getRight` beim leeren Baum) | `NoSuchElementException` |
| Setzen eines Teilbaums bei einem leeren Baum (`setLeft`/`setRight`) | `IllegalStateException` |
| Index außerhalb des gültigen Bereichs (`DynArray`) | `IndexOutOfBoundsException` |
| `null` als Inhalt oder als Teilbaum | `IllegalArgumentException` |
| Einfügen oder Löschen in einer `DynArray` während einer for-each-Schleife über dieselbe Reihung | `ConcurrentModificationException` |

Das Ersetzen eines Inhalts mit `setItem` ist während einer for-each-Schleife
erlaubt.

## Interne Umsetzung

- `DynArray` speichert die Inhalte in einer statischen Reihung (Array). Ist
  diese voll, wird sie intern durch eine doppelt so große ersetzt.
- `Stack` und `Queue` sind als verkettete Listen umgesetzt. Ablegen, Anhängen
  und Entnehmen benötigen unabhängig von der Anzahl der Elemente immer gleich
  viel Zeit.
- `BinTree` ist rekursiv aufgebaut: Jeder nicht leere Baum besteht aus einem
  Inhalt sowie einem linken und einem rechten Teilbaum, die selbst wieder
  Binärbäume sind.

## Für Entwicklerinnen und Entwickler

Voraussetzung ist ein JDK 11 oder neuer sowie Maven. Im Stammverzeichnis
startet dieser Befehl den Build, führt die Tests aus und erzeugt alle
Veröffentlichungspakete:

```sh
mvn -B verify
```

Die Ergebnisse liegen im Ordner `target/`:

- `mk-nds-adt-3.0.0.jar` – Bibliothek mit Java-11-Bytecode
- `mk-nds-adt-3.0.0-sources.jar` – nur die vier Java-Quelldateien
- `mk-nds-adt-3.0.0-javadoc.jar` – API-Dokumentation
- `ADTNiedersachsen.zip` – Bibliothek im Format für Processing

Die automatischen Tests liegen unter `src/test/java/`. Eigenständige
Java-Beispiele liegen unter `src/examples/java/` und werden nicht in die
Bibliotheks-JAR aufgenommen. Beispiel-Sketches für Processing sind unter
`examples/` abgelegt.

### Ein Release erstellen

1. Version in `pom.xml` und `library.properties` aktualisieren; in
   `library.properties` ist `version` eine ganze Zahl und `prettyVersion` die
   lesbare Versionsnummer.
2. Den Eintrag in `CHANGELOG.md` ergänzen und lokal `mvn -B verify` ausführen.
3. Einen Tag im Format `v<Version>` erstellen und nach GitHub übertragen, zum
   Beispiel `v3.0.0`.
4. Der Release-Workflow baut und hängt die Sources-JAR, die Bibliotheks-JAR,
   die Javadoc-JAR sowie die Processing-ZIP an das GitHub-Release an.

## Autor und Hinweis

Erstellt von Carsten Rohe, Gymnasium Damme, Fachberater Informatik in der Regionalabteilung Osnabrück.

Diese Bibliothek ist **kein offizielles Angebot des Niedersächsischen Kultusministeriums (MK)**. Sie wurde unabhängig auf Grundlage der veröffentlichten *Ergänzenden Hinweise* erstellt und wird vom MK weder herausgegeben noch geprüft oder verantwortet. Verbindlich für Unterricht und Prüfungen sind allein die offiziellen Vorgaben des Ministeriums in ihrer jeweils aktuellen Fassung.

## Lizenz und Rechte

### Software (MIT-Lizenz)

Copyright (c) 2025-2026 Carsten Rohe

Die Bibliothek (Quellcode, JAR, Processing-Bibliothek, Beispiele) steht unter
der [MIT-Lizenz](LICENSE). Du darfst sie frei nutzen, ändern, weitergeben und
im Unterricht verwenden. Bedingung ist nur, dass der Lizenztext und der
Copyright-Hinweis erhalten bleiben.

### Externes Dokument des Niedersächsischen Kultusministeriums

Im Ordner `docs/` liegt zur Information das Dokument
[`INF_Ergaenzende-Hinweise_GO_Neufassung_2025.pdf`](docs/INF_Ergaenzende-Hinweise_GO_Neufassung_2025.pdf).

> **Dieses Dokument stammt vom Niedersächsischen Kultusministerium (MK) und ist
> kein Bestandteil dieser Software.** Es ist nicht von den Autoren dieses
> Repositories erstellt und steht **nicht** unter der MIT-Lizenz. Alle Rechte
> daran liegen beim Niedersächsischen Kultusministerium. Maßgeblich ist immer
> die jeweils aktuelle Fassung auf den offiziellen Seiten des Ministeriums.
