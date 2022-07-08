package br.com.letscode.repositories.inmemory;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.CarrinhoRepository;

import java.util.List;

public class CarrinhoInMemoryRepository implements CarrinhoRepository {
    private static CarrinhoInMemoryRepository carrinhoInMemoryRepository = null;
    private InMemoryRepository<Carrinho, Long> repository = null;

    public CarrinhoInMemoryRepository() {
        this.repository = new InMemoryRepository<Carrinho, Long>();
    }

    public static CarrinhoInMemoryRepository getInstance()
    {
        if (carrinhoInMemoryRepository == null)
            carrinhoInMemoryRepository = new CarrinhoInMemoryRepository();

        return carrinhoInMemoryRepository;
    }

    @Override
    public void save(Carrinho carrinho) {
        this.repository.save(carrinho);
    }

    @Override
    public Carrinho get(Long codigo) {
        return this.repository.get(codigo);
    }

    @Override
    public List<Carrinho> get() {
        return this.repository.get();
    }

    @Override
    public void update(Carrinho carrinho) {
        this.repository.update(carrinho);
    }

    @Override
    public void delete(Long codigo) {
        this.repository.delete(codigo);
    }

}