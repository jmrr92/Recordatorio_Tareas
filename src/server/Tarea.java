package server;

public class Tarea {

    private String descripcion;
    private String estado;

    //Creamos la clase tarea con sus respectivos Getters y Setters por si necesitamos la información
    public Tarea() {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Tarea(String descripcion, String estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Descripcion de la tarea: " + descripcion + ". Estado: " + estado;
    }

}
