package mx.unam.dgtic.entities;

import jakarta.persistence.*;

@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
