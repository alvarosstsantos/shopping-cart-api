package br.com.letscode.repositories.inmemory;


import br.com.letscode.models.Cliente;
import br.com.letscode.repositories.ClienteRepository;
import br.com.letscode.utils.Gerador;

import java.util.List;
import java.util.Objects;

public class ClienteInMemoryRepository implements ClienteRepository {
    private InMemoryRepository<Cliente, Long> repository = null;

    public ClienteInMemoryRepository() {
        this.repository = new InMemoryRepository<Cliente, Long>();
    }

    @Override
    public Cliente save(Cliente cliente) {
        if (Objects.isNull(cliente.getId())) {
            cliente.setId(Gerador.generateRandomLong());
        }

        return this.repository.save(cliente);
    }

    @Override
    public Cliente get(Long codigo) {
        return this.repository.get(codigo);
    }

    @Override
    public List<Cliente> get() {
        return this.repository.get();
    }

    @Override
    public Cliente update(Cliente cliente) {
        return this.repository.update(cliente);
    }

    @Override
    public void delete(Long codigo) {
        this.repository.delete(codigo);
    }
}