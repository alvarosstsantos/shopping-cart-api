package br.com.letscode.enums;

import java.math.BigDecimal;

public enum TipoLivro {
    TERROR (new BigDecimal("2.00")),
    CULINARIA (new BigDecimal("1.00")),
    DRAMA (new BigDecimal("5.00"));

    private final BigDecimal valor;

    TipoLivro(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
