package mx.unam.dgtic.modelo;

public class Materia {
    private String nombre;

    public Materia(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
