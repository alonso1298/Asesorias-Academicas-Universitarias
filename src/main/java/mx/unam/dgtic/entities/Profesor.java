package mx.unam.dgtic.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usuario;
    private String nombre;
    private String numero_empleado;
    private String experiencia;
    @OneToMany(mappedBy = "profesor")
    private List<ProfesorMateria> materias;

    public Profesor(){}

    public Profesor(Long id, Usuario usuario, String nombre, String numero_empleado, String experiencia, List<ProfesorMateria> materias) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.numero_empleado = numero_empleado;
        this.experiencia = experiencia;
        this.materias = materias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero_empleado() {
        return numero_empleado;
    }

    public void setNumero_empleado(String numero_empleado) {
        this.numero_empleado = numero_empleado;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public List<ProfesorMateria> getMaterias() {
        return materias;
    }

    public void setMaterias(List<ProfesorMateria> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", nombre='" + nombre + '\'' +
                ", numero_empleado='" + numero_empleado + '\'' +
                ", experiencia='" + experiencia + '\'' +
                ", materias=" + materias +
                '}';
    }
}
