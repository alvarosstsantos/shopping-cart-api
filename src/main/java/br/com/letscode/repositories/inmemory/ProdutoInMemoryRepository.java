package br.com.letscode.repositories.inmemory;


import br.com.letscode.models.Produto;
import br.com.letscode.repositories.ProdutoRepository;

import java.util.List;

public class ProdutoInMemoryRepository implements ProdutoRepository {
    private InMemoryRepository<Produto, Long> repository = null;

    public ProdutoInMemoryRepository() {
        this.repository = new InMemoryRepository<Produto, Long>();
    }

    @Override
    public Produto save(Produto produto) {
        return this.repository.save(produto);
    }

    @Override
    public Produto get(Long codigo) {
        return this.repository.get(codigo);
    }

    @Override
    public List<Produto> get() {
        return this.repository.get();
    }

    @Override
    public Produto update(Produto produto) {
        return this.repository.update(produto);
    }

    @Override
    public void delete(Long codigo) {
        this.repository.delete(codigo);
    }
}