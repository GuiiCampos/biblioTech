import java.io.*;
import java.util.*;

public class GerenciaLivros {
    private static List<Livro> livros = new ArrayList();
    private static File bibli = new File("biblioteca.txt");

    public static void startArq() {
        carregarLivros();
        System.out.println("Sistema inicializado");
    }

    public static void addLivro(Scanner leitor) throws InputMismatchException {

        System.out.print("Nome do livro: ");
        String nome = leitor.nextLine();

        System.out.print("Gênero do livro: ");
        String genero = leitor.nextLine();

        System.out.print("Ano de lançamento: ");
        int ano = 0;
        try {
            ano = Integer.parseInt(leitor.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ano inválido. Usando valor padrão 0.");
        }

        livros.add(new Livro(nome, genero, ano));

        System.out.println("Livro registrado com sucesso");
        demorar(1500);
        addArquivo();
    }

    public static void updateLivro(Scanner leitor) throws InputMismatchException {
        if (livros.isEmpty()) {
            System.out.println("Não há livros para serem atualizados!");
            demorar(1500);
            return;
        }
        System.out.println("Nome do livro a ser atualizado: ");
        String nomeBusca = leitor.nextLine();

        Livro livroAtualizar = null;

        for (Livro livro : livros) {
            if (livro.getNome().equalsIgnoreCase(nomeBusca)) {
                livroAtualizar = livro;
                break;
            }
        }

        if (livroAtualizar != null) {
            System.out.println("Atualizar livro. (Para não atualizar algum campo, pressione ENTER)");

            System.out.print("Novo nome do livro: ");
            String novoNome = leitor.nextLine();
            if (!novoNome.trim().isEmpty()) {
                livroAtualizar.setNome(novoNome);
            }

            System.out.print("Novo gênero do livro: ");
            String novoGenero = leitor.nextLine();
            if (!novoGenero.trim().isEmpty()) {
                livroAtualizar.setGenero(novoGenero);
            }

            System.out.print("Novo ano de lançamento (0 para não atualizar): ");
            String inputAno = leitor.nextLine();
            if (!inputAno.trim().isEmpty()) {
                try {
                    int novoAno = Integer.parseInt(inputAno);
                    if (novoAno > 0) {
                        livroAtualizar.setAnoLancamento(novoAno);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ano inválido, mantendo valor anterior.");
                }
            }

            System.out.println("Livro atualizado com sucesso!");
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
        if (livros.isEmpty()) {
            System.out.println("Não há livros para serem listados!");
            demorar(1500);

        } else {
            int contador = 0;
            for (Livro livro : livros) {
                contador++;
                System.out.println(contador + ". " + livro);
            }

            System.out.println(contador > 1 ? contador + " livros encontrados" : "1 livro encontrado");

            try {
                System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //função que vai escrever no arquivo
    private static void addArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bibli, false))) {
            for (Livro livro : livros) {
                bw.write(livro.getNome() + ";" + livro.getGenero() + ";" + livro.getAnoLancamento());
                bw.newLine();
            }
            demorar(1500);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    //Carregar do arquivo para a lista
    private static void carregarLivros() {
        if (!bibli.exists()) return;

        try(BufferedReader br = new BufferedReader(new FileReader(bibli))) {

            String linha;
            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    try {
                        livros.add(new Livro(partes[0], partes[1], Integer.parseInt(partes[2])));
                    } catch (NumberFormatException e) {
                        System.out.println("Error ao carregar livro: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
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
