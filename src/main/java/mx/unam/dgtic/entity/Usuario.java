package mx.unam.dgtic.entity;

import jakarta.persistence.*;
import lombok.Data;
import mx.unam.dgtic.enums.Rol;

@NamedQuery(
        name = "Usuario.buscarPorRolJPQL",
        query = "SELECT u FROM Usuario u WHERE u.rol = :rol"
)
@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;
}
