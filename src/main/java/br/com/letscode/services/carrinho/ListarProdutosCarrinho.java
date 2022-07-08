package br.com.letscode.services.carrinho;

import br.com.letscode.models.Carrinho;
import br.com.letscode.models.Produto;
import br.com.letscode.repositories.CarrinhoRepository;
import br.com.letscode.repositories.ProdutoRepository;
import br.com.letscode.utils.Impressor;

import java.math.BigDecimal;
import java.util.Map;

public class ListarProdutosCarrinho {
    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;
    private static ListarProdutosCarrinho listarProdutosCarrinho = null;

    public ListarProdutosCarrinho(CarrinhoRepository carrinhoRepository, ProdutoRepository produtoRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository =produtoRepository;
    }

    public static ListarProdutosCarrinho getInstance(CarrinhoRepository carrinhoRepository, ProdutoRepository produtoRepository) {
        if (listarProdutosCarrinho == null)
            listarProdutosCarrinho = new ListarProdutosCarrinho(carrinhoRepository, produtoRepository);

        return listarProdutosCarrinho;
    }

    public String execute(Long codigoCarrinho) {
        Carrinho carrinho = carrinhoRepository.get(codigoCarrinho);

        StringBuilder sb = new StringBuilder();
        sb.append("=====================\n");
        sb.append(" Carrinho de Compras \n");
        sb.append("=====================\n");

        for (Map.Entry<Long, Integer> item: carrinho.getItens().entrySet()) {
            Produto produto = produtoRepository.get(item.getKey());

            sb.append("|Produto: ");
            sb.append(produto.getNome());
            sb.append(" + Quantidade: ");
            sb.append(item.getValue());
            sb.append(" + Preço Unitário: ");
            sb.append(Impressor.imprimeMoeda(produto.getPrecoUnitario()));
            sb.append(" + Total: ");
            sb.append(Impressor.imprimeMoeda(produto.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getValue()))));
            sb.append("|\n");
        }
        sb.append("=====================");

        return sb.toString();
    }
}