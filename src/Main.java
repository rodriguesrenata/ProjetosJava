import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Simulador de Investimento ====\n");

        // Nome com validação para aceitar apenas letras
        String nome;
        while (true) {
            System.out.print("Nome do investidor: ");
            nome = sc.nextLine().trim();

            if (nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                break;
            } else {
                System.out.println("Nome inválido. Digite apenas letras.");
            }
        }

        double vp = 0;
        while (true) {
            System.out.print("Valor inicial (VP): R$ ");
            String entrada = sc.nextLine().replace(",", ".");
            try {
                vp = Double.parseDouble(entrada);
                if (vp > 0) break;
                else System.out.println("O valor inicial deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Use apenas números (ex: 1500 ou 1500,50).");
            }
        }

        double taxa = 0;
        while (true) {
            System.out.print("Taxa de juros AO MÊS (ex: 0,3 ou 1,5): ");
            String entrada = sc.nextLine().replace(",", ".");
            try {
                taxa = Double.parseDouble(entrada);
                if (taxa >= 0) break;
                else System.out.println("A taxa não pode ser negativa.");
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido. Digite apenas o número da taxa, sem o %.");
            }
        }

        int tempo = 0;
        while (true) {
            System.out.print("Tempo do investimento EM MESES (ex: 12 para 1 ano, 24 para 2 anos): ");
            String entrada = sc.nextLine();
            try {
                tempo = Integer.parseInt(entrada);
                if (tempo > 0) break;
                else System.out.println("O tempo deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro, como 12, 18, 24, 36...");
            }
        }

        Investidor investidor = new Investidor(nome, vp, taxa, tempo);

        System.out.println("\n===== RELATÓRIO FINAL =====\n");
        investidor.imprimirResumo();

        sc.close();
    }
}
