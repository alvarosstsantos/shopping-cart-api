package br.com.letscode.services.carrinho;

import br.com.letscode.models.Carrinho;
import br.com.letscode.models.Produto;

import java.math.BigDecimal;
import java.util.Map;

public abstract class CalculaPrecoPorProdutoDecorator implements CalculaPrecoPorProdutoInterface {
    private final CalculaPrecoPorProdutoInterface calculaPrecoPorProdutoInterface;

    public CalculaPrecoPorProdutoDecorator(CalculaPrecoPorProdutoInterface calculaPrecoPorProdutoInterface) {
        this.calculaPrecoPorProdutoInterface = calculaPrecoPorProdutoInterface;
    }

    @Override
    public Map<String, BigDecimal> calcular() {
        return calculaPrecoPorProdutoInterface.calcular();
    }

    @Override
    public Carrinho getCarrinho() {
        return calculaPrecoPorProdutoInterface.getCarrinho();
    }

}
