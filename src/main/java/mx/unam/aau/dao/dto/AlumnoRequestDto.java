package mx.unam.aau.dao.dto;

import lombok.Data;

@Data
public class AlumnoRequestDto {

    private String matricula;
    private String carrera;
    private Integer semestre;
    private Long usuarioId;
}
