package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Profesor;
import mx.unam.dgtic.enums.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfesorRepository extends JpaRepository<Profesor, Integer> {

    List<Profesor> findByNombreContaining(String nombre);

    List<Profesor> findByEspecialidad(Especialidad especialidad);

    List<Profesor> findByExperienciaContaining(String experiencia);

    List<Profesor> findByNombreAndEspecialidad(String nombre, Especialidad especialidad);

    List<Profesor> findByNombreOrExperiencia(String nombre, String experiencia);

}
