package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private final int conexion = 9876;
    private final ServerSocket serverSocket;
    private Socket socket;

    //Definimos la conexión
    public Server() throws IOException {
        serverSocket = new ServerSocket(conexion);
        socket = new Socket();
    }

    //ArrayList para guardar la información que mostraremos al final de la comunicación
    ArrayList<String> informacion = new ArrayList<String>();

    //Método para iniciar conexion
    public void iniciarServidor() throws IOException {

        //Aceptamos los datos que lleguen del cliente cuando este se conecte al servidor
        while (true) {
            //Servidor esperando para recibir la petición por parte del cliente
            System.out.println("...A la espera de conexión con el cliente...");
            socket = serverSocket.accept();

            //Se inicia conexión
            DataOutputStream mensajeCliente = new DataOutputStream(socket.getOutputStream());

            //Enviamos mensaje al cliente
            mensajeCliente.writeUTF("Petición rebida");

            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            String mensajeDeCliente;

            try {
                System.out.println("Escribe tu nombre");
                mensajeDeCliente = entrada.readUTF();
                //Mostramos el mensaje por pantalla
                System.out.println("Hola " + mensajeDeCliente);

                //A la espera de que el cliente escriba el número de tareas
                System.out.println("Escribe el numero de tareas");
                mensajeDeCliente = entrada.readUTF();
                String tareas = mensajeDeCliente;

                //Mostramos el número de tareas que el cliente ha introducido
                System.out.println("Tienes " + tareas + " tareas añadidas.");

                //A la espera de que el cliente escriba la descripción de las tareas
                int numeroTareas = Integer.parseInt(tareas);
                int i = numeroTareas;
                int iterador = 1;
                //Bucle con cuenta atrás de las tareas que quedan por introducir
                while (i != 0) {
                    System.out.println("Introduzca la descripción de la tarea " + iterador);
                    mensajeDeCliente = entrada.readUTF();
                    String tarea = mensajeDeCliente;
                    System.out.println("¿Cual es la urgencia de la tarea?");
                    mensajeDeCliente = entrada.readUTF();
                    String prioridad = mensajeDeCliente;
                    System.out.println("Añadida la tarea " + tarea + " con prioridad " + prioridad);
                    i--;
                    iterador++;

                    //Creamos una tarea para recoger los datos en nuestro ArrayList ya creado
                    Tarea info = new Tarea(tarea, prioridad);
                    informacion.add(info.getDescripcion());
                    informacion.add(info.getEstado());
                }

                //Mostramos toda la información recogida
                System.out.println("...Enviando informacion...");
                System.out.println("LISTA DE TAREAS " + informacion.toString());


            } catch (EOFException ex) {
                System.out.println("Fin de la comunicación");
            }

            //Finalizamos conexión con el cliente
            System.out.println("Fin de la conexión");
            socket.close();
        }
    }

    public void finalizarServidor() throws IOException {
        serverSocket.close();
    }

}
