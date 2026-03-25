package mx.unam.aau.entities.repositories;

import mx.unam.aau.entities.Asesorias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IAsesoriasRepository extends JpaRepository<Asesorias, Long> {

    // Busca asesorias por alumno
    List<Asesorias> findByAlumnoId(Long alumnoId);

    // Busca asesorias por profesor
    List<Asesorias> findByProfesorId(Long profesorId);

    // Busca por fecha
    List<Asesorias> findByFecha(LocalDate fecha);

    // Validacion para evitar duplicados
    boolean existByProfesorIdAndFechaAndHora(Long profesorId, LocalDate fecha, LocalTime hora);
}
