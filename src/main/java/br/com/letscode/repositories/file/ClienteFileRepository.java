package br.com.letscode.repositories.file;


import br.com.letscode.models.Cliente;
import br.com.letscode.repositories.ClienteRepository;

import java.util.List;

public class ClienteFileRepository implements ClienteRepository {

    @Override
    public Cliente save(Cliente entity) {
        return null;
    }

    @Override
    public Cliente get(Long id) {
        return null;
    }

    @Override
    public List<Cliente> get() {
        return null;
    }

    @Override
    public Cliente update(Cliente entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public static ClienteFileRepository getInstance(){ return null; }

}