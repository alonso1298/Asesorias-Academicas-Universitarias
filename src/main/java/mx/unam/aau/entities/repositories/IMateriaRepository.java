package mx.unam.aau.entities.repositories;

import mx.unam.aau.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMateriaRepository extends JpaRepository<Materia, Long> {
}
