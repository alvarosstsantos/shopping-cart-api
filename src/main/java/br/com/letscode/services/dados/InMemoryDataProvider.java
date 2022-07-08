package br.com.letscode.services.dados;

import br.com.letscode.repositories.*;
import br.com.letscode.repositories.inmemory.CarrinhoInMemoryRepository;
import br.com.letscode.repositories.inmemory.ClienteInMemoryRepository;
import br.com.letscode.repositories.inmemory.ProdutoInMemoryRepository;

public class InMemoryDataProvider implements DataProvider {
    @Override
    public CarrinhoRepository getCarrinhoRepository() {
        return CarrinhoInMemoryRepository.getInstance();
    }

    @Override
    public ClienteRepository getClienteRepository() {
        return ClienteInMemoryRepository.getInstance();
    }

    @Override
    public ProdutoRepository getProdutoRepository() {
        return ProdutoInMemoryRepository.getInstance();
    }
}
