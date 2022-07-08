package br.com.letscode.main;



import br.com.letscode.builders.ClienteBuilder;
import br.com.letscode.enums.TipoProduto;
import br.com.letscode.models.Carrinho;
import br.com.letscode.models.Cliente;
import br.com.letscode.models.Produto;
import br.com.letscode.repositories.CarrinhoRepository;
import br.com.letscode.repositories.ClienteRepository;
import br.com.letscode.repositories.ProdutoRepository;
import br.com.letscode.services.carrinho.AdicionarItemAoCarrinho;
import br.com.letscode.services.carrinho.CalculaPrecoTotalCarrinho;
import br.com.letscode.services.carrinho.CriarCarrinho;
import br.com.letscode.services.carrinho.ListarProdutosCarrinho;
import br.com.letscode.services.dados.DataProvider;
import br.com.letscode.services.dados.TipoProvider;

import java.math.BigDecimal;

public class app {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = DataProvider.getRepository("Cliente", TipoProvider.IN_MEMORY);
        ProdutoRepository produtoRepository = DataProvider.getRepository("Produto", TipoProvider.IN_MEMORY);
        CarrinhoRepository carrinhoRepository = DataProvider.getRepository("Carrinho", TipoProvider.IN_MEMORY);

        Produto p1 = new Produto();
        p1.setCodigo(1L);
        p1.setNome("Pastel");
        p1.setPrecoUnitario(BigDecimal.valueOf(7.00));
        p1.setTipo(TipoProduto.ALIMENTACAO);

        Produto p2 = new Produto();
        p2.setCodigo(1L);
        p2.setNome("Coca-Cola");
        p2.setPrecoUnitario(BigDecimal.valueOf(4.00));
        p2.setTipo(TipoProduto.ALIMENTACAO);

        p1 = produtoRepository.save(p1);
        p2 = produtoRepository.save(p2);

        ClienteBuilder cb = new ClienteBuilder();
        cb.addDocumento("64737010952");
        cb.addEmail("teste@mail.com");
        cb.addNome("Teste");
        cb.addTelefone("8634786137");
        cb.addTipo(ClienteBuilder.TipoCliente.PF);
        cb.addCodigo(0L);
        Cliente c = cb.build();

         c = clienteRepository.save(c);

        CriarCarrinho criarCarrinho = CriarCarrinho.getInstance(carrinhoRepository, clienteRepository);
        Carrinho carrinho = criarCarrinho.execute(c.getCodigo());

        AdicionarItemAoCarrinho adicionarItemAoCarrinho = AdicionarItemAoCarrinho.getInstance(carrinhoRepository);
        adicionarItemAoCarrinho.execute(carrinho.getCodigo(), p1.getCodigo(), 1);
        adicionarItemAoCarrinho.execute(carrinho.getCodigo(), p2.getCodigo(), 5);

        CalculaPrecoTotalCarrinho calculaPrecoTotalCarrinho = CalculaPrecoTotalCarrinho.getInstance(produtoRepository, carrinhoRepository);
        calculaPrecoTotalCarrinho.execute(carrinho.getCodigo());

        ListarProdutosCarrinho listarProdutosCarrinho = ListarProdutosCarrinho.getInstance(carrinhoRepository, produtoRepository);
        System.out.println(listarProdutosCarrinho.execute(carrinho.getCodigo()));

        System.out.println(carrinhoRepository.get(carrinho.getCodigo()));
    }
}
