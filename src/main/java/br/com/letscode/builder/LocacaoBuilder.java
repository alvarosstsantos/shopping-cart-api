package br.com.letscode.builder;

import br.letscode.bancobrasil.locadora.domain.model.*;
import br.letscode.bancobrasil.locadora.exceptions.ClienteNaoInformadoException;
import br.letscode.bancobrasil.locadora.model.*;

import java.time.LocalDateTime;
import java.util.HashSet;

public class LocacaoBuilder {

    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public LocacaoBuilder addCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public LocacaoBuilder addVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        return this;
    }

    public LocacaoBuilder addPeriodoLocacao(LocalDateTime inicio, LocalDateTime fim) {
        this.inicio = inicio;
        this.fim = fim;
        return this;
    }

    public LocacaoBuilder addCartaoCredito(CartaoCredito cartaoCredito) throws ClienteNaoInformadoException {
        if (cliente == null) {
            throw new ClienteNaoInformadoException("Cliente nao adicionado!!!");
        }
        if (cliente.getCartaoCreditos() == null) {
            cliente.setCartaoCreditos(new HashSet<>());
        }

       /* Cliente cliente = locacao.getCliente();
        Set<CartaoCredito> cc = cliente.getCartaoCreditos();
        cc.add(cartaoCredito);*/

        cliente.getCartaoCreditos().add(cartaoCredito);
        return this;
    }

    public Locacao build() {

        final Locacao locacao = new Locacao();
        locacao.setDataHoraLocacao(inicio);
        locacao.setDataHoraDevolucao(fim);
        locacao.setVeiculo(veiculo);
        locacao.setCliente(cliente);
        locacao.setLocadora(new Locadora());

        return locacao;
    }



}
