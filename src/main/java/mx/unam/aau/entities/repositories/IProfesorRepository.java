package mx.unam.aau.entities.repositories;

import mx.unam.aau.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProfesorRepository extends JpaRepository<Profesor, Long> {
    Optional<Profesor> findByUsuarioId(Long usuarioId);
}
