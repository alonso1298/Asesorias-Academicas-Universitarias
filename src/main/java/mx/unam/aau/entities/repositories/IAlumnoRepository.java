package mx.unam.aau.entities.repositories;

import mx.unam.aau.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
}
