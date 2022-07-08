package br.com.letscode.repository;

import br.com.letscode.model.Emprestimo;

import java.util.List;

public interface EmprestimoRepository extends Repository<Emprestimo, Long> {
    public List<Emprestimo> getByClienteId(String id);

    public List<Emprestimo> getPendenteByClienteId(String id);

    public List<Emprestimo> getAtrasadoByClienteId(String id);
}
