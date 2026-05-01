package mx.unam.aau.controller;

import mx.unam.aau.entities.Asesoria;
import mx.unam.aau.entities.Profesor;
import mx.unam.aau.entities.Usuario;
import mx.unam.aau.enums.EstadoAsesorias;
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
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AsesoriaService asesoriaService;

    // Listar
    @GetMapping
    public String profesores(Model model){
        model.addAttribute("profesores", profesorService.listar());
        return "paginas/profesores";
    }

    // Nuevo
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("profesor", new Profesor());
        return "paginas/profesor-form";
    }

    // Guardar
    @PostMapping("/guardar")
    public String guardarProfesor(@ModelAttribute Profesor profesor){
        Usuario usuario = usuarioService.obtenerUsuarioDefault();
        profesor.setUsuario(usuario);
        profesorService.guardar(profesor);
        return "redirect:/profesores";
    }

    // Editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        model.addAttribute("profesor", profesorService.buscarPorId(id));
        return "paginas/profesor-form";
    }

    // Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        profesorService.eliminar(id);
        return "redirect:/profesores";
    }

    // Muestra las asesorias profesor
    @GetMapping("/profesor/asesorias")
    public String verAsesoriasProfesor(Model model, Authentication auth) {

        Usuario usuario = usuarioService.buscarPorEmail(auth.getName());
        Profesor profesor = profesorService.buscarPorId(usuario.getId());
        List<Asesoria> asesorias = asesoriaService.obtenerPorProfesor(profesor.getIdProfesor());
        model.addAttribute("asesorias", asesorias);

        return "paginas/asesorias";

    }

    // Cambia el estado
    @PostMapping("/asesorias/{id}/estado")
    public String cambiarEstado(@PathVariable Long id, @RequestParam String estado){
        Asesoria asesoria = asesoriaService.buscarPorId(id);
        asesoria.setEstado(EstadoAsesorias.valueOf(estado));

        asesoriaService.guardar(asesoria);
        return "redirect:/profesores/asesorias";
    }
}
