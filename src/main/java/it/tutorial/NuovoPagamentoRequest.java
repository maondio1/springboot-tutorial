package it.tutorial;

import java.math.BigDecimal;

public class NuovoPagamentoRequest {
    private BigDecimal amount;
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private String currency;
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
