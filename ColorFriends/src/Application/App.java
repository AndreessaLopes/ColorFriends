package Application;

import java.util.List;
import java.util.Scanner;

import Metodos.Publicacao;
import Metodos.RedeSocial;
import Metodos.Usuario;
import org.w3c.dom.ls.LSOutput;

public class App {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Criando a rede social
        RedeSocial redeSocial = new RedeSocial();
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Cadastro de novo usuário");
            System.out.println("2. Estabelecer amizade");
            System.out.println("3. Criar publicação");
            System.out.println("4. Obter feed de usuário");
            System.out.println("5. Republicar");
            System.out.println("6. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite seu nome: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();

                    System.out.print("Digite seu usuário: ");
                    String nickName = scanner.nextLine();

                    System.out.println("Digite seu email: ");
                    String email = scanner.nextLine();

                    System.out.println("Digite sua senha: ");
                    String senha = scanner.nextLine();

                    Usuario novoUsuario = new Usuario(nome, nickName , email , senha);
                    redeSocial.adicionarUsuario(novoUsuario);
                    System.out.println("Usuário " + nome + " criado com sucesso!");
                    break;
                case 2:
                    System.out.println("=== Estabelecer Amizade ===");
                    System.out.print("Digite o nome do primeiro usuário: ");
                    scanner.nextLine(); // Consumir a quebra de linha anterior
                    String nomeUsuario1 = scanner.nextLine();

                    System.out.print("Digite o nome do segundo usuário: ");
                    String nomeUsuario2 = scanner.nextLine();

                    Usuario usuario1 = redeSocial.buscarUsuario(nomeUsuario1);
                    Usuario usuario2 = redeSocial.buscarUsuario(nomeUsuario2);

                    if (usuario1 != null && usuario2 != null) {
                        usuario1.adicionarAmigo(usuario2);
                        usuario2.adicionarAmigo(usuario1);
                        System.out.println("Amizade estabelecida entre " + nomeUsuario1 + " e " + nomeUsuario2 + "!");
                    } else {
                        System.out.println("Um ou ambos os usuários não foram encontrados.");
                    }
                    break;
                case 3:
                    System.out.println("=== Criar Publicação ===");
                    System.out.print("Digite o nome do autor da publicação: ");
                    scanner.nextLine(); // Consumir a quebra de linha anterior
                    String nomeAutor = scanner.nextLine();

                    Usuario autor = redeSocial.buscarUsuario(nomeAutor);

                    if (autor != null) {
                        System.out.print("Digite o conteúdo da publicação: ");
                        String conteudo = scanner.nextLine();

                        Publicacao publicacao = new Publicacao(autor, conteudo);
                        autor.adicionarPublicacao(publicacao);
                        System.out.println("Publicação criada com sucesso!");
                    } else {
                        System.out.println("Autor não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("=== Obter Feed de Usuário ===");
                    System.out.print("Digite o nome do usuário: ");
                    scanner.nextLine(); // Consumir a quebra de linha anterior
                    String nomeUsuario = scanner.nextLine();

                    Usuario usuario = redeSocial.buscarUsuario(nomeUsuario);

                    if (usuario != null) {
                        List<Publicacao> feed = usuario.obterFeed();

                        System.out.println("Feed de " + nomeUsuario + ":");
                        for (Publicacao publicacao : feed) {
                            System.out.println(publicacao.getAutor().getNome() + ": " + publicacao.getConteudo());
                            List<Publicacao> feed1 = usuario.obterFeed();

                        }
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("===Republicar===");
                    System.out.print("Digite o nome do usuário que irá fazer a republicação: ");
                    scanner.nextLine(); // Consumir a quebra de linha anterior
                    String retweetUsuario = scanner.nextLine();

                    Usuario retweet = redeSocial.buscarUsuario(retweetUsuario);

                    if (retweet != null) {
                        List<Publicacao> feed = retweet.retweetPubli();

                        System.out.println("Feed de " + retweetUsuario + ":");
                        for (Publicacao publicacao : feed) {
                            System.out.println(publicacao.getAutor().getNome() + ": " + publicacao.getConteudo());
                            List<Publicacao> feed1 = retweet.retweetPubli();

                        }
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }
        System.out.println("Saindo do programa...");

        System.out.println();
    }

}