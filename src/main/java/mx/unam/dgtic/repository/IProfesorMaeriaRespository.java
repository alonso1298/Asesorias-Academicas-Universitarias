package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.ProfesorMateria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfesorMaeriaRespository extends JpaRepository<ProfesorMateria, Integer> {

    List<ProfesorMateria> findByProfesorId(Integer profesorId);

    List<ProfesorMateria> findByMateriaId(Integer materiaId);
}
