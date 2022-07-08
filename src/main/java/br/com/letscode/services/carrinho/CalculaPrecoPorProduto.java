package br.com.letscode.services.carrinho;

import br.com.letscode.models.Carrinho;
import br.com.letscode.models.Produto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalculaPrecoPorProduto implements CalculaPrecoPorProdutoInterface {
    private final Carrinho carrinho;

    public CalculaPrecoPorProduto(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public Carrinho getCarrinho() {
        return this.carrinho;
    }

    @Override
    public  Map<String, BigDecimal> calcular() {
        Map<String, BigDecimal> precoPorProduto = new HashMap<String, BigDecimal>();

        return precoPorProduto;
    }
}
