package br.com.letscode.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Emprestimo extends Model<Long>{
    private static Long totalEmprestimos = 0L;
    @Id
    private Long codigo;
    private Cliente cliente;
    private Livro livro;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Integer prazo;
    private BigDecimal valor;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        this.codigo = totalEmprestimos++;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
