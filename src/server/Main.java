package server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Definimos objeto
        Server servidor = new Server();
        System.out.println("...Iniciando servidor...");

        //Iniciamos el servidor
        servidor.iniciarServidor();

        //Finalizamos el servidor
        servidor.finalizarServidor();

    }
}
