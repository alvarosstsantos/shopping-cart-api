package br.com.letscode.service.emprestimo.validation;


import br.com.letscode.exception.ValidacaoException;
import br.com.letscode.model.Emprestimo;
import br.com.letscode.repository.EmprestimoRepository;

import java.util.List;

public class ValidaNumeroMaximoEmprestimosPorCliente implements ValidaEmprestimo {
    private static EmprestimoRepository emprestimoRepository;

    public ValidaNumeroMaximoEmprestimosPorCliente(EmprestimoRepository emprestimoRepository) {
        ValidaNumeroMaximoEmprestimosPorCliente.emprestimoRepository = emprestimoRepository;
    }

    @Override
    public void validar(Emprestimo emprestimo) {
        List<Emprestimo> emprestimos = emprestimoRepository.getPendenteByClienteId(emprestimo.getCliente().getId());

        if (emprestimos.size() >= 2) {
            throw new ValidacaoException("O cliente já reservou o máximo de livros possíveis.");
        }
    }

}
