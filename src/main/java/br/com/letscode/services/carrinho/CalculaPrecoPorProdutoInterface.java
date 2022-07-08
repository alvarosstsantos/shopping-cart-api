package br.com.letscode.services.carrinho;

import br.com.letscode.models.Carrinho;
import br.com.letscode.models.Produto;

import java.math.BigDecimal;
import java.util.Map;

public interface CalculaPrecoPorProdutoInterface {
    public Map<String, BigDecimal> calcular();
    public Carrinho getCarrinho();
}
