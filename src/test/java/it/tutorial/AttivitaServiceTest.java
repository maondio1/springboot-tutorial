package it.tutorial;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AttivitaServiceTest {

    @Test
    void creaAttivitaAggiungeAllaLista() {
        AttivitaService service = new AttivitaService();
        Attivita nuova = service.creaAttivita("Leggere di HTTP");

        assertThat(nuova.titolo).isEqualTo("Leggere di HTTP");
        assertThat(nuova.id).isEqualTo(3);
        assertThat(service.elencoAttivita()).hasSize(3);
    }
}