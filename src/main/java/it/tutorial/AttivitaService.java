package it.tutorial;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttivitaService {
    private List<Attivita> elenco = new ArrayList<>(List.of(
            new Attivita(1, "Studiare Spring", false),
            new Attivita(2, "Fare un esercizio", true)
    ));

    public List<Attivita> elencoAttivita() {
        return elenco;
    }

    public Attivita trovaPerID(int id) {
        for (Attivita elemento : elenco) {
            if (elemento.id == id)  {
                return elemento;
            }
        }
        return null;
    }

    public Attivita creaAttivita(String titolo) {
        if (titolo == null || titolo.isBlank()) {
            return null;
        }

        Attivita nuova = new Attivita(elenco.size() + 1, titolo, false);
        elenco.add(nuova);
        return nuova;
    }
}
