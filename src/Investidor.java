public class Investidor implements Investimento {
    private String nome;
    private double valorInicial;
    private double taxa;
    private int tempo;

    public Investidor(String nome, double valorInicial, double taxa, int tempo) {
        this.nome = nome;
        this.valorInicial = valorInicial;
        this.taxa = taxa;
        this.tempo = tempo;
    }

    public double calcularValorFinal() {
        return valorInicial * Math.pow(1 + (taxa / 100), tempo);
    }

    public double calcularRetiradaMensal() {
        return calcularValorFinal() / tempo;
    }

    public void imprimirResumo() {
        System.out.println("Investidor: " + nome);
        System.out.printf("Valor Inicial (VP): R$ %.2f\n", valorInicial);
        System.out.printf("Taxa de Juros: %.2f%% ao mês\n", taxa);
        System.out.println("Tempo: " + tempo + " meses");
        System.out.printf("Valor Futuro (VF): R$ %.2f\n", calcularValorFinal());
        System.out.printf("Retirada Mensal: R$ %.2f\n", calcularRetiradaMensal());
        System.out.println("-------------------------------");
    }
}
