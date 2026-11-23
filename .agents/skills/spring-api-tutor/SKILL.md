---
name: spring-api-tutor
description: "Guida lo studente quando chiede di aggiungere, modificare o verificare un endpoint REST nel progetto tutorial Spring Boot."
---

# Esercizi sugli endpoint Spring

Usa questa skill per lavorare sugli endpoint REST di questo progetto. Per le regole generali di tutoraggio, segui `AGENTS.md`; questa skill descrive soltanto il flusso specifico per un endpoint.

## Prima di intervenire

1. Leggi la tappa pertinente in `README.md` e i file coinvolti, in particolare controller, service, eventuale DTO, test e `requests.http`. Se l'attività non è descritta nel README, chiarisci il risultato richiesto senza inventare una nuova tappa.
2. Riassumi il comportamento osservabile richiesto: metodo HTTP, percorso, eventuali dati inviati e risposta attesa.
3. Mantieni la modifica adatta a chi sta imparando. Non aggiungere database, dipendenze o configurazioni che l'esercizio non richiede.

## Guida allo studente

- Se lo studente vuole svolgere l'esercizio, spiega il concetto necessario e proponi un solo primo passo o un indizio. Lascia che provi prima di mostrare la soluzione completa.
- Se chiede esplicitamente a Codex di implementare la modifica, fai una patch piccola e coerente con il progetto, poi spiega cosa è cambiato e perché.
- Segui le responsabilità già usate nel progetto: il controller gestisce la richiesta HTTP e il service contiene la logica della lista e delle attività.
- Preserva gli endpoint e i comportamenti esistenti che non fanno parte della richiesta.

## Verifica con Insomnia o HTTP Client

- Indica il metodo, l'URL, gli header e il body necessari per provare l'endpoint.
- Usa `http://localhost:8080` come base URL quando l'applicazione gira in locale; non descrivere Insomnia e l'app come sistemi remoti se sono sullo stesso computer.
- Spiega il codice di stato e il corpo attesi. Per esempio, `200` indica una lettura riuscita, `201` una creazione, `400` dati di input non validi e `404` una risorsa non trovata.
- Segui la verifica prevista nella tappa README o richiesta dallo studente. Se il risultato non coincide, usa il messaggio e la risposta osservati per restringere la causa prima di proporre una correzione.

Concludi con i file toccati, la verifica effettivamente svolta e il prossimo concetto o passo dell'esercizio.
