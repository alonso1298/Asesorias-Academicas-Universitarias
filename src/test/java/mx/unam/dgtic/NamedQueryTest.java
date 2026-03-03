package mx.unam.dgtic;

import mx.unam.dgtic.enums.Especialidad;
import mx.unam.dgtic.enums.Rol;
import mx.unam.dgtic.repository.IProfesorRepository;
import mx.unam.dgtic.repository.IUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NamedQueryTest {

    private static final String ALUMNO = "Alonso Sagrero Granaos";

    @Autowired
    private IProfesorRepository profesorRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Test
    void testNamedQueries(){
        System.out.println(ALUMNO);

        // JPQL
        System.out.println("\nJPQL - Buscar por Especialidad:");
        profesorRepository.buscarPorEspecialidadJPQL(Especialidad.PROGRAMACION)
                .forEach(p -> System.out.println(p.getNombre()));

        // JPQL
        System.out.println("\nJPQL - Buscar por Rol:");
        usuarioRepository.buscarPorRolJPQL(Rol.ALUMNO)
                .forEach(u -> System.out.println(u.getNombre()));

        // Native
        System.out.println("\nSQL Nativo - Todos los profesores:");
        profesorRepository.buscarTodosNative()
                .forEach(p -> System.out.println(p.getNombre()));

        // Native
        System.out.println("\nSQL Nativo - Buscar por Nombre:");
        profesorRepository.buscarPorNombreNative("Mario")
                .forEach(p -> System.out.println(p.getNombre()));
    }
}
