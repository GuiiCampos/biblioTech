import java.io.IOException;
import java.util.*;

public class GerenciarLivros {
    private static List<Livro> livros = new ArrayList();

    public static void addLivro(Scanner sc)throws InputMismatchException {
        Main.clearScreen();

        if(sc == null) {
            sc = new Scanner(System.in);
        }
        System.out.println("Adicionar Livro");

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

    public static void updateLivro(Scanner sc)throws InputMismatchException {
        Main.clearScreen();
        if(sc == null) {
            sc = new Scanner(System.in);
        }

        sc.nextLine();

        if(livros.isEmpty()) {
            System.out.println("Não há livros para serem atualizados!");
            Main.demorar(1000);
        }else {
            System.out.println("Livro a ser atualizado: ");
            String nomeOrig = sc.nextLine();
            boolean existe = false;

            for(Livro livro : livros) {
                existe = livro.getTitulo().equalsIgnoreCase(nomeOrig);
            }

            if (existe) {
                System.out.println("Atualizar livro: (Somente enter para não atualizar algum campo)");

                System.out.print("Nome do livro: ");
                String nome = sc.nextLine();

                System.out.print("Autor do livro: ");
                String autor = sc.nextLine();

                System.out.print("Lancamento do livro: (0 para não atualizar)");
                int ano = sc.nextInt();

                for (Livro liv : livros) {
                    if (!nome.isEmpty()) {
                        liv.setTitulo(nome);
                    }
                    if (!autor.isEmpty()) {
                        liv.setAutor(autor);
                    }
                    if (ano != 0) {
                        liv.setAnoLancamento(ano);
                    }
                }

                System.out.println("Livro atualizado com sucesso!");
                Main.demorar(1500);
            }else {
                System.out.println("Não existe um livro com esse nome");
                Main.demorar(1000);
            }
        }
    }

    public static void delLivro(Scanner sc)throws InputMismatchException {
        Main.clearScreen();

        if(sc == null) {
            sc = new Scanner(System.in);
        }

        sc.nextLine();

        if (livros.isEmpty()) {
            System.out.println("\nLista vazia");
            Main.demorar(1500);
        } else {
            System.out.println("\nDigite o nome do livro: ");
            String nome = sc.nextLine();

            boolean remov = livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(nome));
            if(remov) {
                System.out.println("Livro removido com sucesso!");
                Main.demorar(1000);
            } else {
                System.out.println("Livro não encontrado!");
                Main.demorar(1000);
            }
        }
    }

    public static void listaLivros() {
        Main.clearScreen();

        if (livros.isEmpty()) {
            System.out.println("Lista vazia, adicione algum livro");
            Main.demorar(1500);
        }else {
            System.out.println("\nLista de livros");

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
