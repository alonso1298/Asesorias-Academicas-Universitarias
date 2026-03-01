package mx.unam.dgtic;

import mx.unam.dgtic.entity.Usuario;
import mx.unam.dgtic.enums.Rol;
import mx.unam.dgtic.repository.IUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsuarioRepositoryTest {

    private static final String ALUMNO = "Alonso Sagrero Granados";

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Test
    void guardarUsuarioTest(){

        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Perez");
        usuario.setCorreo("juan@gmail.com");
        usuario.setRol(Rol.ALUMNO);

        Usuario guardado = usuarioRepository.save(usuario);

        System.out.println("Alumno: " + ALUMNO);
        System.out.println("Usuario guardado: " + guardado);
    }
}
