import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciarLivros {
    private static List<Livro> livros = new ArrayList();

    public static void addLivro(Scanner sc)throws InputMismatchException {
        Main.clearScreen();

        System.out.println("Adicionar Livro");
        if(sc == null) {
            sc = new Scanner(System.in);
        }

        sc.nextLine();

        System.out.println("Digite o nome do livro: ");
        String nome = sc.nextLine();

        System.out.println("Digite o autor do livro");
        String autor = sc.nextLine();

        System.out.println("Digite o ano do livro: ");
        int ano = sc.nextInt();

        livros.add(new Livro(nome, autor, ano));
        System.out.println("Livro adicionado com sucesso!");
        Main.demorar(2000);
    }

    public static void listaLivros() {
        Main.clearScreen();

        System.out.println("\nLista de livros");

        if (livros.size() == 0) {
            System.out.println("Lista vazia, adicione algum livro");
            Main.demorar(1500);
        }else {
            if (livros.size() > 1) {
                System.out.println(livros.size() + " livros encontrados");
            } if (livros.size() == 1) {
                System.out.println(livros.size() + " livro encontrado");
            }
            for (Livro livro : livros) {
                System.out.println("\nNome: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Ano: " + livro.getAnoLancamento());
                try {
                    System.in.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
