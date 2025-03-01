import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
    }

    static void menu(Scanner sc) {
        while (true) {
            System.out.println("BIBLIO-TECH");
            System.out.println("\nMenu de Seleção");

            System.out.println("\n1 - Adicionar um livro");
            System.out.println("2 - Atualizar um livro");
            System.out.println("3 - Excluir um livro");
            System.out.println("4 - Listar livros");
            System.out.println("0 - Sair");

            System.out.print("\nAguardando: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:                    break;
                case 2:                    break;
                case 3:                    break;
                case 4:                    break;
                case 0: System.out.println("Programa Encerrado");
                    return;
                default: System.out.println("Opção invalida");
                    break;
            }
        }
    }
}