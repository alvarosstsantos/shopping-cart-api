package br.com.letscode.models;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    @Override
    public void setDocumento(String documento) {
        this.cnpj = documento;
    }

    @Override
    public String getDocumento() {
        return cnpj;
    }
}
