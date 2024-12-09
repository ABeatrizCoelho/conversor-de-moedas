import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HistoricoDeConversoes {

    public void salvaJson(List<Moeda> moedas) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter escrita = new FileWriter("historico.json")) {
            escrita.write(gson.toJson(moedas)); // Salva a lista completa no arquivo
        }
    }
}
