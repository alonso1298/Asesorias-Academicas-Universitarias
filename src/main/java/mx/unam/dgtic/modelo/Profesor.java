package mx.unam.dgtic.modelo;

import java.util.List;

public class Profesor {

    private String nombre;
    private Usuario usuario;
    private List<Materia> materias;

    public Profesor(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", usuario=" + usuario +
                ", materias=" + materias +
                '}';
    }

}
