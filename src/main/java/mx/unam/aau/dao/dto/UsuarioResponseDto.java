package mx.unam.aau.dao.dto;

import lombok.Data;

@Data
public class UsuarioResponseDto {
    private Long id;
    private String nombre;
    private String email;
    private String rol;
}
