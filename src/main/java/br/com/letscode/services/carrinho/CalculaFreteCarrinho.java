package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.ProdutoRepository;

import java.math.BigDecimal;
import java.util.Map;

public class CalculaFreteCarrinho implements CalculaPrecoCarrinho {
    private final ProdutoRepository produtoRepository;

    public CalculaFreteCarrinho(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public BigDecimal calcular(Carrinho carrinho) {
        BigDecimal freteTotal = BigDecimal.ZERO;

        for (Map.Entry<Long, Integer> item: carrinho.getItens().entrySet()) {
            BigDecimal freteUnitario = produtoRepository.get(item.getKey()).getTipo().getFrete();
            freteTotal = freteTotal.add(freteUnitario.multiply(BigDecimal.valueOf(item.getValue())));
        }

        carrinho.setTotal(carrinho.getTotal().add(freteTotal));
        carrinho.setFrete(carrinho.getFrete().add(freteTotal));
        return freteTotal;
    }
}
