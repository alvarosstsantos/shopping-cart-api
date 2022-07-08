package br.com.letscode.service.emprestimo.calculation;

import br.com.letscode.model.Emprestimo;

import java.math.BigDecimal;

public abstract class CalculaEmprestimoDecorator implements CalculaEmprestimo {
    private final CalculaEmprestimo calculaEmprestimo;

    public CalculaEmprestimoDecorator(CalculaEmprestimo calculaEmprestimo) {
        this.calculaEmprestimo = calculaEmprestimo;
    }

    @Override
    public BigDecimal calcular() {
        return calculaEmprestimo.calcular();
    }

    @Override
    public Emprestimo getEmprestimo() {
        return calculaEmprestimo.getEmprestimo();
    }

}
