package br.com.letscode.repository;


import br.com.letscode.model.Model;
import java.util.List;

public interface Repository<T extends Model<K>, K> {
    public void save(T entity);

    public T get(K id);

    public List<T> get();

    public void update(T entity);

    public void delete(K id);
}