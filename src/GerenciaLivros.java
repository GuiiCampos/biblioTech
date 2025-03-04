import java.io.*;
import java.util.*;

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
            return;
        }
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

            System.out.println("Livro atualizado com sucesso");
            demorar(1000);
            addArquivo();

        } else {
            System.out.println("Esse livro não foi encontrado!");
        }
    }

    public static void deleteLivro(Scanner leitor) {
        if (livros.isEmpty()) {
            System.out.println("Não há livros para serem deletados!");
            demorar(1500);
            return;
        }

        System.out.println("Nome do livro a ser deletado: ");
        String nome = leitor.nextLine();

        boolean existe = false;

        Iterator<Livro> iterator = livros.iterator();
        while (iterator.hasNext()) {
            Livro liv = iterator.next();
            if (liv.getNome().equalsIgnoreCase(nome)) {
                iterator.remove();
                System.out.println("Livro removido com sucesso!");
                existe = true;
                addArquivo();
                break;
            }
        }

        if (!existe) {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void allLivros() {
        if (!bibli.exists() || bibli.length() == 0) {
            System.out.println("Não há livros para serem listados!");
            demorar(1500);

        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(bibli))) {
                int contadorLinhas = 0;
                String linha;

                while ((linha = br.readLine()) != null) {
                    contadorLinhas++;
                    System.out.println(linha);
                }

                System.out.println(contadorLinhas > 1 ? contadorLinhas + " livros encontrados" : contadorLinhas + " livro encontrado");

            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }

            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
