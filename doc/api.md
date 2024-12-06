# Die von dem REST zur Verfügung gestellten Ressourcen und die dazugehörigen Verben sind folgende:

## Um einen neuen Benutzer anzulegen kann folgende Ressource verwendet werden:

```
POST http://domain/User

Content-Type: application/json & application/XML
Accept: application/json & application/XML

Beispiel JSON-Anfrage:

{
    "USER-CREATION": {
        "username": "test",
        "password": "test"
    }
}

Antwort vom Server mit success code
403 Forbidden, falls Benutzername bereits vorhanden.
201 Created, falls Benutzer neu angelegt.
HTTP/1.1. 403 Forbidden oder 201 Created
```
## Um einen vorhanden Benutzer einzuloggen kann folgende Ressource verwendet werden:

```
POST http://domain/Login

Content-Type: application/json & application/XML
Accept: application/json & application/XML


Beispiel JSON-Anfrage:
{
    "USER-LOGIN": {
        "username": "test",
        "password": "test"
    }
}

Antwort vom Server mit success code
403 Forbidden, falls Benutzername oder Passwort falsch.
200 Ok, falls Benutzer erfolgreich eingeloggt.
HTTP/1.1. 403 Forbidden oder 200 Ok
```

## Um alle Serien des eingeloggten Benutzers zu bekommen kann folgende Ressource verwendet werden:

```
GET http://domain/User/{usersname}/Series

Produces: application/json & application/XML

GET deswegen, weil dies als lesende Operation gedacht ist und keine Änderung an
den Serien vorgenommen wird.

Gedacht als Ressource um dem eingeloggten User alle seine Serien zu zeigen.

Dennoch ähnlicher Aufbau wie die Suche nach Serien von einem Bestimmten User.
Anfrage ergibt sich aus dem username in der Ressource.

Beispielantwort JSON:
[
    {
        "title": "Dark",
        "numberOfSeasons": 3,
        "genre": "Drama",
        "streamedBy": "Netflix",
    }
]
```

## Um eine neue Serie anzulegen oder eine Serie zu ändern kann folgende Ressource verwendet werden:

```
POST http://domain/User/{usersname}/Series

Content-Type: application/json & application/XML
Accept: application/json & application/XML
Produces: apllication/json & application/XML

Mittels POST ist es möglich eine neue Serie anzulegen aber auch auf dem Server zu
modifizieren, da der Server entscheidet ob die Serie bereits vorhanden
ist(Vergleicht den Titel der Serien).

Beispiel JSON-Anfrage:
{
    "ADD-OR-EDIT" : {
        "titel" : "Dark",
        "numberOfSeasons" : "8",
        "genre" : "Drama",
        "provider": "Netflix",
        "score" : "good",
        "remark" : "kann man gucken"
    }
}
Antwort vom Server mit success code
201 Created
HTTP/1.1. 201 Created
```
## Um nach spezifischen Serien zu schauen kann folgende Ressource verwendet werden:

```
GET http://domain/User/{usersname}/Search

Content-Type: application/json & application/XML
Accept: application/json & application/XML
Produces: application/json & application/XML

GET, da dies ein lesender Zugriff ist und somit keine Änderung auf der Seite des Servers hevorruft.

Beispiel JSON-Anfrage:

{
    "SEARCH-REQUEST":{
        "genre" : "Drama",
        "provider" : "Netflix",
        "score": "Good"
    }
}

Dementsprechende Beispiel JSON-Antwort:
[
    {
        "title": "Dark",
        "numberOfSeasons": 3,
        "genre": "Drama",
        "streamedBy": "Netflix",
    }
]

Antwort vom Server mit success code
200 OK
HTTP/1.1. 201 OK
```