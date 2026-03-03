package mx.unam.dgtic.entity;

import jakarta.persistence.*;
import lombok.*;
import mx.unam.dgtic.enums.Especialidad;

@NamedQueries({
        @NamedQuery(
                name = "Profesor.buscarPorEspecialidadJPQL",
                query = "SELECT p FROM Profesor p WHERE p.especialidad = :esp"
        ),
        @NamedQuery(
                name = "Profesor.buscarPorExperienciaJPQL",
                query = "SELECT p FROM Profesor p WHERE p.experiencia LIKE %:exp%"
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Profesor.buscarTodosNative",
                query = "SELECT * FROM profesor",
                resultClass = Profesor.class
        ),
        @NamedNativeQuery(
                name = "Profesor.buscarPorNombreNative",
                query = "SELECT * FROM profesor WHERE nombre = :nombre",
                resultClass = Profesor.class
        )
})
@Entity
@Table(name = "profesor")
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Column(name = "numero_empleado")
    private String numeroEmpleado;

    private String experiencia;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
