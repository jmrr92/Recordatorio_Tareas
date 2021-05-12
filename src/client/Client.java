package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final String conexion = "localhost";
    private final int puerto = 4321;
    private Socket socket;
    Scanner scanner = new Scanner(System.in);

    //Conexión
    public Client() throws IOException {
        socket = new Socket("localhost", 9876);
    }

    public void iniciarCliente() throws IOException {

        //Iniciamos la entrada de datos
        DataInputStream entradaServidor = new DataInputStream(socket.getInputStream());
        System.out.println(entradaServidor.readUTF());

        //Escribir datos
        DataOutputStream salidaServidor = new DataOutputStream(socket.getOutputStream());

        //Escribimos el nombre en la consola cliente
        String nombre = scanner.nextLine();
        salidaServidor.writeUTF(nombre);

        //Escribimos el número de tareas en la consola cliente
        String numeroTareas = scanner.nextLine();
        salidaServidor.writeUTF(numeroTareas);

        //Convertimos la salida a un Int para hacer el bucle for
        int numeroTareasInt = Integer.parseInt(numeroTareas);
        for (int i = 0; i < numeroTareasInt; i++) {
            String descripcionTarea = scanner.nextLine();
            salidaServidor.writeUTF(descripcionTarea);
            String urgenciaTarea = scanner.nextLine();
            salidaServidor.writeUTF(urgenciaTarea);
        }

        //Cerramos conexión
        System.out.println("...Fin de la conexion...");
        salidaServidor.close();
        entradaServidor.close();
        socket.close();

    }
}
