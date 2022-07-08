package br.com.letscode.model;

import java.time.LocalDateTime;

public class Cliente extends Model<String> {
    @Id
    private String email;
    private String nome;
    private String telefone;
    private LocalDateTime fimBloqueio;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getFimBloqueio() {
        return fimBloqueio;
    }

    public void setFimBloqueio(LocalDateTime fimBloqueio) {
        this.fimBloqueio = fimBloqueio;
    }
}
