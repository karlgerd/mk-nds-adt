# Mitwirken

Fehlerberichte und Verbesserungsvorschläge sind willkommen. Bitte beschreibe
bei einem Fehler die betroffene ADT-Klasse, die erwartete Vorgabe und einen
kleinen nachvollziehbaren Beispielsfall.

Vor einem Pull Request:

1. Änderungen möglichst klein halten und die öffentlichen Schnittstellen sowie
   das Paket `mk.nds.adt` nicht ohne fachliche Abstimmung ändern.
2. Verhalten und Bezeichnungen der Operationen an den Ergänzenden Hinweisen
   des Niedersächsischen Kultusministeriums ausrichten.
3. Bezeichner (Klassen, Methoden, Variablen) auf Englisch wählen; Kommentare,
   Javadoc und Fehlermeldungen auf Deutsch verfassen.
4. Bei unzulässigen Aufrufen die Ausnahmen gemäß der Tabelle „Verhalten bei
   Fehlern“ in der README verwenden.
5. Tests für geändertes Verhalten ergänzen.
6. `mvn -B verify` ausführen und sicherstellen, dass alle Tests erfolgreich
   sind.
7. In der Beschreibung Änderungen und noch offene Entscheidungen klar
   benennen.

Mit einem Beitrag erklärst du dich einverstanden, dass er unter der
[MIT-Lizenz](LICENSE) dieses Repositories veröffentlicht wird.
