package it.tutorial;

public class Attivita {
    int id;
    String titolo;
    boolean completata;

    public Attivita(int id, String titolo, boolean completata) {
        this.id = id;
        this.titolo = titolo;
        this.completata = completata;
    }

    public int getId() {
        return id;
    }
    public String getTitolo() {
        return titolo;
    }
    public boolean isCompletata() {
        return completata;
    }
}