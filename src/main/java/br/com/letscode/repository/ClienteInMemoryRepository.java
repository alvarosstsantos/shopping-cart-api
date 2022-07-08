package br.com.letscode.repository;


import br.com.letscode.model.Cliente;
import java.util.List;

public class ClienteInMemoryRepository implements ClienteRepository {
    private static ClienteInMemoryRepository clienteInMemoryRepository = null;
    private InMemoryRepository<Cliente, String> repository = null;

    public ClienteInMemoryRepository() {
        this.repository = new InMemoryRepository<Cliente, String>();
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
    public Cliente get(String email) {
        return this.repository.get(email);
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
    public void delete(String email) {
        this.repository.delete(email);
    }
}