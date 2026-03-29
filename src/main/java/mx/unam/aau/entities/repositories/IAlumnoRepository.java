package mx.unam.aau.entities.repositories;

import mx.unam.aau.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
}
