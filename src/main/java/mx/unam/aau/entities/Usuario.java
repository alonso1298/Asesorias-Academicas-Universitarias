package mx.unam.aau.entities;

import jakarta.persistence.Entity;
import mx.unam.aau.enums.Rol;

@Entity
public class Usuario {

    private Long id;
    private String nombre;
    private String email;
    private String password;
    private Rol rol;

}
