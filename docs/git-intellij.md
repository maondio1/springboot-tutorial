# Git e IntelliJ IDEA

## Git

Git registra la storia delle modifiche ai file. Il **working tree** contiene le modifiche locali; lo **stage** è l'insieme dei cambiamenti scelti per il prossimo commit; un **commit** è una fotografia nominata della storia. Un **branch** è una linea di lavoro indipendente. Un remote è una copia ospitata altrove, per esempio su un server Git.

Comandi da conoscere, eseguiti nel terminale alla radice del progetto:

```text
git status
git diff
git add percorso/del/file
git commit -m "Descrizione breve"
git log --oneline

git switch -c nome-branch

git switch nome-branch
```

Leggi l'output prima di ogni comando che registra modifiche. `git add` prepara file allo stage; non li pubblica su Internet.

## IntelliJ IDEA

La vista **Project** mostra cartelle e file; l'editor mostra il file selezionato; la finestra **Run** mostra l'output dell'applicazione. Le frecce verdi avviano applicazione o test. La finestra Maven permette di ricaricare il progetto e lanciare obiettivi.

Se non trovi una voce di menu, usa **Find Action** (`Ctrl+Shift+A` su Windows/Linux, `Cmd+Shift+A` su macOS) e cerca l'azione per nome. Quando compaiono errori rossi, leggi prima il messaggio completo e la prima riga del tuo codice indicata nello stack trace.

