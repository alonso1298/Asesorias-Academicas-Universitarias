package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Profesor;
import mx.unam.dgtic.enums.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProfesorRepository extends JpaRepository<Profesor, Integer> {

    List<Profesor> findByNombreContaining(String nombre);

    List<Profesor> findByEspecialidad(Especialidad especialidad);

    List<Profesor> findByExperienciaContaining(String experiencia);

    List<Profesor> findByNombreAndEspecialidad(String nombre, Especialidad especialidad);

    List<Profesor> findByNombreOrExperiencia(String nombre, String experiencia);

    // CONSULTAS NOMBRADAS

    @Query(name = "Profesor.buscarPorEspecialidadJPQL")
    List<Profesor> buscarPorEspecialidadJPQL(@Param("esp") Especialidad esp);

    @Query(name = "Profesor.buscarPorExperienciaJPQL")
    List<Profesor> buscarPorExperienciaJPQL(@Param("exp") String exp);

    @Query(name = "Profesor.buscarTodosNative", nativeQuery = true)
    List<Profesor> buscarTodosNative();

    @Query(name = "Profesor.buscarPorNombreNative", nativeQuery = true)
    List<Profesor> buscarPorNombreNative(@Param("nombre") String nombre);

}
