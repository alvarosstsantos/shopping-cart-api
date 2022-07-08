package br.com.letscode.repository;


import br.com.letscode.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryRepository<T extends Model<K>, K> implements Repository<T, K>{
    private final List<T> collection = new ArrayList<T>();

    @Override
    public void save(T entity) {
        collection.add(entity);
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
    public void update(T entity) {
        collection.remove(collection
                .stream()
                .filter(e -> e.getId().equals(entity.getId()))
                .collect(Collectors.toList())
                .get(0));
        save(entity);
    }

    @Override
    public void delete(K id) {
        collection.remove(get(id));
    }
}