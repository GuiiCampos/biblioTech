import java.io.*;
import java.util.Scanner;

public class GerenciaLivros {
    static Scanner leitor = new Scanner(System.in);
    static File livros = new File("biblioteca.txt");

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


}
