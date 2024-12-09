import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Scanner leitura = new Scanner(System.in);
    private ConexaoAPI conexaoAPI = new ConexaoAPI();

    public void exibeMenu() {
        System.out.println("Bem vindo ao conversor de moedas!");

        System.out.println("***********************");
        System.out.println("Digite o número correspondente à moeda base que você deseja converter:");
        System.out.print("""
                1 - BRL - Real Brasileiro
                2 - ARS - Peso Argentino
                3 - BOB - Boliviano
                4 - CLP - Peso Chileno
                5 - COP - Peso Colombiano
                6 - USD - Dólar Americano
                7 - Sair
                """);
        System.out.println("***********************");

        // Mapeando as opções de número para os códigos de moeda
        Map<Integer, String> codigoMoedas = new HashMap<>();
        codigoMoedas.put(1, "BRL");
        codigoMoedas.put(2, "ARS");
        codigoMoedas.put(3, "BOB");
        codigoMoedas.put(4, "CLP");
        codigoMoedas.put(5, "COP");
        codigoMoedas.put(6, "USD");

        int baseOption;
        baseOption = Integer.parseInt(leitura.nextLine());

        if (baseOption == 7) {
            System.out.println("Saindo do programa...");
            return;
        }

        String baseCode = codigoMoedas.get(baseOption);

        System.out.println("Digite o número correspondente a moeda que gostaria de converter:");
        int targetOption;
        targetOption = Integer.parseInt(leitura.nextLine());

        String targetCode = codigoMoedas.get(targetOption);

        System.out.println("Quantos " + baseCode + " você gostaria de converter?");
        double valor;
        valor = Double.parseDouble(leitura.nextLine());

        try {
            Moeda minhaMoeda = conexaoAPI.consultaAPI(baseCode, targetCode);
            double conversionRate = minhaMoeda.conversion_rate();
            double valorConvertido = valor * conversionRate;
            System.out.printf("Resultado: %.2f %s equivale a %.2f %s%n", valor, baseCode, valorConvertido, targetCode);
        } catch (Exception e) {
            System.out.println("Erro ao consultar a API: " + e.getMessage());
        }
    }
}
