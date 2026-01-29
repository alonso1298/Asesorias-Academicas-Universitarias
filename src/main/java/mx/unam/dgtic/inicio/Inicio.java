package mx.unam.dgtic.inicio;

import mx.unam.dgtic.modelo.Asesoria;
import mx.unam.dgtic.modelo.Profesor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {
    public static void main(String[] args) {
        ApplicationContext contexto =
                new ClassPathXmlApplicationContext(new String[] {
                        "bean-configuration.xml"});
        Profesor profesor = contexto.getBean("profesor1", Profesor.class);
        System.out.println(profesor);

        // Cambiar propiedad
        profesor.setNombre("Dr. Juan Gómez");
        System.out.println("Profesor modificado:");
        System.out.println(profesor);

        Asesoria asesoria = contexto.getBean("asesoria1", Asesoria.class);
        System.out.println(asesoria);

        ((ClassPathXmlApplicationContext) contexto).close();
    }
}
