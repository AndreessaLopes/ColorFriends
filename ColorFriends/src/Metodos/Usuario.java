package Metodos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private List<Usuario> amigos;
    private String nome;
    private String nickname;
    private String senha;
    private String email;
    private List<Publicacao> publicacoes;

    public Usuario(String nome, String nickname, String email, String senha) {
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.amigos = new ArrayList<>();
        this.publicacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSenha(){ return senha;}

    public String getEmail(){ return email;}

    public void adicionarAmigo(Usuario amigo) {
        amigos.add(amigo);
    }

    public void removerAmigo(Usuario amigo) {
        amigos.remove(amigo);
    }

    public void adicionarPublicacao(Publicacao publicao) {
        publicacoes.add(publicao);
    }

    public List<Publicacao> obterFeed() {
        return publicacoes;
    }

	public List<Publicacao> retweetPubli() {
		return publicacoes;
	}
}
