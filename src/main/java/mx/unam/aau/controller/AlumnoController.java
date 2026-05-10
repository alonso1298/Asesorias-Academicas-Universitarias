package mx.unam.aau.controller;

import mx.unam.aau.config.PasswordConfig;
import mx.unam.aau.entities.Alumno;
import mx.unam.aau.entities.Asesoria;
import mx.unam.aau.entities.Usuario;
import mx.unam.aau.enums.EstadoAsesorias;
import mx.unam.aau.enums.Rol;
import mx.unam.aau.service.AlumnoService;
import mx.unam.aau.service.AsesoriaService;
import mx.unam.aau.service.ProfesorService;
import mx.unam.aau.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AsesoriaService asesoriaService;

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private ProfesorService profesorService;

    // Ver la asesoria
    @GetMapping("/asesorias")
    public String verAsesorias(Model model, Authentication auth){

        Usuario usuario = usuarioService.buscarPorEmail(auth.getName());
        List<Asesoria> asesorias = asesoriaService.obtenerPorAlumno(usuario.getId());
        model.addAttribute("asesorias", asesorias);
        return "paginas/asesorias";
    }

    // Crea asesoria
    @GetMapping("asesorias/nueva")
    public String nuevaAsesoria(Model model){
        model.addAttribute("asesoria", new Asesoria());
        return "paginas/asesoria-form";
    }

    // Guarda la asesoria
    @PostMapping("/asesorias")
    public String guardarAsesoria(@ModelAttribute Asesoria asesoria, Authentication auth) {

        Usuario usuario = usuarioService.buscarPorEmail(auth.getName());
        Alumno alumno = alumnoService.buscarUsuarioPorId(usuario.getId());
        asesoria.setAlumno(alumno);
        asesoria.setEstado(EstadoAsesorias.pendiente);
        asesoriaService.guardar(asesoria);

        return "redirect:/alumnos/asesorias";

    }

    // Cancela la asesoria
    @PostMapping("/asesorias/{id}/cancelar")
    public String cancelarAsesoria(@PathVariable Long id, Authentication auth){
        Usuario usuario = usuarioService.buscarPorEmail(auth.getName());
        Alumno alumno = alumnoService.buscarUsuarioPorId(usuario.getId());

        asesoriaService.cancelarAsesoria(id, alumno.getIdAlumno());

        return "redirect:/alumnos/asesorias";
    }

    @GetMapping("/profesores")
    public String verProfesoresAlumno(Model model){
        model.addAttribute("profesores", profesorService.listar());
        return "paginas/profesores-alumno";
    }

    // Endpoint para registro
    @GetMapping("/registro")
    public String mostrarRegistro(Model model){
        model.addAttribute("alumno", new Alumno());
        return "paginas/registro";
    }

    @PostMapping("/registro")
    public String registrarAlumno(@ModelAttribute Alumno alumno){

        PasswordConfig passwordConfig = new PasswordConfig();

        Usuario usuario = alumno.getUsuario();
        usuario.setRol(Rol.ALUMNO);
        usuario.setPassword(
                passwordConfig.passwordEncoder().encode(usuario.getPassword())
        );
        usuarioService.guardarUsuario(usuario);
        alumno.setUsuario(usuario);
        alumnoService.guardar(alumno);

        return "redirect:/login";
    }
}
