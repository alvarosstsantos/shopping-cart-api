package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.CarrinhoRepository;
import br.com.letscode.repositories.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;

public class CalculaPrecoTotalCarrinho {
    private final ProdutoRepository produtoRepository;
    private final CarrinhoRepository carrinhoRepository;
    private static CalculaPrecoTotalCarrinho calculaPrecoTotalCarrinho = null;

    public CalculaPrecoTotalCarrinho(ProdutoRepository produtoRepository, CarrinhoRepository carrinhoRepository) {
        this.produtoRepository = produtoRepository;
        this.carrinhoRepository = carrinhoRepository;
    }

    public static CalculaPrecoTotalCarrinho getInstance(ProdutoRepository produtoRepository, CarrinhoRepository carrinhoRepository) {
        if (calculaPrecoTotalCarrinho == null)
            calculaPrecoTotalCarrinho = new CalculaPrecoTotalCarrinho(produtoRepository, carrinhoRepository);

        return calculaPrecoTotalCarrinho;
    }

    public void execute(Long codigoCarrinho) {
        Carrinho carrinho = carrinhoRepository.get(codigoCarrinho);

        List<CalculaPrecoCarrinho> calculadorasDePreco = new ArrayList<CalculaPrecoCarrinho>();
        calculadorasDePreco.add(new CalculaPrecoReferenciaCarrinho(produtoRepository));
        calculadorasDePreco.add(new CalculaTaxaCarrinho(produtoRepository));
        calculadorasDePreco.add(new CalculaFreteCarrinho(produtoRepository));
        calculadorasDePreco.add(new CalculaDescontoCarrinho(produtoRepository));

        calculadorasDePreco.forEach(calculaPrecoCarrinho -> calculaPrecoCarrinho.calcular(carrinho));
    }
}
