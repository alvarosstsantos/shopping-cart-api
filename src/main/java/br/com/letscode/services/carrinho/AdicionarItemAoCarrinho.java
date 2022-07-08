package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.CarrinhoRepository;

import java.util.Objects;

public class AdicionarItemAoCarrinho {
    private final CarrinhoRepository carrinhoRepository;
    private static AdicionarItemAoCarrinho adicionarItemAoCarrinho = null;

    public AdicionarItemAoCarrinho(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    public static AdicionarItemAoCarrinho getInstance(CarrinhoRepository carrinhoRepository) {
        if (adicionarItemAoCarrinho == null)
            adicionarItemAoCarrinho = new AdicionarItemAoCarrinho(carrinhoRepository);

        return adicionarItemAoCarrinho;
    }

    public void execute(Long codigoCarrinho, Long codigoProduto, Integer quantidadeProduto) {
        Carrinho carrinho = carrinhoRepository.get(codigoCarrinho);

        if (Objects.isNull(carrinho)) {
            carrinho = new Carrinho();
            carrinho.getItens().put(codigoProduto,quantidadeProduto);
            carrinhoRepository.save(carrinho);
            return;
        }

        if (carrinho.getItens().containsKey(codigoProduto)) {
            carrinho.getItens().replace(codigoProduto, quantidadeProduto);
        } else {
            carrinho.getItens().put(codigoProduto,quantidadeProduto);
        }

        carrinhoRepository.update(carrinho);
    }
}

