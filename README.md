# mk-nds-adt

`mk-nds-adt` stellt die vier Java-Datentypen `BinTree`, `DynArray`, `Queue` und
`Stack` für den Informatikunterricht in Niedersachsen bereit. Die Klassen
orientieren sich an den *Ergänzenden Hinweisen für das Fach Informatik* des
Niedersächsischen Kultusministeriums (Neufassung, Stand Juni 2025). Maßgeblich
sind die offiziellen Vorgaben; diese Bibliothek ist eine Implementierung
dieser Vorgaben und kein Ersatz für das Dokument.

**Voraussetzung:** Java 11 oder neuer. In Processing bedeutet das: Processing 4
(Processing 3 läuft mit Java 8 und kann die Bibliothek nicht laden).

## Was brauche ich?

| Ich möchte … | Das passende Paket | Verwendung |
| --- | --- | --- |
| nur die Java-Dateien übernehmen | `mk-nds-adt-2.1.0-sources.jar` auf der [Release-Seite](https://github.com/karlgerd/processing-mk-nds-adt/releases) | JAR wie ein ZIP-Archiv öffnen und die vier Dateien aus `mk/nds/adt/` in den Java-Quellordner kopieren. Tests und Beispiele sind nicht enthalten. |
| die Klassen in einem Java-Projekt verwenden | `mk-nds-adt-2.1.0.jar` auf der [Release-Seite](https://github.com/karlgerd/processing-mk-nds-adt/releases) | JAR als Bibliothek zum Projekt hinzufügen. Die optionale `mk-nds-adt-2.1.0-javadoc.jar` enthält die API-Dokumentation. |
| Processing verwenden | `mk-nds-adt.zip` auf der [Release-Seite](https://github.com/karlgerd/processing-mk-nds-adt/releases) | ZIP entpacken und den enthaltenen Ordner `mk-nds-adt` in den Processing-Bibliotheksordner kopieren. Processing anschließend neu starten. |
| eine andere Java-IDE verwenden | die JAR oder die einzelnen Java-Dateien | Die JAR als Projektbibliothek hinzufügen oder die vier Quelldateien in den Quellordner kopieren; dafür gibt es keine zusätzlichen IDE-spezifischen Artefakte. |

Die Pakete werden bei einem [GitHub-Release](https://github.com/karlgerd/processing-mk-nds-adt/releases)
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
- **Processing:** Die Processing-ZIP enthält die von Processing erwartete
  Struktur. Den Ordner `mk-nds-adt` aus dem Archiv in den Ordner `libraries`
  im Processing-Sketchbook kopieren und Processing neu starten.
- **VS Code:** Mit der Java-Erweiterung die JAR als referenzierte Bibliothek
  hinzufügen (Java-Projektansicht oder `java.project.referencedLibraries`).

## Kurze Beispiele

Alle Klassen liegen im Paket `mk.nds.adt`. Die Inhalte sind `Object`-Werte; beim
Auslesen kann daher ein passender Typ-Cast nötig sein.

### BinTree

```java
import mk.nds.adt.BinTree;

BinTree baum = new BinTree("Wurzel");
baum.setLeft(new BinTree("Links"));
System.out.println(baum.getLeft().getItem());
```

### DynArray

```java
import mk.nds.adt.DynArray;

DynArray reihung = new DynArray();
reihung.append("A");
reihung.insertAt(1, "B");
System.out.println(reihung.getItem(0));
```

### Queue

```java
import mk.nds.adt.Queue;

Queue schlange = new Queue();
schlange.enqueue("A");
System.out.println(schlange.dequeue());
```

### Stack

```java
import mk.nds.adt.Stack;

Stack stapel = new Stack();
stapel.push("A");
System.out.println(stapel.pop());
```

## Für Entwicklerinnen und Entwickler

Voraussetzung ist ein JDK 11 oder neuer sowie Maven. Im Stammverzeichnis
startet dieser Befehl den Build, führt die Tests aus und erzeugt alle
Veröffentlichungspakete:

```sh
mvn -B verify
```

Die Ergebnisse liegen im Ordner `target/`:

- `mk-nds-adt-2.1.0.jar` – Bibliothek mit Java-11-Bytecode
- `mk-nds-adt-2.1.0-sources.jar` – nur die vier Java-Quelldateien
- `mk-nds-adt-2.1.0-javadoc.jar` – API-Dokumentation
- `mk-nds-adt.zip` – Processing-Bibliothek

Die automatischen Tests liegen unter `src/test/java/`. Processing-Sketches sind
unter `examples/` abgelegt; eigenständige Java-Beispiele liegen unter
`src/examples/java/` und werden nicht in die Bibliotheks-JAR aufgenommen.

### Ein Release erstellen

1. Version in `pom.xml` und `library.properties` aktualisieren; in
   `library.properties` ist `version` eine ganze Zahl und `prettyVersion` die
   lesbare Versionsnummer.
2. Den Eintrag in `CHANGELOG.md` ergänzen und lokal `mvn -B verify` ausführen.
3. Einen Tag im Format `v<Version>` erstellen und nach GitHub übertragen, zum
   Beispiel `v2.1.0`.
4. Der Release-Workflow baut und hängt die Sources-JAR, die Bibliotheks-JAR,
   die Javadoc-JAR sowie die Processing-ZIP an das GitHub-Release an.

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
