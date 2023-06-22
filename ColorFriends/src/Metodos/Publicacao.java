package Metodos;

import java.util.Date;

public class Publicacao {

    private Usuario autor;
    private Date dataPublicacao;
    private String conteudo;

    public Publicacao(Usuario autor, String conteudo) {
        this.autor = autor;
        this.dataPublicacao = new Date();
        this.conteudo = conteudo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public String getConteudo() {
        return conteudo;
    }
}