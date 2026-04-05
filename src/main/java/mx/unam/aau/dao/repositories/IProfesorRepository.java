package mx.unam.aau.dao.repositories;

import mx.unam.aau.dao.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepository extends JpaRepository<Profesor, Long> {
}
