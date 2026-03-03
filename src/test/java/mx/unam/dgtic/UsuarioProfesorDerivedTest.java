package mx.unam.dgtic;

import mx.unam.dgtic.entity.Profesor;
import mx.unam.dgtic.entity.Usuario;
import mx.unam.dgtic.enums.Especialidad;
import mx.unam.dgtic.enums.Rol;
import mx.unam.dgtic.repository.IProfesorRepository;
import mx.unam.dgtic.repository.IUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
public class UsuarioProfesorDerivedTest {

    private static final String ALUMNO = "Alonso Sagrero Granados";

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IProfesorRepository profesorRepository;

    @Test
    void TestConsultasDerivadas(){

        System.out.println(ALUMNO);

        // ---------- INSERTAR DATOS ----------
        Usuario u1 = new Usuario(null,"Carlos","carlos_test1@gmail.com", "123", Rol.ADMIN);
        Usuario u2 = new Usuario(null,"Ana","ana_test@gmail.com","123", Rol.ALUMNO);
        Usuario u3 = new Usuario(null,"Luis","luis_test@gmail.com","123", Rol.ALUMNO);

        u1 = usuarioRepository.save(u1);
        u2 = usuarioRepository.save(u2);
        u3 = usuarioRepository.save(u3);

        Profesor p1 = new Profesor(null,"Mario","EMP01","5 años",
                Especialidad.PROGRAMACION, u1);

        Profesor p2 = new Profesor(null,"Maria","EMP02","10 años",
                Especialidad.BASES_DE_DATOS, u2);

        Profesor p3 = new Profesor(null,"Marco","EMP03","3 años",
                Especialidad.PROGRAMACION, u3);

        profesorRepository.save(p1);
        profesorRepository.save(p2);
        profesorRepository.save(p3);

        // findByNombreContaining
        System.out.println(ALUMNO);
        System.out.println("\n1️Usuarios que contienen 'a' en el nombre:");
        usuarioRepository.findByNombreContaining("a")
                .forEach(u -> System.out.println(u.getNombre()));

        // existsByEmail
        System.out.println(ALUMNO);
        System.out.println("\n Existe ana@gmail.com?");
        System.out.println(usuarioRepository.existsByEmail("ana@gmail.com"));

        // countByRol
        System.out.println(ALUMNO);
        System.out.println("\n Cantidad de usuarios con rol ALUMNO:");
        System.out.println(usuarioRepository.countByRol(Rol.ALUMNO));

        // findTop3ByOrderByNombreAsc
        System.out.println(ALUMNO);
        System.out.println("\n Top 3 usuarios ordenados por nombre ASC:");
        usuarioRepository.findTop3ByOrderByNombreAsc()
                .forEach(u -> System.out.println(u.getNombre()));

        // AND
        System.out.println(ALUMNO);
        System.out.println("\n Profesor por nombre AND especialidad:");
        profesorRepository
                .findByNombreAndEspecialidad("Mario", Especialidad.PROGRAMACION)
                .forEach(p -> System.out.println(p.getNombre()));

        // OR
        System.out.println(ALUMNO);
        System.out.println("\n Profesor por nombre OR experiencia:");
        profesorRepository
                .findByNombreOrExperiencia("Maria","3 años")
                .forEach(p -> System.out.println(p.getNombre()));
    }
}
