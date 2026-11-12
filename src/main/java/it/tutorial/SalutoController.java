package it.tutorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class SalutoController {

    private final AttivitaService attivitaService;

    public SalutoController(AttivitaService attivitaService) {
        this.attivitaService = attivitaService;
    }

    @GetMapping("/api/saluto")
    public String saluta() {
        return salutaNome("Marta");
    }

    public String salutaNome(String nome) {
        return "Ciao, " + nome + "!";
    };

    @GetMapping("/api/info")
    public String informazione() {
        return "Questo  tutorial introduce le basi di Java e Spring Boot";
    }

    @GetMapping("/api/attivita")
    public List<Attivita> elencoAttivita() {
        return attivitaService.elencoAttivita();
    }

    @GetMapping("/api/attivita/{id}")
    public ResponseEntity<Attivita> attivita(@PathVariable int id) {
        Attivita trovata = attivitaService.trovaPerID(id);
        if (trovata == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trovata);
    }

    @PostMapping("/api/attivita")
    public ResponseEntity<Attivita> creaAttivita(
            @RequestBody NuovaAttivitaRequest richiesta) {
        Attivita nuova = attivitaService.creaAttivita(richiesta.getTitolo());
        if (nuova == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuova);
    }
}
