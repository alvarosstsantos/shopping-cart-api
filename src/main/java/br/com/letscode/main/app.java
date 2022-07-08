package br.com.letscode.main;


import br.com.letscode.enums.OrigemDados;
import br.com.letscode.enums.TipoProduto;
import br.com.letscode.models.Cliente;
import br.com.letscode.models.Produto;
import br.com.letscode.repositories.CarrinhoRepository;
import br.com.letscode.repositories.ClienteRepository;
import br.com.letscode.repositories.ProdutoRepository;
import br.com.letscode.services.dados.DataProviderService;

import java.math.BigDecimal;

public class app {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = DataProviderService.getData(OrigemDados.MEMORIA).getClienteRepository();
        ProdutoRepository produtoRepository = DataProviderService.getData(OrigemDados.MEMORIA).getProdutoRepository();
        CarrinhoRepository carrinhoRepository = DataProviderService.getData(OrigemDados.MEMORIA).getCarrinhoRepository();

        Produto p1 = new Produto();
        p1.setCodigo(1l);
        p1.setNome("Pastel");
        p1.setPrecoUnitario(BigDecimal.valueOf(7.00));
        p1.setTipo(TipoProduto.ALIMENTACAO);

        Produto p2 = new Produto();
        p2.setCodigo(1l);
        p2.setNome("Coca-Cola");
        p2.setPrecoUnitario(BigDecimal.valueOf(4.00));
        p2.setTipo(TipoProduto.ALIMENTACAO);

        produtoRepository.save(p1);
        produtoRepository.save(p2);

        Cliente c = new Cliente();

    }
}
