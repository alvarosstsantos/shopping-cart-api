package br.com.letscode.repository;


import br.com.letscode.model.Livro;
import java.util.List;

public class LivroInMemoryRepository implements LivroRepository {
    private static LivroInMemoryRepository livroInMemoryRepository = null;
    private InMemoryRepository<Livro, Long> repository = null;

    public LivroInMemoryRepository() {
        this.repository = new InMemoryRepository<Livro, Long>();
    }

    public static LivroInMemoryRepository getInstance()
    {
        if (livroInMemoryRepository == null)
            livroInMemoryRepository = new LivroInMemoryRepository();

        return livroInMemoryRepository;
    }

    @Override
    public void save(Livro livro) {
        livro.setCodigo();
        this.repository.save(livro);
    }

    @Override
    public Livro get(Long codigo) {
        return this.repository.get(codigo);
    }

    @Override
    public List<Livro> get() {
        return this.repository.get();
    }

    @Override
    public void update(Livro livro) {
        this.repository.update(livro);
    }

    @Override
    public void delete(Long codigo) {
        this.repository.delete(codigo);
    }
}