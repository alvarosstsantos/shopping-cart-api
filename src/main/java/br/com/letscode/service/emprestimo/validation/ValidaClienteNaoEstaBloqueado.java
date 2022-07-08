package br.com.letscode.service.emprestimo.validation;

import br.com.letscode.exception.ValidacaoException;
import br.com.letscode.model.Emprestimo;

import java.time.LocalDateTime;

public class ValidaClienteNaoEstaBloqueado implements ValidaEmprestimo{
    @Override
    public void validar(Emprestimo emprestimo) {
        LocalDateTime fimBloqueio = emprestimo.getCliente().getFimBloqueio();

        if (!(fimBloqueio == null)) {
            throw new ValidacaoException("Cliente se encontra bloqueado para fazer novos emprestimos ate " + fimBloqueio + "." );
        }
    }
}
