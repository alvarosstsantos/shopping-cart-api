package br.com.letscode.builders;

import br.com.letscode.models.Cliente;
import br.com.letscode.models.Pessoa;
import br.com.letscode.models.PessoaFisica;
import br.com.letscode.models.PessoaJuridica;

public class ClienteBuilder {
    private String nome;
    private String telefone;
    private String email;
    private String documento;
    private TipoCliente tipo;
    private Long codigo;

    public enum TipoCliente  {
        PF, PJ;
    }

    public void addNome(String nome) {
        this.nome = nome;
    }

    public void addTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addEmail(String email) {
        this.email = email;
    }

    public void addDocumento(String documento) {
        this.documento = documento;
    }

    public void addTipo(TipoCliente tipo) { this.tipo = tipo; }

    public void addCodigo(Long codigo) { this.codigo = codigo; }

    public Cliente build() {
        Pessoa pessoa = null;

        switch (tipo) {
            case PF:
                pessoa = new PessoaFisica();
                break;
            case PJ:
                pessoa = new PessoaJuridica();
                break;
        }

        pessoa.setEmail(email);
        pessoa.setNome(nome);
        pessoa.setTelefone(telefone);
        pessoa.setDocumento(documento);

        Cliente cliente = new Cliente();

        cliente.setPessoa(pessoa);
        cliente.setCodigo(codigo);

        return cliente;
    }
}
