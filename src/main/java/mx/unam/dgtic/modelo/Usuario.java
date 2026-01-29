package mx.unam.dgtic.modelo;

public class Usuario {

    private String nombre;
    private String eail;

    public Usuario(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEail() {
        return eail;
    }

    public void setEail(String eail) {
        this.eail = eail;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", eail='" + eail + '\'' +
                '}';
    }
}
