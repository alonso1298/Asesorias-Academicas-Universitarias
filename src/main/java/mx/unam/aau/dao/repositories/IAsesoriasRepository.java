package mx.unam.aau.dao.repositories;

import mx.unam.aau.dao.entities.Asesoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IAsesoriasRepository extends JpaRepository<Asesoria, Long> {

    // Busca asesorías por alumno
    List<Asesoria> findByAlumnoIdAlumno(Long alumnoId);

    // Busca asesorías por profesor
    List<Asesoria> findByProfesorIdProfesor(Long profesorId);

    // Busca por fecha
    List<Asesoria> findByFecha(LocalDate fecha);

    // Buscar por rango de fechas
    List<Asesoria> findByFechaBetween(LocalDate inicio, LocalDate fin);

    // Validación para evitar duplicados
    boolean existsByProfesorIdProfesorAndFechaAndHora(Long profesorId, LocalDate fecha, LocalTime hora);
}
