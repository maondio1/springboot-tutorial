package it.tutorial;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PagamentoController {
    private final  PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/api/pagamenti")
    public ResponseEntity<Pagamento> creaPagamento(
            @RequestBody NuovoPagamentoRequest pagamento){
        Pagamento nuovo = pagamentoService.creaPagamento(
                pagamento.getAmount(),
                pagamento.getCurrency()
        );
        if (nuovo == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovo);
    }

    @GetMapping("/api/pagamenti")
    public List<Pagamento> elencoPagamento() {
        return pagamentoService.elencoPagamento();
    }

    @GetMapping("/api/pagamenti/{id}")
    public ResponseEntity<Pagamento> pagamento(@PathVariable int id) {
        Pagamento trovato = pagamentoService.trovaPerId(id);
        if (trovato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trovato);
    }

    @PostMapping("/api/pagamenti/{id}/autorizzazione")
    public ResponseEntity<Pagamento> autorizza(@PathVariable int id) {
        try {
            Pagamento autorizzato = pagamentoService.autorizza(id);

            if (autorizzato == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(autorizzato);

        } catch (IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/api/pagamenti/{id}/annullamento-autorizzazione")
    public ResponseEntity<Pagamento> annullaAutorizzazione(@PathVariable int id) {
        try {
            Pagamento annullato = pagamentoService.annullaAutorizzazione(id);

            if (annullato == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(annullato);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping("/api/pagamenti/{id}/cattura-pagamento")
    public ResponseEntity<Pagamento> cattura(@PathVariable int id) {
        try {
            Pagamento catturato = pagamentoService.cattura(id);

            if (catturato == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(catturato);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}