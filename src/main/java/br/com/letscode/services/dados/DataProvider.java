package br.com.letscode.services.dados;

import br.com.letscode.repositories.CarrinhoRepository;
import br.com.letscode.repositories.ClienteRepository;
import br.com.letscode.repositories.ProdutoRepository;

public interface DataProvider {
    CarrinhoRepository getCarrinhoRepository();
    ClienteRepository getClienteRepository();
    ProdutoRepository getProdutoRepository();
}
