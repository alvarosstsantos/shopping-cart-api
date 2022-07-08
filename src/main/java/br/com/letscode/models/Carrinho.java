package br.com.letscode.models;

import java.util.HashMap;
import java.util.Map;

public class Carrinho extends Model<Long>{
    @Id
    private Long codigo;
    private Cliente cliente;
    private Map<Produto, Integer> itens= new HashMap<Produto, Integer>();

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Map<Produto, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<Produto, Integer> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
