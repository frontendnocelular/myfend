package myfend;

import static spark.Spark.*;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) {
        port(4567); // Porta padrão

        get("/", (req, res) -> {
            res.type("application/json");
            return new Gson().toJson(new Mensagem("MyFend está vivo!"));
        });

        get("/oi", (req, res) -> {
            return "E aí, Matissundo!";
        });

System.out.println("🔥 Servidor Spark tentando iniciar na porta 4567...");
awaitInitialization(); // <- essa linha já tem que estar aí

        awaitInitialization(); // <- Isso mantém o servidor ativo
    }

    static class Mensagem {
        String mensagem;
        Mensagem(String msg) {
            this.mensagem = msg;
        }
    }
}
