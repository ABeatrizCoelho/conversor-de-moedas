import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitura = new Scanner(System.in);
        ConexaoAPI conexaoAPI = new ConexaoAPI();
        HistoricoDeConversoes historicoDeConversoes = new HistoricoDeConversoes();

        List<Moeda> moedas = new ArrayList<>();

        var baseCode = " ";
        System.out.println("Bem vindo ao conversor de moedas!");

        while (!baseCode.equalsIgnoreCase("sair")) {
            System.out.println("***********************");
            System.out.println("Digite a moeda que você deseja converter (ou sair para finalizar):");
            System.out.print("""
                    BRL - Real Brasileiro
                    ARS - Peso argentino
                    BOB - Boliviano Boliviano
                    CLP - Peso chileno
                    COP - Peso colombiano
                    USD - Dólar americano
                    """);
            System.out.println("***********************");

            baseCode = leitura.nextLine();

            if (baseCode.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Agora Digite a moeda na qual voce deseja que seja convertido:");
            var targetCode = leitura.nextLine();
            try {
                Moeda minhMoeda = conexaoAPI.consultaAPI(baseCode, targetCode);
                System.out.println(minhMoeda);
                moedas.add(minhMoeda);
                historicoDeConversoes.salvaJson(moedas);
            } catch (Exception e) {
                System.out.println("Erro ao consultar a API: " + e.getMessage());
            }
        }

        System.out.println("finalizou");

        leitura.close();
    }
}
