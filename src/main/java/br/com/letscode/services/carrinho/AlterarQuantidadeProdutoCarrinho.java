package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.CarrinhoRepository;

public class AlterarQuantidadeProdutoCarrinho {
    private final CarrinhoRepository carrinhoRepository;
    private static AlterarQuantidadeProdutoCarrinho alterarQuantidadeProdutoCarrinho = null;

    public AlterarQuantidadeProdutoCarrinho(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    public static AlterarQuantidadeProdutoCarrinho getInstance(CarrinhoRepository carrinhoRepository) {
        if (alterarQuantidadeProdutoCarrinho == null)
            alterarQuantidadeProdutoCarrinho = new AlterarQuantidadeProdutoCarrinho(carrinhoRepository);

        return alterarQuantidadeProdutoCarrinho;
    }

    public void execute(Long codigoCarrinho, Long codigoProduto, Integer quantidadeProduto) {
        Carrinho carrinho = carrinhoRepository.get(codigoCarrinho);

        carrinho.getItens().replace(codigoProduto, quantidadeProduto);

        carrinhoRepository.update(carrinho);    }
}