package mx.unam.aau.controller;

import mx.unam.aau.config.PasswordConfig;
import mx.unam.aau.entities.Alumno;
import mx.unam.aau.entities.Usuario;
import mx.unam.aau.enums.Rol;
import mx.unam.aau.service.AlumnoService;
import mx.unam.aau.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private PasswordConfig passwordConfig;

    private static final Logger logger =
            LoggerFactory.getLogger(RegistroController.class);

    // Endpoint para registro
    @GetMapping("/registro")
    public String mostrarRegistro(Model model){

        Alumno alumno = new Alumno();
        alumno.setUsuario(new Usuario());

        model.addAttribute("alumno", alumno);
        return "paginas/registro";
    }

    @PostMapping("/registro")
    public String registrarAlumno(@ModelAttribute Alumno alumno){

        try {
            Usuario usuario = alumno.getUsuario();
            usuario.setRol(Rol.ALUMNO);
            usuario.setPassword(
                    passwordConfig.passwordEncoder()
                            .encode(usuario.getPassword())
            );
            usuarioService.guardarUsuario(usuario);
            alumno.setUsuario(usuario);
            alumnoService.guardar(alumno);
            logger.info("Alumno registrado correctamente: {}", usuario.getEmail());

            return "redirect:/login";

        } catch (Exception e){
            logger.error("Error al guardar alumno", e);
            return "redirect:/registro?error";
        }
    }
}
