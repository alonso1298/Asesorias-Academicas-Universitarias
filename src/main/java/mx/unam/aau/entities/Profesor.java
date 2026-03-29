package mx.unam.aau.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;
    private String nombre;
    @Column(name = "numero_empleado")
    private String numeroEmpleado;
    private String experiencia;
    @NotNull
    private String especialidad;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
