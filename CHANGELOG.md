# Änderungsprotokoll

Dieses Protokoll folgt dem Format [Keep a Changelog](https://keepachangelog.com/de/1.1.0/).
Versionsnummern folgen [Semantic Versioning](https://semver.org/lang/de/).

## [2.1.0] - 2026-10-08

### Hinzugefügt

- Maven-Build für Java 11, Tests, Sources-JAR, Javadoc-JAR und Processing-ZIP.
- JUnit-5-Tests für die vier ADT-Klassen.
- GitHub-Actions-Workflows für Prüfung und Releases.
- Deutsche Anleitungen für Java- und Processing-Nutzende.

### Geändert

- Java-Quellen und Java-Beispiele in getrennte Standardverzeichnisse verschoben.
- Processing-Metadaten vervollständigt und fehlerhafte Umlaute korrigiert.
- Javadoc-Kommentare und interne Elementklassen bereinigt.

### Entfernt

- Eingecheckte JAR-, Javadoc-, ZIP- und IDE-Build-Artefakte; diese werden nun
  beim Build erzeugt.
