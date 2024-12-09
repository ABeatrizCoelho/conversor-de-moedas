import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConexaoAPI {
    public Moeda consultaAPI(String baseCode, String targetCode) {
        URI endereco = URI.create(
                "https://v6.exchangerate-api.com/v6/84b321a0462de32d0866e033/pair/" + baseCode + "/" + targetCode);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moeda.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a consulta.");
        }
    }
}