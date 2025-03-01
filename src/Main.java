import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
    }

    static void menu(Scanner sc) {
        clearScreen();

        while (true) {
            System.out.println("\nBIBLIO-TECH");
            System.out.println("\nMenu de Seleção");

            System.out.println("\n1 - Adicionar um livro");
            System.out.println("2 - Atualizar um livro");
            System.out.println("3 - Excluir um livro");
            System.out.println("4 - Listar livros");
            System.out.println("0 - Sair");

            System.out.print("\nAguardando: ");

            try {
                int option = sc.nextInt();

                switch (option) {
                    case 1:  GerenciarLivros.addLivro(sc); break;
                    case 2:  break;
                    case 3:  break;
                    case 4:  GerenciarLivros.listaLivros(); break;
                    case 0: System.out.println("Programa Encerrado"); return;
                    default:
                        System.out.println("Opção invalida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida, digite um número");
                demorar(2000);
                sc.nextLine();
            }
        }
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void demorar(int num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}