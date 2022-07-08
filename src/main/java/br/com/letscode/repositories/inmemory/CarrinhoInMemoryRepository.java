package br.com.letscode.repositories.inmemory;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.CarrinhoRepository;
import br.com.letscode.utils.Gerador;

import java.util.List;
import java.util.Objects;

public class CarrinhoInMemoryRepository implements CarrinhoRepository {
    private InMemoryRepository<Carrinho, Long> repository = null;

    public CarrinhoInMemoryRepository() {
        this.repository = new InMemoryRepository<Carrinho, Long>();
    }

    @Override
    public Carrinho save(Carrinho carrinho) {
        if (Objects.isNull(carrinho.getId())) {
            carrinho.setId(Gerador.generateRandomLong());
        }

        return this.repository.save(carrinho);
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
    public Carrinho update(Carrinho carrinho) {
        return this.repository.update(carrinho);
    }

    @Override
    public void delete(Long codigo) {
        this.repository.delete(codigo);
    }

}