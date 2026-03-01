package mx.unam.dgtic;

import mx.unam.dgtic.entity.Usuario;
import mx.unam.dgtic.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsuarioRepositoryTest {

    private static final String ALUMNO = "Alonso Sagrero Granados";

    @Autowired
    private IUsuarioRepository usuarioRepository;

    Usuario usuario = new Usuario();

}
