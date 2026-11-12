# Laboratorio Spring Boot: da zero a una piccola API

Benvenuta/o! Questa cartella è un tutorial pratico per imparare le basi di Java e Spring Boot. Non serve conoscere già i termini: l'assistente segue le regole di [AGENTS.md](AGENTS.md) e spiega ogni passaggio. Il progetto usa Java 21, Maven e Spring Boot 4.0.9.

## Obiettivo

Alla fine avrai costruito una piccola API per gestire una lista di attività (todo), capito come una richiesta HTTP arriva al codice Java e imparato a verificare il comportamento con test e Git.

## Avvio in IntelliJ IDEA

1. Apri IntelliJ IDEA e scegli **Open**; seleziona questa cartella, quella che contiene `pom.xml`.
2. Se IntelliJ chiede come aprire il progetto, scegli di aprirlo come progetto. Attendi la sincronizzazione Maven (potrebbe servire Internet la prima volta).
3. In **File > Project Structure** controlla che il Project SDK sia un JDK 21. Se non è disponibile, installa/seleziona un JDK 21 e poi torna qui.
4. Apri `src/main/java/it/tutorial/TutorialApplication.java` e premi la freccia verde accanto a `main`, quindi **Run**.
5. Nel browser visita <http://localhost:8080/api/saluto>. Dovresti leggere: `Ciao! Il laboratorio Spring Boot è pronto.`
6. Per fermare l'applicazione, premi il quadrato rosso nella finestra **Run**.

In alternativa, nel terminale integrato dalla cartella del progetto esegui `./mvnw spring-boot:run` se in seguito aggiungi Maven Wrapper; al momento usa `mvn spring-boot:run` se Maven è installato. Su Windows il wrapper, quando presente, si avvia con `mvnw.cmd`.

## Mappa del progetto

- `pom.xml`: descrive il progetto e le librerie gestite da Maven.
- `src/main/java`: codice dell'applicazione.
- `src/test/java`: test automatici.
- `TutorialApplication.java`: punto di avvio.
- `SalutoController.java`: primo endpoint HTTP.
- `docs/`: schede introduttive.

## Percorso a tappe

Affronta una tappa per volta. Prima prova l'esercizio; poi usa l'indizio e chiedi al tutor la soluzione solo se ti serve.

### 0. Orientarsi e avviare

**Obiettivo:** distinguere sorgenti, configurazione e test; avviare il programma.

**Esercizio:** individua il metodo `main`, la classe che gestisce `/api/saluto` e il file che descrive le dipendenze. Spiega a parole cosa pensi faccia ciascuno.

**Verifica:** avvia l'app da IntelliJ e visita l'URL del saluto. Guarda la finestra Run e trova la riga che indica che il server è partito.

### 1. Java: variabili, metodi e classi

**Obiettivo:** capire che una classe definisce un tipo di oggetto e che un metodo descrive un'operazione.

**Esercizio:** cambia il testo restituito dal saluto. Aggiungi un secondo metodo Java (per ora non collegato a una rotta) che costruisca un saluto personalizzato usando un parametro `String nome`.

**Verifica:** avvia l'app e controlla il nuovo testo. Poi chiedi al tutor di aiutarti a richiamare il metodo personalizzato senza duplicare la logica.

### 2. HTTP, API ed endpoint

**Obiettivo:** riconoscere richiesta, risposta, metodo, URL e codice di stato.

**Esercizio:** aggiungi un endpoint `GET /api/info` che restituisca una breve descrizione del tutorial.

**Verifica:** apri l'URL nel browser. Con `curl -i http://localhost:8080/api/info` osserva status e intestazioni; `GET` è il metodo della richiesta, `/api/info` è il percorso e il testo è il corpo della risposta.

### 3. Oggetti e collezioni

**Obiettivo:** modellare dati con una classe e raccogliere più elementi in una lista.

**Esercizio:** crea una classe `Attivita` con identificativo, titolo e stato completato. Crea alcuni esempi in memoria e spiega cosa rappresentano i campi.

**Verifica:** scrivi un test Java per controllare i valori di un oggetto appena creato. Non aggiungere un database: i dati devono restare semplici e temporanei.

### 4. API REST e JSON

**Obiettivo:** restituire oggetti e liste come JSON e capire i parametri di percorso.

**Esercizio:** esponi `GET /api/attivita` per leggere la lista e `GET /api/attivita/{id}` per leggere un elemento. Se un ID non esiste, restituisci uno status appropriato.

**Verifica:** usa browser o `curl -i` per vedere la risposta JSON e il codice HTTP; prova sia un ID valido sia uno sconosciuto.

### 5. Aggiungere dati e validare input

**Obiettivo:** distinguere dati nel body da parametri nell'URL e usare `POST`.

**Esercizio:** implementa `POST /api/attivita` con un JSON contenente il titolo. Rifiuta un titolo vuoto e restituisci l'attività creata.

**Verifica:** usa IntelliJ HTTP Client creando un file `requests.http`, oppure `curl`, per inviare JSON. Prova un titolo valido e uno vuoto; osserva gli status code.

### 6. Separare le responsabilità

**Obiettivo:** capire perché un controller non dovrebbe contenere tutta la logica.

**Esercizio:** sposta gestione e regole della lista in una classe `AttivitaService`; il controller riceve il servizio tramite dependency injection.

**Verifica:** esegui i test e aggiungi un test del servizio che non avvii il server web.

### 7. Git e piccoli cambiamenti

**Obiettivo:** capire working tree, stage e commit.

**Esercizio:** esamina le modifiche con `git status`, aggiungi solo i file dell'esercizio allo stage, poi crea un commit con messaggio descrittivo. Se Git non è configurato, chiedi al tutor di spiegare identità e configurazione locale prima di impostarle.

**Verifica:** controlla `git diff` prima dello stage e `git log -1 --oneline` dopo il commit. Crea un branch per il prossimo esercizio e torna al branch iniziale.

## Test automatici

Il progetto include un test d'integrazione iniziale. Da IntelliJ apri `SalutoControllerTest.java` e premi la freccia verde accanto al test. Oppure, nel terminale alla radice:

```powershell
mvn test
```

Un test verde significa che l'aspettativa scritta nel test è stata soddisfatta. Se il comando `mvn` non è riconosciuto, configura Maven in IntelliJ oppure chiedi al tutor di aggiungere il Maven Wrapper.

## Regole del laboratorio

- Lavora su una tappa per volta; conserva il comportamento già funzionante.
- Prima di copiare codice, prova a prevedere cosa farà.
- Se qualcosa non funziona, copia il messaggio d'errore e indica quale azione lo ha prodotto.
- Chiedi al tutor di spiegare un concetto, dare un indizio, fare una revisione o guidarti dentro IntelliJ.

## Riferimenti essenziali

- [HTTP in breve](docs/http-api.md)
- [Java e programmazione a oggetti](docs/java-oop.md)
- [Git e IntelliJ](docs/git-intellij.md)
