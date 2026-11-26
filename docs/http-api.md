# HTTP, API ed endpoint

## HTTP

HTTP è un protocollo: un insieme di regole con cui un client (per esempio browser o programma) invia richieste a un server e riceve risposte. Una richiesta contiene un metodo, un URL e spesso intestazioni (header) e un corpo (body). La risposta contiene uno status code, header e un eventuale body.

## API ed endpoint

Un'API è un insieme di operazioni che un programma mette a disposizione. Un endpoint è un punto specifico dell'API, identificato almeno da metodo e percorso: per esempio `GET /api/saluto`.

Metodi comuni:

* `GET`: leggere dati.
* `POST`: inviare dati o creare una risorsa.
* `PUT`/`PATCH`: sostituire o modificare dati.
* `DELETE`: eliminare dati.

Status comuni: `200 OK` (richiesta riuscita), `201 Created` (risorsa creata), `400 Bad Request` (richiesta non valida), `404 Not Found` (risorsa assente), `500 Internal Server Error` (errore non gestito sul server).

## JSON

JSON è un formato testuale per rappresentare dati strutturati. Esempio: `{"titolo":"Studiare HTTP","completata":false}`. Nelle API si invia spesso nel body e si riceve nella risposta.

Nel progetto, `@RestController` indica a Spring che la classe gestisce richieste web e restituisce dati. `@GetMapping("/api/saluto")` associa il metodo Java a una richiesta GET su quel percorso.



\## Pagamenti (simulazione)



\- `POST /api/pagamenti`: crea un pagamento.

\- `GET /api/pagamenti`: restituisce la lista.

\- `GET /api/pagamenti/{id}`: cerca un pagamento per ID.

\- `POST /api/pagamenti/{id}/autorizzazione`: simula l'autorizzazione.

\- `POST /api/pagamenti/{id}/annullamento-autorizzazione`: simula l'annullamento.

\- `POST /api/pagamenti/{id}/cattura-pagamento`: simula la capture.



Le operazioni modificano i dati salvati localmente; non contattano un PSP o una banca.

