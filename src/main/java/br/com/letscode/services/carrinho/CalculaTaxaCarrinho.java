package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.ProdutoRepository;

import java.math.BigDecimal;
import java.util.Map;

public class CalculaTaxaCarrinho implements CalculaPrecoCarrinho {
    private final ProdutoRepository produtoRepository;

    public CalculaTaxaCarrinho(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public BigDecimal calcular(Carrinho carrinho) {
        BigDecimal taxaTotal = BigDecimal.ZERO;

        for (Map.Entry<Long, Integer> item: carrinho.getItens().entrySet()) {
            BigDecimal taxaUnitario = produtoRepository.get(item.getKey()).getTipo().getTaxa();
            taxaTotal = taxaTotal.add(taxaUnitario.multiply(BigDecimal.valueOf(item.getValue())));
        }

        carrinho.setTaxa(carrinho.getTaxa().add(taxaTotal));
        carrinho.setTotal(carrinho.getTotal().add(taxaTotal));
        return taxaTotal;
    }
}

