package mx.unam.aau.dao.repositories;

import mx.unam.aau.dao.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
}
