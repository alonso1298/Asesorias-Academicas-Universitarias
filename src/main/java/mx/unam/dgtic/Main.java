package mx.unam.dgtic;

import mx.unam.dgtic.entities.Materia;
import mx.unam.dgtic.entities.Profesor;
import mx.unam.dgtic.entities.Usuario;
import mx.unam.dgtic.enums.Especialidad;
import mx.unam.dgtic.service.MateriaService;
import mx.unam.dgtic.service.ProfesorService;

public class Main {
    public static void main(String[] args) {

        MateriaService materiaService = new MateriaService();
        ProfesorService profesorService = new ProfesorService();

        System.out.println("=== EJEMPLOS CRUD COMPLETOS ===\n");

        //                       MATERIA
        System.out.println("=== CRUD de Materia ===");

        // 1. Listar todas antes de comenzar
        System.out.println("\nLista inicial de materias:");
        materiaService.listar().forEach(System.out::println);

        // 2. Agregar una materia nueva
        Materia nuevaMateria = new Materia();
        nuevaMateria.setNombre("Bases de Datos");

        materiaService.guardar(nuevaMateria);
        System.out.println("\nMateria agregada.");

        // 3. Listar después de agregar
        System.out.println("\nLista tras inserción:");
        materiaService.listar().forEach(System.out::println);

        // 4. Buscar por ID
        Materia mat = materiaService.buscarPorId(1L);
        System.out.println("\nMateria con ID 1:");
        System.out.println(mat);

        // 5. Editar
        if (mat != null) {
            mat.setNombre("Programación Avanzada");
            materiaService.editar(mat);
            System.out.println("\nMateria editada.");
        }

        // 6. Verificar edición
        System.out.println("\nLista tras edición:");
        materiaService.listar().forEach(System.out::println);

        // 7. Eliminar
        materiaService.eliminar(1L);
        System.out.println("\nMateria con ID 1 eliminada.");

        // 8. Verificar eliminación
        System.out.println("\nLista final:");
        materiaService.listar().forEach(System.out::println);


        //                       PROFESOR
//        System.out.println("\n\n=== CRUD de Profesor ===");
//
//        // 1. Crear usuario para el profesor
//        Usuario u = new Usuario();
//        u.setNombre("Carlos Pérez");
//        u.setEmail("carlos.perez@test.com");
//        u.setPassword("1234");
//        u.setRol(Rol.PROFESOR);
//
//        usuarioService.guardar(u);
//
//        // 2. Crear profesor asociado al usuario
//        Profesor p = new Profesor();
//        p.setNombre("Carlos Pérez");
//        p.setNumeroEmpleado("EMP-001");
//        p.setEspecialidad(Especialidad.COMPUTACION);
//        p.setUsuario(u);
//
//        // Guardar profesor
//        profesorService.guardar(p);
//
//        // 3. Listar
//        System.out.println("\nLista de profesores:");
//        profesorService.listar().forEach(System.out::println);
//
//        // 4. Editar profesor
//        Profesor profEdit = profesorService.buscarPorId(p.getId());
//        if (profEdit != null) {
//            profEdit.setEspecialidad(Especialidad.INTELIGENCIA_ARTIFICIAL);
//            profesorService.editar(profEdit);
//        }
//
//        // 5. Verificar edición
//        System.out.println("\nLista tras edición:");
//        profesorService.listar().forEach(System.out::println);
//
//        // 6. Eliminar profesor
//        profesorService.eliminar(p.getId());
//        System.out.println("\nProfesor con ID " + p.getId() + " eliminado.");
//
//        System.out.println("\nLista final de profesores:");
//        profesorService.listar().forEach(System.out::println);
    }
}