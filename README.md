# Webtechnologien Projekt SS22

  ## Testen der REST-Schnittstelle
    Getestet wird mit der "RestTest.java"-Datei in "steam/src/test/java/de/hsh".
    Diese Klasse verwendet die Methoden welche der Jersey-Client zur Verfügung stellt.

    ### Das Testing selbst läuft folgendermaßen ab:
    Für jede in der REST-Schnittstelle definierten Ressource haben wir zwei Methoden geschrieben, welche jeweils eine Testanfrage und -antwort mit JSON oder XML erstellen und das Ergebnis außerdem auf die Konsole ausgeben.

    Innerhalb der Methoden werden mittels der Xml/JsonMapper Klassen zunächst geeignete JSON- bzw. XML-Strings mit den Testdaten erstellt.
    Hierfür existieren zudem jeweils eigene Model-Klassen, damit sich die Daten auf JSON/XML-Dateien abbilden lassen.

    Danach wird jedes Mal eine Response erstellt und an den Client geschickt. Darin enthalten sind der jeweilige Responsecode und ggf. die angefragten JSON- bzw. XML-Daten sollten diese vorhanden sein(User können nämlich auch noch keine Serien besitzen somit wäre der JSON- bzw. XML-Datensatz leer.).
    Beim Ausführen der RestTest.java Klasse, werden dann nacheinander folgende Methoden zum Testen aufgerufen:

    * regTestJson/Xml();
      * Diese Methoden testen das Registrieren eines Benutzers, legen diese an giben dann den entsprechenden Response-Code zurürck.
    * logTestJson/Xml();
      * Diese Methoden testen das Einloggen (sowohl erfolgreich als auch fehlgeschlagen) von Benutzern. Dabei ist ein Benutzer willkürlich gewählt damit der Login-Versuch fehlschlägt und auch dies wird mit einem 403-FORBIDDEN beantwortet. Der andere Benutzer ist bereits angelegt und wird erfolgreich eingeloggt
    * addOrEditTestJson/Xml();
      * In diesen Methoden testen wir das Anlegen bzw. das Editieren von Serien. Hier ist zu beachten, dass das Backend entscheidet ob eine Serie bereits vorhanden ist und somit entscheidet, ob eine Serie neu angelegt oder nur überarbeitet wird.
    * getAllSeriesOfUserTestJson/Xml();
      * Diese Methoden simulieren das Aufrufen der Home-Seite eines Benutzers und giben alle Serien zurück die dem Benutzer zugeordnet sind. Antwort enthält einen 200-OK Responsecode und die Serien als JSON- bzw. XML-Datei.
      Auch hier gibt es jeweils einen erfolgreichen und einen fehlgeschlagenen Test.
    * searchTestJson/Xml();
      * Diese Methode simuliert das Suchen nach einer Serie. Hier ist auch wichtig, dass das Backend entscheidet ob die Suchkriterien in solch einer Kombination zu einer erfolgreichen Suche führen. Somit kann die Antwort auch leere JSON- bzw. XML-Daten zurückgeben.

    In jeder Methode wird zum Schluss die Response des Servers ausgegeben um nachvollziehen zu können, welche Antworten die REST-Schnittstelle zurückgibt und zu überprüfen ob das vorher definierte Verhalten auch eingehalten wird.


  ## Quellen für verwendete Fonts und Bilder
    - jost-700.ttf und jost-regular.ttf: https://fonts.google.com/specimen/Jost?query=jost, zuletzt abgerufen am 15.05.2022, 13:06 Uhr
    - poi.gif: https://imgur.com/gallery/SVmyEkI, zuletzt abgerufen am 15.05.2022, 13:06 Uhr
    - westworld.gif: https://gfycat.com/newzealouscarp, zuletzt abgerufen am 15.05.2022, 13:06 Uhr
    - spongebob.gif: https://nickelodeon.fandom.com/de/wiki/SpongeBob_Schwammkopf_(Serie)?file=SpongeBob_Intro.gif, zuletzt abgerufen am 15.05.2022, 13:06 Uhr
    - tbbt.gif: https://giphy.com/gifs/cbs-big-bang-theory-3o6fJ2WggvBDJv7ohG, zuletzt abgerufen am 15.05.2022, 13:06 Uhr
