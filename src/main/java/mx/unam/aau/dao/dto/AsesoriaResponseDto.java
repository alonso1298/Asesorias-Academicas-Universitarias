package mx.unam.aau.dao.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AsesoriaResponseDto {
    private Long id;

    private String alumnoNombre;
    private String profesorNombre;
    private String materiaNombre;

    private LocalDate fecha;
    private LocalTime hora;

    private String estado;
    private String notas;
}
