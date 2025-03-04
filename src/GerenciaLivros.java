import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GerenciaLivros {
    private static List<Livro> livros = new ArrayList();

    private static File bibli = new File("biblioteca.txt");

    public static void addLivro(Scanner leitor) throws InputMismatchException {

        System.out.print("Nome do livro: ");
        String nome = leitor.nextLine();

        System.out.print("Gênero do livro: ");
        String genero = leitor.nextLine();

        System.out.print("Ano de lançamento: ");
        int ano = leitor.nextInt();

        livros.add(new Livro(nome, genero, ano));

        addArquivo();
    }

    public static void allLivros() {
        try (BufferedReader br = new BufferedReader(new FileReader(bibli))) {
            String linha = br.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //função que vai escrever no arquivo
    private static void addArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bibli))) {
            for (Livro livro : livros) {
                bw.write("Nome: " + livro.getNome());
                bw.write(", Genêro: " + livro.getGenero());
                bw.write(", Ano: " + livro.getAnoLancamento());
                bw.newLine();
            }

            System.out.println("Livro registrado com sucesso");
            demorar(1500);

        } catch (IOException e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public static void demorar(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
