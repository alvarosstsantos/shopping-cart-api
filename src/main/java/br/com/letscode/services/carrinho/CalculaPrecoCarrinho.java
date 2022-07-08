package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;

import java.math.BigDecimal;

public interface CalculaPrecoCarrinho {
    public BigDecimal calcular(Carrinho carrinho);
}
