package br.com.letscode.repositories.inmemory;


import br.com.letscode.models.Produto;
import br.com.letscode.repositories.ProdutoRepository;

import java.util.List;

public class ProdutoInMemoryRepository implements ProdutoRepository {
    private static ProdutoInMemoryRepository produtoInMemoryRepository = null;
    private InMemoryRepository<Produto, Long> repository = null;

    public ProdutoInMemoryRepository() {
        this.repository = new InMemoryRepository<Produto, Long>();
    }

    public static ProdutoInMemoryRepository getInstance()
    {
        if (produtoInMemoryRepository == null)
            produtoInMemoryRepository = new ProdutoInMemoryRepository();

        return produtoInMemoryRepository;
    }

    @Override
    public void save(Produto produto) {
        this.repository.save(produto);
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
    public void update(Produto produto) {
        this.repository.update(produto);
    }

    @Override
    public void delete(Long codigo) {
        this.repository.delete(codigo);
    }
}