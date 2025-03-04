import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GerenciaLivros.startArq();
        GerenciaLivros.demorar(2000);

        menu(sc);
    }

    static void menu(Scanner sc) {
        while (true) {
            System.out.println("\nBIBLIO-TECH");
            System.out.println("Menu de Seleção");

            System.out.println("\n1 - Adicionar um livro");
            System.out.println("2 - Atualizar um livro");
            System.out.println("3 - Excluir um livro");
            System.out.println("4 - Listar livros");
            System.out.println("0 - Sair");

            System.out.print("\nAguardando: ");

            try {
                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1: GerenciaLivros.addLivro(sc);        break;
                    case 2: GerenciaLivros.updateLivro(sc);     break;
                    case 3: GerenciaLivros.deleteLivro(sc);     break;
                    case 4: GerenciaLivros.allLivros();         break;
                    case 0: System.out.println("Programa Encerrado");
                        return;
                    default: System.out.println("Opção invalida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error, somente numeros!");
                GerenciaLivros.demorar(1500);
                sc.nextLine();
            }
        }
    }
}