package br.com.letscode.repositories.file;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.CarrinhoRepository;

import java.util.List;

public class CarrinhoFileRepository implements CarrinhoRepository {


    @Override
    public Carrinho save(Carrinho entity) {
        return null;
    }

    @Override
    public Carrinho get(Long id) {
        return null;
    }

    @Override
    public List<Carrinho> get() {
        return null;
    }

    @Override
    public Carrinho update(Carrinho entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public static CarrinhoFileRepository getInstance(){ return null; }

}