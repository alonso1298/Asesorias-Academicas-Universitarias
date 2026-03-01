package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Usuario;
import mx.unam.dgtic.enums.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNombre(String nombre);

    List<Usuario> findByEmailContaining(String email);

    List<Usuario> findByRol(Rol rol);

    boolean existsByEmail(String email);

    long countByRol(Rol rol);
    
}
