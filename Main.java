import static spark.Spark.*;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        port(getHerokuAssignedPort()); // ✅ Corrigido

        get("/", (req, res) -> {
            res.type("application/json");
            return new Gson().toJson(new Mensagem("MyFend está vivo!")); // ✅ Corrigido
        });

        get("/oi", (req, res) -> {
            return "E aí, Matissundo!";
        });
    }

    // Método para pegar a porta usada pelo Render (ou 4567 localmente)
    private static int getHerokuAssignedPort() {
        String port = System.getenv("PORT");
        if (port != null) {
            return Integer.parseInt(port);
        }
        return 4567;
    }

    // Classe usada para resposta em JSON
    static class Mensagem {
        String mensagem;
        Mensagem(String msg) {
            this.mensagem = msg;
        }
    }
}
