package mx.unam.aau.dao.repositories;

import mx.unam.aau.dao.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
