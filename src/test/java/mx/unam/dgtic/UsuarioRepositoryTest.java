package mx.unam.dgtic;

import mx.unam.dgtic.entity.Usuario;
import mx.unam.dgtic.enums.Rol;
import mx.unam.dgtic.repository.IUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UsuarioRepositoryTest {

    private static final String ALUMNO = "Alonso Sagrero Granados";

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Test
    void guardarUsuarioTest(){

        System.out.println(ALUMNO);

        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Perez");
        usuario.setEmail("juan" + System.currentTimeMillis() + "@gmail.com");
        usuario.setPassword("1234"); // 🔥 FALTABA ESTO
        usuario.setRol(Rol.ALUMNO);

        Usuario guardado = usuarioRepository.save(usuario);

        System.out.println("Alumno: " + ALUMNO);
        System.out.println("Usuario guardado: " + guardado);

        // ---------- READ ----------
        System.out.println(ALUMNO);
        List<Usuario> lista = usuarioRepository.findAll();

        System.out.println("\nLista de usuarios:");
        lista.forEach(u -> System.out.println(u.getNombre()));

        // ---------- UPDATE ----------
        System.out.println(ALUMNO);
        Optional<Usuario> encontrado = usuarioRepository.findById(usuario.getId());

        if(encontrado.isPresent()){
            Usuario u = encontrado.get();
            u.setNombre("Juan Actualizado");
            usuarioRepository.save(u);
            System.out.println("\nUsuario actualizado correctamente");
        }

        // ---------- DELETE ----------
        System.out.println(ALUMNO);
        usuarioRepository.deleteById(usuario.getId());

        System.out.println("\nUsuario eliminado correctamente");

    }
}
