package mx.unam.aau.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.unam.aau.enums.Rol;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id;
    private String nombre;
    @Email
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;

}
