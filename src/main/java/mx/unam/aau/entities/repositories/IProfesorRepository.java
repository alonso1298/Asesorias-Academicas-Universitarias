package mx.unam.aau.entities.repositories;

import mx.unam.aau.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepository extends JpaRepository<Profesor, Long> {
}
