package br.com.letscode.service.emprestimo.calculation;

import br.com.letscode.model.Emprestimo;

import java.math.BigDecimal;

public class CalculaValorBaseEmprestimo implements CalculaEmprestimo{
    private final Emprestimo emprestimo;

    public CalculaValorBaseEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    @Override
    public Emprestimo getEmprestimo() {
        return this.emprestimo;
    }

    @Override
    public BigDecimal calcular() {
        BigDecimal valorDiaria = emprestimo.getLivro().getTipo().getValor();
        int prazo = emprestimo.getPrazo();

        return valorDiaria.multiply(BigDecimal.valueOf(prazo));
    }
}
