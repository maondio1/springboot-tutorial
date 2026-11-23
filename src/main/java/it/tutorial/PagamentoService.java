package it.tutorial;

import org.springframework.stereotype.Service;
import java.util.List;
import java.math.BigDecimal;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento creaPagamento(BigDecimal amount, String currency){
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            return null;
        } else if (currency == null || currency.isBlank()) {
            currency = "EUR";
        }

        Pagamento nuovo = new Pagamento(
                pagamentoRepository.findAll().size() +1,
                amount,
                currency,
                "RICEVUTO"
        );
        pagamentoRepository.save(nuovo);
        return nuovo;
    }

    public List<Pagamento> elencoPagamento() {
        return pagamentoRepository.findAll();
    }

    public Pagamento trovaPerId(int id) {
        return pagamentoRepository.findById(id).orElse(null);
    }
    public Pagamento autorizza(int id) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElse(null);

        if (pagamento == null) {
            return null;
        }

        if (!"RICEVUTO".equals(pagamento.getStatus())) {
            throw new IllegalStateException(
                    "Si puòaccettare solo un pagamento ricevuto"
            );
        }
        pagamento.setStatus("AUTORIZZATO");
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento annullaAutorizzazione(int id) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElse(null);

        if (pagamento == null) {
            return null;
        }

        if (!"AUTORIZZATO".equals(pagamento.getStatus())) {
            throw new IllegalStateException(
                    "Si può annullare solo un pagamento autorizzato"
            );
        }
        pagamento.setStatus("ANNULLATO");
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento cattura(int id) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElse(null);

        if (pagamento == null) {
            return null;
        }

        if (!"AUTORIZZATO".equals(pagamento.getStatus())) {
            throw new IllegalStateException(
                    "Si può catturare solo un pagamento autorizzato"
            );
        }
        pagamento.setStatus("CATTURATO");
        return pagamentoRepository.save(pagamento);
    }
}