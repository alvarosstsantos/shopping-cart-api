package br.com.letscode.model;

import br.com.letscode.enums.TipoLivro;

public class Livro extends Model<Long> {
    private static Long totalLivros = 0L;
    @Id
    private Long codigo;
    private String titulo;
    private String autor;
    private TipoLivro tipo;
    private Boolean disponivel;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        this.codigo = totalLivros++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public TipoLivro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLivro tipo) {
        this.tipo = tipo;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
