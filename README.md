# JPL-TeamQuiz
 Semesterprojekt: Implementierung eines einfachen Games

Multiplayer-Quiz
Programmieren Sie eine Client-Server-Applikation, bei der mehrere Spieler in einem Quiz gegeneinander antreten. Jede Quizfrage bietet jeweils vier Antwortmöglichkeiten A bis C, wobei die schnellste richtige Antwort gewinnt.

Anforderungen
Sie dürfen den gesamten Unicode-Zeichensatz verwenden.
Die Kommunikation zwischen den Clients und dem Server erfolgt direkt über Sockets. Alternativ können Sie auch eine Webanwendung implementieren.
Der Server liest die Textdatei mit den Quizfragen ein. Eine Quizfrage besteht aus einer Frage mit jeweils drei Antwortmöglichkeiten A bis C (wie bei «Wer wird Millionär?»). Diese Textdatei wird Ihnen von Ihrem Dozenten gestellt und ist in verschiedenen Varianten hier zum Download verfügbar.
Die Spieler/Clients bekommen vom Server jeweils gleichzeitig eine Frage mit den vier Antwortmöglichkeiten zugesandt.
Der Spieler/Client mit der schnellsten richtigen Antwort bekommt einen Punkt.
Jeder Spieler/Client wird über den aktuellen Spielstand informiert.
Sicherheitsaspekte und die Behandlung von Verbindungsunterbrüchen können Sie ausser Acht lassen.
Das User Interface kann als Text UI auf der Konsole, als Web- oder als JavaFX Anwendung umgesetzt werden.

Reflexion & Auswertung
Die Bewertung erfolgt nach folgenden Kriterien:

Vollständigkeit der Implementierung bzgl. der geforderten Funktionalitäten (50%)
Korrektheit der Implementierung (Bugs, Abstürze) (10%)
Ordentliches Error-Handling (15%)
Nachvollziehbarkeit und Lesbarkeit des Quellcodes (10%)
Dokumentierung mittels Javadoc und inline comments (15%)
Falls Ihr Projekt nicht den Rahmenbedingungen entspricht (Importierbarkeit ins Eclipse/IntelliJ, Startbarkeit usw.), werden die Dozenten die Bewertung grosszügig reduzieren.

