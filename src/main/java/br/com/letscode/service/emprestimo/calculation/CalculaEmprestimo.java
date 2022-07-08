package br.com.letscode.service.emprestimo.calculation;

import br.com.letscode.model.Emprestimo;

import java.math.BigDecimal;

public interface CalculaEmprestimo {
    public BigDecimal calcular();
    public Emprestimo getEmprestimo();
}
