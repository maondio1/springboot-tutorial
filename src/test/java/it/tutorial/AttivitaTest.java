package it.tutorial;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AttivitaTest {

    @Test
    void creaEsempiInMemoria() {
        Attivita prima = new Attivita(1, "Studiare Spring", false);
        Attivita seconda = new Attivita(2, "Fare un esercizio", true);
        List<Attivita> elenco = List.of(prima, seconda);
        assertThat(prima.id).isEqualTo(1);
        assertThat(prima.titolo).isEqualTo("Studiare Spring");
        assertThat(prima.completata).isFalse();
    }
}