package br.com.letscode.services.carrinho;

import br.com.letscode.models.Carrinho;

import java.math.BigDecimal;
import java.util.Map;

public class CalculaTaxaPorProduto extends CalculaPrecoPorProdutoDecorator {
    public CalculaTaxaPorProduto(CalculaPrecoPorProdutoInterface calculaPrecoPorProdutoInterface) {
        super(calculaPrecoPorProdutoInterface);
    }

    @Override
    public Map<String, BigDecimal> calcular() {
        Map<String, BigDecimal> precoPorProduto = super.calcular();
        Carrinho carrinho = super.getCarrinho();

        return precoPorProduto;
    }

}
