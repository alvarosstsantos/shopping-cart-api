package br.com.letscode.repositories.inmemory;


import br.com.letscode.models.Model;
import br.com.letscode.repositories.Repository;
import br.com.letscode.utils.Gerador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class InMemoryRepository<T extends Model<K>, K> implements Repository<T, K> {
    private final List<T> collection = new ArrayList<T>();

    @Override
    public T save(T entity) {
        collection.add(entity);
        return entity;
    }

    @Override
    public T get(K id) {
        try {
            return collection
                    .stream()
                    .filter(t -> t.getId().equals(id))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (
                IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public List<T> get() {
        return collection;
    }

    @Override
    public T update(T entity) {
        collection.remove(collection
                .stream()
                .filter(e -> e.getId().equals(entity.getId()))
                .collect(Collectors.toList())
                .get(0));
        return save(entity);
    }

    @Override
    public void delete(K id) {
        collection.remove(get(id));
    }
}