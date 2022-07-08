package br.com.letscode.repositories.file;


import br.com.letscode.models.Carrinho;
import br.com.letscode.repositories.CarrinhoRepository;

import java.util.List;

public class CarrinhoFileRepository implements CarrinhoRepository {


    @Override
    public void save(Carrinho entity) {

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
    public void update(Carrinho entity) {

    }

    @Override
    public void delete(Long id) {

    }

    public static CarrinhoFileRepository getInstance(){ return null; }

}