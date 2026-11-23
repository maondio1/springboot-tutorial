package it.tutorial;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Pagamento {

    @Id
    int id;
    BigDecimal amount;
    String currency;
    String status;

    protected Pagamento() {
    }

    public Pagamento(int id, BigDecimal amount, String currency, String status) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
