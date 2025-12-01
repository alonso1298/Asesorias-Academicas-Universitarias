package mx.unam.dgtic.entities;

import jakarta.persistence.*;
import mx.unam.dgtic.enums.Rol;

@Entity
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Rol nombre;
}
