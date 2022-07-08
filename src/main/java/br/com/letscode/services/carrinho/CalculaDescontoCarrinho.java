package br.com.letscode.services.carrinho;


import br.com.letscode.enums.TipoProduto;
import br.com.letscode.models.Carrinho;
import br.com.letscode.models.Produto;
import br.com.letscode.repositories.ProdutoRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalculaDescontoCarrinho implements CalculaPrecoCarrinho {
    private final ProdutoRepository produtoRepository;
    private static final Map<TipoProduto, BigDecimal> descontos = new HashMap<TipoProduto, BigDecimal>();

    public CalculaDescontoCarrinho(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;

        descontos.put(TipoProduto.AUTOMOTIVO, BigDecimal.valueOf(0.005));
    }

    @Override
    public BigDecimal calcular(Carrinho carrinho) {
        BigDecimal descontoTotal = BigDecimal.ZERO;

        for (Map.Entry<Long, Integer> item: carrinho.getItens().entrySet()) {
            Produto produto = produtoRepository.get(item.getKey());

            for (Map.Entry<TipoProduto, BigDecimal> desconto: descontos.entrySet()) {
                if (desconto.getKey().equals(produto.getTipo())) {
                    descontoTotal = descontoTotal.add(produto.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getValue())).multiply(desconto.getValue()));
                }
            }
        }

        carrinho.setDesconto(carrinho.getDesconto().add(descontoTotal));
        carrinho.setTotal(carrinho.getTotal().subtract(descontoTotal));
        return descontoTotal;
    }
}

