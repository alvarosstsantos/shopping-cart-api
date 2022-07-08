package br.com.letscode.enums;

import java.math.BigDecimal;

public enum TipoProduto {
    ALIMENTACAO (new BigDecimal("0.00"), new BigDecimal("0.00")),
    HIGIENE (new BigDecimal("0.00"), new BigDecimal("1.00")),
    AUTOMOTIVO (new BigDecimal("5.00"), new BigDecimal("25.00"));

    private final BigDecimal taxa;
    private final BigDecimal frete;

    TipoProduto(BigDecimal taxa, BigDecimal frete) {
        this.taxa = taxa;
        this.frete = frete;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }
}
