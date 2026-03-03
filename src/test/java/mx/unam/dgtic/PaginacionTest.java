package mx.unam.dgtic;

import mx.unam.dgtic.entity.Usuario;
import mx.unam.dgtic.repository.IUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class PaginacionTest {

    private static final String ALUMNO = "Alonso Sagrero Granados";

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Test
    void testPaginacion(){

        System.out.println(ALUMNO);

        Pageable pageable = PageRequest.of(0, 2);

        Page<Usuario> page = usuarioRepository.findAll(pageable);

        System.out.println("Total elementos: " + page.getTotalElements());
        System.out.println("Total paginas: " + page.getTotalPages());

        page.getContent()
                .forEach(u -> System.out.println(u.getNombre()));
    }

    @Test
    void testSort(){

        System.out.println(ALUMNO);
        System.out.println("\nPRUEBA SORT MULTIPLE");

        Sort sort = Sort.by("nombre").ascending()
                .and(Sort.by("email").descending());

        usuarioRepository.findAll(sort)
                .forEach(u -> System.out.println(u.getNombre() + " - " + u.getEmail()));
    }
}
