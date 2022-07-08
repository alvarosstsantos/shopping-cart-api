package br.com.letscode.service.emprestimo.validation;

import br.com.letscode.exception.ValidacaoException;
import br.com.letscode.model.Emprestimo;

public class ValidaPrazoMaximoDevolucaoEmprestimo implements ValidaEmprestimo{
    private static final int QUANTIDADE_MAXIMA_DIARIAS = 20;

    @Override
    public void validar(Emprestimo emprestimo) {
        if (emprestimo.getPrazo() > QUANTIDADE_MAXIMA_DIARIAS) {
            throw new ValidacaoException("Prazo de devolucao maior que o maximo de " + QUANTIDADE_MAXIMA_DIARIAS + " dias.");
        }

    }
}
