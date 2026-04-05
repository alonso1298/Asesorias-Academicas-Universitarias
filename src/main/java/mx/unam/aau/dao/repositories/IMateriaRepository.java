package mx.unam.aau.dao.repositories;

import mx.unam.aau.dao.entities.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMateriaRepository extends JpaRepository<Materia, Long> {
}
