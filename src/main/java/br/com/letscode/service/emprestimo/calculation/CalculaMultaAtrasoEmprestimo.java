package br.com.letscode.service.emprestimo.calculation;

import br.com.letscode.model.Emprestimo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculaMultaAtrasoEmprestimo extends CalculaEmprestimoDecorator {
    private static final double MULTA_DIARIA = 0.005;
    private static final double MULTA_MAXIMA = 0.2;

    public CalculaMultaAtrasoEmprestimo(CalculaEmprestimo calculaEmprestimo) {
        super(calculaEmprestimo);
    }

    @Override
    public BigDecimal calcular() {
        Emprestimo emprestimo = super.getEmprestimo();
        BigDecimal valorInicial = super.calcular();

        int tempoExcedido = (int) ChronoUnit.DAYS.between(emprestimo.getInicio(),
                                                          LocalDateTime.now()) - emprestimo.getPrazo();

        BigDecimal valorDiaria = emprestimo.getLivro().getTipo().getValor();
        BigDecimal valorExtra = valorDiaria.multiply(BigDecimal.valueOf(tempoExcedido));

        double percentualMulta = Math.min(MULTA_DIARIA * tempoExcedido, MULTA_MAXIMA);

        return valorInicial.add(valorExtra).multiply(BigDecimal.valueOf(percentualMulta));
    }

}
