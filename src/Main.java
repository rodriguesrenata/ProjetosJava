import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Investidor> investidores = new ArrayList<>();

        System.out.print("Quantos investidores deseja simular (2 a 5)? ");
        int qtd = sc.nextInt();
        sc.nextLine(); // limpar buffer

        if (qtd < 2 || qtd > 5) {
            System.out.println("Quantidade inválida. Use entre 2 e 5.");
            return;
        }

        for (int i = 0; i < qtd; i++) {
            System.out.println("\nInvestidor #" + (i + 1));
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Valor inicial (VP): R$ ");
            double vp = sc.nextDouble();

            System.out.print("Taxa de juros (% ao mês): ");
            double taxa = sc.nextDouble();

            System.out.print("Tempo (em meses): ");
            int tempo = sc.nextInt();
            sc.nextLine(); // limpar o buffer

            Investidor inv = new Investidor(nome, vp, taxa, tempo);
            investidores.add(inv);
        }

        System.out.println("\n===== RELATÓRIO FINAL =====\n");
        for (Investidor i : investidores) {
            i.imprimirResumo();
        }

        sc.close();
    }

}
