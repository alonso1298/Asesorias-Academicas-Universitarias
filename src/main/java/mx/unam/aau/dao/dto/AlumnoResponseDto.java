package mx.unam.aau.dao.dto;

import lombok.Data;

@Data
public class AlumnoResponseDto {

    private Long id;
    private String matricula;
    private String carrera;
    private Integer semestre;

    private String nombreUsuario;
    private String emailUsuario;
}
