package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Usuario;
import mx.unam.dgtic.enums.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNombre(String nombre);

    List<Usuario> findByNombreContaining(String nombre);

    List<Usuario> findByEmailContaining(String email);

    List<Usuario> findByRol(Rol rol);

    List<Usuario> findTop3ByOrderByNombreAsc();

    boolean existsByEmail(String email);

    long countByRol(Rol rol);

    // CONSULTAS NOMBRADAS

    @Query(name = "Usuario.buscarPorRolJPQL")
    List<Usuario> buscarPorRolJPQL(@Param("rol") Rol rol);
    
}
