package br.com.letscode.models;

import br.com.letscode.enums.TipoProduto;

import java.math.BigDecimal;

public class Produto extends Model<Long> {
    @Id
    private Long codigo;
    private String nome;
    private BigDecimal precoUnitario;
    private TipoProduto tipo;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }
}
