package mx.unam.aau.dao.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AsesoriaRequestDto {
    private Long alumnoId;
    private Long profesorId;
    private Long materiaId;

    private LocalDate fecha;
    private LocalTime hora;

    private String estado;
    private String notas;
}
