package br.com.letscode.repositories;


import br.com.letscode.models.Model;
import br.com.letscode.repositories.inmemory.CarrinhoInMemoryRepository;

import java.util.List;

public interface Repository<T extends Model<K>, K> {
    public T save(T entity);

    public T get(K id);

    public List<T> get();

    public T update(T entity);

    public void delete(K id);
}