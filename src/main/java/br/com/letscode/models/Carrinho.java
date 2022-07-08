package br.com.letscode.models;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Carrinho extends Model<Long>{
    @Id
    private Long codigo;
    private Cliente cliente;
    private Map<Long, Integer> itens= new HashMap<Long, Integer>();
    private BigDecimal frete;
    private BigDecimal taxa;
    private BigDecimal desconto;
    private BigDecimal total;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Map<Long, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Long, Integer> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
