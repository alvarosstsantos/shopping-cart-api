package br.com.letscode.repositories.file;


import br.com.letscode.models.Produto;
import br.com.letscode.repositories.ProdutoRepository;

import java.util.List;

public class ProdutoFileRepository implements ProdutoRepository {

    @Override
    public void save(Produto entity) {

    }

    @Override
    public Produto get(Long id) {
        return null;
    }

    @Override
    public List<Produto> get() {
        return null;
    }

    @Override
    public void update(Produto entity) {

    }

    @Override
    public void delete(Long id) {

    }

    public static ProdutoFileRepository getInstance(){ return null; }

}