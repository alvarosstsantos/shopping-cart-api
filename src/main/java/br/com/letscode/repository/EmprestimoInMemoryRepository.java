package br.com.letscode.repository;


import br.com.letscode.model.Emprestimo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class EmprestimoInMemoryRepository implements EmprestimoRepository {
    private static EmprestimoInMemoryRepository emprestimoInMemoryRepository = null;
    private InMemoryRepository<Emprestimo, Long> repository = null;

    public EmprestimoInMemoryRepository() {
        this.repository = new InMemoryRepository<Emprestimo, Long>();
    }

    public static EmprestimoInMemoryRepository getInstance()
    {
        if (emprestimoInMemoryRepository == null)
            emprestimoInMemoryRepository = new EmprestimoInMemoryRepository();

        return emprestimoInMemoryRepository;
    }

    @Override
    public void save(Emprestimo emprestimo) {
        emprestimo.setCodigo();
        this.repository.save(emprestimo);
    }

    @Override
    public Emprestimo get(Long codigo) {
        return this.repository.get(codigo);
    }

    @Override
    public List<Emprestimo> get() {
        return this.repository.get();
    }

    @Override
    public void update(Emprestimo emprestimo) {
        this.repository.update(emprestimo);
    }

    @Override
    public void delete(Long codigo) {
        this.repository.delete(codigo);
    }

    public List<Emprestimo> getByClienteId(String id) {
        return repository.get()
                .stream()
                .filter(e -> e.getCliente().getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Emprestimo> getPendenteByClienteId(String id) {
        return repository.get()
                .stream()
                .filter(e -> e.getCliente().getId().equals(id))
                .filter(e -> e.getFim() == null)
                .collect(Collectors.toList());
    }

    public List<Emprestimo> getAtrasadoByClienteId(String id) {
        return repository.get()
                .stream()
                .filter(e -> e.getCliente().getId().equals(id))
                .filter(e -> e.getFim() == null)
                .filter(e -> {
                    LocalDateTime fimEsperado = ChronoUnit.DAYS.addTo(e.getInicio(), e.getPrazo());
                    return fimEsperado.compareTo(e.getFim()) < 0;
                })
                .collect(Collectors.toList());
    }
}