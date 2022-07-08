package br.com.letscode.services.dados;

import br.com.letscode.repositories.CarrinhoRepository;
import br.com.letscode.repositories.ClienteRepository;
import br.com.letscode.repositories.ProdutoRepository;
import br.com.letscode.repositories.file.CarrinhoFileRepository;
import br.com.letscode.repositories.file.ClienteFileRepository;
import br.com.letscode.repositories.file.ProdutoFileRepository;

public class FileDataProvider implements DataProvider {
    @Override
    public CarrinhoRepository getCarrinhoRepository() {
        return CarrinhoFileRepository.getInstance();
    }

    @Override
    public ClienteRepository getClienteRepository() {
        return ClienteFileRepository.getInstance();
    }

    @Override
    public ProdutoRepository getProdutoRepository() {
        return ProdutoFileRepository.getInstance();
    }
}
