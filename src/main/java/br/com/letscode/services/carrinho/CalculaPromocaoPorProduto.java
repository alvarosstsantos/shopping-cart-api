package br.com.letscode.services.carrinho;

import br.com.letscode.models.Carrinho;
import br.com.letscode.models.Produto;

import java.math.BigDecimal;
import java.util.Map;

public class CalculaPromocaoPorProduto extends CalculaPrecoPorProdutoDecorator {
    private static final double DESCONTO_PRODUTO_AUTOMOTIVO = 0.005;

    public CalculaPromocaoPorProduto(CalculaPrecoPorProdutoInterface calculaPrecoPorProdutoInterface) {
        super(calculaPrecoPorProdutoInterface);
    }

    @Override
    public Map<String, BigDecimal> calcular() {
        Map<String, BigDecimal> precoPorProduto = super.calcular();
        Carrinho carrinho = super.getCarrinho();

        return precoPorProduto;
    }

}
