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

@SpringBootTest
public class UsuarioProfesorDerivedTest {

    private static final String ALUMNO = "Alonso Sagrero Granados";

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IProfesorRepository profesorRepository;

    @Test
    void TestConsultasDerivadas(){

        // ---------- INSERTAR DATOS ----------
        Usuario u1 = new Usuario(null,"Carlos","carlos@gmail.com","123", Rol.ADMIN);
        Usuario u2 = new Usuario(null,"Ana","ana@gmail.com","123", Rol.ALUMNO);
        Usuario u3 = new Usuario(null,"Luis","luis@gmail.com","123", Rol.ALUMNO);

        usuarioRepository.save(u1);
        usuarioRepository.save(u2);
        usuarioRepository.save(u3);

        Profesor p1 = new Profesor(null,"Mario","EMP01","5 años", Especialidad.PROGRAMACION,null);
        Profesor p2 = new Profesor(null,"Maria","EMP02","10 años",Especialidad.BASES_DE_DATOS,null);
        Profesor p3 = new Profesor(null,"Marco","EMP03","3 años",Especialidad.PROGRAMACION,null);

        profesorRepository.save(p1);
        profesorRepository.save(p2);
        profesorRepository.save(p3);

        // ================================
        // 1️findByNombreContaining
        // ================================
        System.out.println("\n1️Usuarios que contienen 'a' en el nombre:");
        usuarioRepository.findByNombreContaining("a")
                .forEach(u -> System.out.println(u.getNombre()));

        // ================================
        // 2️existsByEmail
        // ================================
        System.out.println("\n2️¿Existe ana@gmail.com?");
        System.out.println(usuarioRepository.existsByEmail("ana@gmail.com"));

        // ================================
        // 3️countByRol
        // ================================
        System.out.println("\n3️Cantidad de usuarios con rol ALUMNO:");
        System.out.println(usuarioRepository.countByRol(Rol.ALUMNO));

        // ================================
        // 4️findTop3ByOrderByNombreAsc
        // ================================
        System.out.println("\n4️Top 3 usuarios ordenados por nombre ASC:");
        usuarioRepository.findTop3ByOrderByNombreAsc()
                .forEach(u -> System.out.println(u.getNombre()));

        // ================================
        // 5️AND
        // ================================
        System.out.println("\n5️Profesor por nombre AND especialidad:");
        profesorRepository
                .findByNombreAndEspecialidad("Mario", Especialidad.PROGRAMACION)
                .forEach(p -> System.out.println(p.getNombre()));

        // ================================
        // 6️OR
        // ================================
        System.out.println("\n6️Profesor por nombre OR experiencia:");
        profesorRepository
                .findByNombreOrExperiencia("Maria","3 años")
                .forEach(p -> System.out.println(p.getNombre()));
    }
}
