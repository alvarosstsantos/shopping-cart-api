package br.com.letscode.service.emprestimo.validation;

import br.com.letscode.exception.ValidacaoException;
import br.com.letscode.model.Cliente;
import br.com.letscode.model.Emprestimo;

public class ValidaInformacoesClienteEstaoPresentes implements ValidaEmprestimo{
    @Override
    public void validar(Emprestimo emprestimo) {
        Cliente cliente = emprestimo.getCliente();

        if (cliente.getEmail() == null) {
            throw new ValidacaoException("O cliente não possui e-mail registrado.");
        }

        if (cliente.getTelefone() == null) {
            throw new ValidacaoException("O cliente não possui telefone registrado.");
        }

        if (cliente.getNome() == null) {
            throw new ValidacaoException("O cliente não possui nome registrado.");
        }
    }
}
