package mx.unam.aau.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;
    private String matricula;
    private String carrera;
    private Integer semestre;
    @OneToOne
    @MapsId // Comparte el mismo ID
    @JoinColumn(name = "id")
    private Usuario usuario;
}
