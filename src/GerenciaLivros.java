import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciaLivros {
    static Scanner leitor = new Scanner(System.in);
    static File livros = new File("biblioteca.txt");

    public static void addLivro() throws InputMismatchException {
        System.out.print("Nome do livro: ");
        String nome = leitor.nextLine();

        System.out.print("Gênero do livro: ");
        String genero = leitor.nextLine();

        System.out.println("Ano de lançamento: ");
        int ano = leitor.nextInt();

        addArquivo(nome, genero, ano);

    }

    public static void allLivros() {
        try (BufferedReader br = new BufferedReader(new FileReader(livros))) {
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
    private static void addArquivo(String nome, String genero, int ano) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(livros))) {
            bw.newLine();
            bw.write("Nome: " + nome);
            bw.write(", Genêro: " + genero);
            bw.write(", Ano: " + ano);
            bw.flush();

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
