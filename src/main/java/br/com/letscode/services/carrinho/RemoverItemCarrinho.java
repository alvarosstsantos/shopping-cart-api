package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.CarrinhoRepository;

public class RemoverItemCarrinho {
    private final CarrinhoRepository carrinhoRepository;
    private static RemoverItemCarrinho removerItemCarrinho = null;

    public RemoverItemCarrinho(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    public static RemoverItemCarrinho getInstance(CarrinhoRepository carrinhoRepository) {
        if (removerItemCarrinho == null)
            removerItemCarrinho = new RemoverItemCarrinho(carrinhoRepository);

        return removerItemCarrinho;
    }

    public void execute(Long codigoCarrinho, Long codigoProduto) {
        Carrinho carrinho = carrinhoRepository.get(codigoCarrinho);

        carrinho.getItens().remove(codigoProduto);

        carrinhoRepository.update(carrinho);
    }
}