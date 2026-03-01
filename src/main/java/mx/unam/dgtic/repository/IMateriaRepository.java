package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMateriaRepository extends JpaRepository<Materia, Integer> {

    List<Materia> findByNombreContaining(String nombre);

    List<Materia> findByNombreStartingWith(String nombre);

    List<Materia> findTop3ByOrderByNombreAsc();
}
