package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.ProdutoRepository;

import java.math.BigDecimal;
import java.util.Map;

public class CalculaPrecoReferenciaCarrinho implements CalculaPrecoCarrinho {
    private final ProdutoRepository produtoRepository;

    public CalculaPrecoReferenciaCarrinho(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public BigDecimal calcular(Carrinho carrinho) {
        BigDecimal totalReferencia = BigDecimal.ZERO;

        for (Map.Entry<Long, Integer> item: carrinho.getItens().entrySet()) {
            BigDecimal precoUnitario = produtoRepository.get(item.getKey()).getPrecoUnitario();
            totalReferencia = totalReferencia.add(precoUnitario.multiply(BigDecimal.valueOf(item.getValue())));
        }

        carrinho.setTotal(carrinho.getTotal().add(totalReferencia));
        return totalReferencia;
    }
}
