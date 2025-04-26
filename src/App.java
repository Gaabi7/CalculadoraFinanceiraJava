import java.util.Scanner;

public class App {

    public static double calculoSimples(double p, double r, double t) {
        return p * (1 + (r/ 100) * t);
    }

    public static double calculoComposto ( double p, double r, double t) {
        return p * Math.pow((1 + r / 100), t);
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== Calculadora de rendimento Financeiro ===");

        do {
            //Entrada de dados
            System.out.print("\nDigite o valor do investimento inicial (P): ");
            double p = scanner.nextDouble();

            System.out.print("Digite a taxa de juros anual (%): ");
            double r = scanner.nextDouble();

            System.out.print("Digite o período de investimento (anos): ");
            double t = scanner.nextDouble();

            scanner.nextLine();
            System.out.print("Escolha a capitalização (Simples ou Composta: )");
            String tipo = scanner.nextLine().toLowerCase();

            double montante;

            //Verifica tipo de capitalização
            if (tipo.equals("simples")) {
                montante = calculoSimples(p, r, t);
            } else if (tipo.equals("composta")) {
                montante = calculoComposto(p, r, t);
            } else {
                System.out.println("Opção inválida de capitalização. Tente novamente.");
                continue; // Volta ao início do loop
            }

            System.out.printf("Montante final apos %.0f anos: R$ %2f\n", t, montante );

            //Pergunta se o Usuario deseja continuar 
            System.out.print("\nDeseja realizar outro cáculo (s/n): ");
            String resposta = scanner.nextLine().toLowerCase();
            if (!resposta.equals("s")) {
                continuar = false;
                System.out.println("Calculadora encerrada. Obrigada!");
            }

        } while (continuar);

        scanner.close();
}
        
}
