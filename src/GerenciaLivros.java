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

    public static void updateLivro(Scanner leitor) throws InputMismatchException {
        if (livros.isEmpty()) {
            System.out.println("Não há livros para serem atualizados!");
            demorar(1500);

        } else {
            System.out.println("Nome do livro a ser atualizado: ");
            String nome = leitor.nextLine();

            boolean existe = false;

            for (Livro livro : livros) {
                existe = livro.getNome().equalsIgnoreCase(nome);
            }

            if (existe) {
                System.out.println("Atualizar livro: (Para não atualizar algum campo, pressione ENTER)");

                System.out.print("Nome do livro: ");
                nome = leitor.nextLine();

                System.out.print("Genêro do livro: ");
                String genero = leitor.nextLine();

                System.out.print("Lançamento do livro: (0 para não atualizar) ");
                int ano = leitor.nextInt();

                for (Livro liv : livros) {
                    if (!nome.isEmpty()) {
                        liv.setNome(nome);
                    }
                    if (!genero.isEmpty()) {
                        liv.setGenero(genero);
                    }
                    if (ano != 0) {
                        liv.setAnoLancamento(ano);
                    }
                }
            }
        }
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
