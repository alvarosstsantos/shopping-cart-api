package br.com.letscode.repositories.inmemory;


import br.com.letscode.models.Cliente;
import br.com.letscode.repositories.ClienteRepository;

import java.util.List;

public class ClienteInMemoryRepository implements ClienteRepository {
    private static ClienteInMemoryRepository clienteInMemoryRepository = null;
    private InMemoryRepository<Cliente, Long> repository = null;

    public ClienteInMemoryRepository() {
        this.repository = new InMemoryRepository<Cliente, Long>();
    }

    public static ClienteInMemoryRepository getInstance()
    {
        if (clienteInMemoryRepository == null)
            clienteInMemoryRepository = new ClienteInMemoryRepository();

        return clienteInMemoryRepository;
    }

    @Override
    public void save(Cliente cliente) {
        this.repository.save(cliente);
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
    public void update(Cliente cliente) {
        this.repository.update(cliente);
    }

    @Override
    public void delete(Long codigo) {
        this.repository.delete(codigo);
    }
}