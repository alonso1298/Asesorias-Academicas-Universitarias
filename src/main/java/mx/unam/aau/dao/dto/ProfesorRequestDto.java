package mx.unam.aau.dao.dto;

import lombok.Data;

@Data
public class ProfesorRequestDto {
    private String nombre;
    private String numeroEmpleado;
    private String experiencia;
    private String especialidad;
    private Long usuarioId;
}
