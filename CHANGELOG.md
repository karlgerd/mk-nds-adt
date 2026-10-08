# Änderungsprotokoll

Dieses Protokoll folgt dem Format [Keep a Changelog](https://keepachangelog.com/de/1.1.0/).
Versionsnummern folgen [Semantic Versioning](https://semver.org/lang/de/).

## [Unveröffentlicht]

### Geändert

- Repository von `processing-mk-nds-adt` in `mk-nds-adt` umbenannt; alle
  Verweise auf die alte URL wurden angepasst.
- Dokumentation (README, Metadaten) beschreibt die Bibliothek nun als
  allgemeine Java-Bibliothek, die zusätzlich auch in Processing nutzbar ist.

## [2.1.0] - 2026-10-08

### Hinzugefügt

- Maven-Build für Java 11, Tests, Sources-JAR, Javadoc-JAR und Processing-ZIP.
- JUnit-5-Tests für die vier ADT-Klassen.
- GitHub-Actions-Workflows für Prüfung und Releases.
- Deutsche Anleitungen für Java- und Processing-Nutzende.
- MIT-Lizenz (`LICENSE`); das PDF des Niedersächsischen Kultusministeriums ist
  ausdrücklich von der Lizenz ausgenommen.

### Geändert

- Java-Quellen und Java-Beispiele in getrennte Standardverzeichnisse verschoben.
- Processing-Metadaten vervollständigt und fehlerhafte Umlaute korrigiert.
- Javadoc-Kommentare und interne Elementklassen bereinigt.

### Entfernt

- Eingecheckte JAR-, Javadoc-, ZIP- und IDE-Build-Artefakte; diese werden nun
  beim Build erzeugt.
