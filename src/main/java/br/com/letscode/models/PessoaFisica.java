package br.com.letscode.models;

public class PessoaFisica extends Pessoa {
    private String cpf;

    @Override
    public void setDocumento(String documento) {
        this.cpf = documento;
    }

    @Override
    public String getDocumento() {
        return cpf;
    }
}
