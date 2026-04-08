package mx.unam.aau.dao.dto;

import lombok.Data;

@Data
public class ProfesorResponseDto {

    private Long idProfesor;
    private String nombre;
    private String numeroEmpleado;
    private String experiencia;
    private String especialidad;
    private String nombreUsuario;
    private String emailUsuario;
}
