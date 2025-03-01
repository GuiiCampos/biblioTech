import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciarLivros {
    private static List<Livro> livros = new ArrayList();

    public static void addLivro(Scanner sc)throws InputMismatchException {
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
}
