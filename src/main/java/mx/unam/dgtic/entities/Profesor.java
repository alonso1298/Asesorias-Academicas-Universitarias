package mx.unam.dgtic.entities;

import jakarta.persistence.*;
import mx.unam.dgtic.enums.Especialidad;

import java.util.List;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String nombre;
    @Column(name = "numero_empleado")
    private String numeroEmpleado;
    private String experiencia;
    @OneToMany(mappedBy = "profesor")
    private List<ProfesorMateria> materias;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especialidad especialidad;

    public Profesor(){}

    public Profesor(Integer id, Usuario usuario, String nombre, Especialidad especialidad, String numero_empleado, String experiencia, List<ProfesorMateria> materias) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.numeroEmpleado = numero_empleado;
        this.experiencia = experiencia;
        this.materias = materias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
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
                ", usuario=" + (usuario != null ? usuario.getId() : null) +
                ", nombre='" + nombre + '\'' +
                ", numeroEmpleado='" + numeroEmpleado + '\'' +
                ", experiencia='" + experiencia + '\'' +
                ", materias=" + materias +
                ", especialidad=" + especialidad +
                '}';
    }
}
