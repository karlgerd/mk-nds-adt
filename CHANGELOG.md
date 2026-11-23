# Änderungsprotokoll

Dieses Protokoll folgt dem Format [Keep a Changelog](https://keepachangelog.com/de/1.1.0/).
Versionsnummern folgen [Semantic Versioning](https://semver.org/lang/de/).

## [3.0.1] - 2026-11-23

### Behoben

- `DynArray`: Eine strukturelle Änderung (`append`, `insertAt`, `delete`)
  während einer for-each-Schleife löst jetzt zuverlässig eine
  `ConcurrentModificationException` aus. Bisher konnte ein `delete` im
  vorletzten oder letzten Durchlauf die Schleife ohne Fehlermeldung beenden,
  wobei ein Element übersprungen wurde.

### Dokumentation

- README: Abschnitt zur for-each-Schleife über eine `DynArray` mit der
  Unterscheidung zwischen strukturellen Änderungen und `setItem`.
- README: for-each-Schleife mit primitiver Schleifenvariable
  (`for (int z : zahlen)`) bei `DynArray<Integer>`.
- README: Ohne Angabe des Inhaltstyps ist beim Auslesen für Rechnen,
  Vergleichen und Zuweisen immer ein Typ-Cast nötig.

## [3.0.0] - 2026-11-11

Erste Veröffentlichung der Bibliothek.

### Enthalten

- Die Klassen `DynArray`, `Stack`, `Queue` und `BinTree` im Paket
  `mk.nds.adt` mit den Operationen und dem Verhalten gemäß den Ergänzenden
  Hinweisen für das Fach Informatik (Neufassung, Stand Juni 2025).
- Generische Inhaltstypen (`DynArray<String>`, `Stack<Integer>` usw.); die
  Nutzung ohne Typangabe ist weiterhin möglich.
- `DynArray` auf Basis einer statischen Reihung mit interner Vergrößerung;
  iterierbar mit for-each-Schleife, Absicherung gegen Einfügen und Löschen
  während des Durchlaufens.
- `Stack` und `Queue` als verkettete Listen mit Zugriff in konstanter Zeit.
- `BinTree` als rekursive Struktur.
- Einheitliche Ausnahmen mit deutschen Fehlermeldungen bei unzulässigen
  Aufrufen.
- JUnit-5-Tests für alle vier Klassen.
- Java-Beispiele und Processing-Beispiel-Sketches.
- Maven-Build für Java 11 mit Bibliotheks-JAR, Sources-JAR, Javadoc-JAR und
  Processing-ZIP sowie GitHub-Actions-Workflows für Prüfung und Releases.
- MIT-Lizenz (`LICENSE`); das PDF des Niedersächsischen Kultusministeriums ist
  ausdrücklich von der Lizenz ausgenommen.
