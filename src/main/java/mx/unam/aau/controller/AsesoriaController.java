package mx.unam.aau.controller;

import mx.unam.aau.entities.Alumno;
import mx.unam.aau.entities.Asesoria;
import mx.unam.aau.entities.Usuario;
import mx.unam.aau.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asesorias")
public class AsesoriaController {

    @Autowired
    private AsesoriaService asesoriaService;
    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private MateriaService materiaService;
    @Autowired
    private UsuarioService usuarioService;

    // Lista
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("asesorias", asesoriaService.listar());
        return "paginas/asesorias";
    }

    // Nuevo
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("asesoria", new Asesoria());
        cargarCatalogos(model);
        return "paginas/asesoria-form";
    }

    // Guardar
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Asesoria asesoria, Model model, Authentication auth) {
        try {
            // Usuario autenticado
            String email = auth.getName();
            Usuario usuario = usuarioService.buscarPorEmail(email);

            // Alumno autenticado
            Alumno alumno = alumnoService.buscarUsuarioPorId(usuario.getId());

            // Se asigna automaticamente
            asesoria.setAlumno(alumno);
            asesoriaService.guardar(asesoria);
            return "redirect:/alumnos/asesorias";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            cargarCatalogos(model);
            return "paginas/asesoria-form";
        }
    }

    // Editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("asesoria", asesoriaService.buscarPorId(id));
        cargarCatalogos(model);
        return "paginas/asesoria-form";
    }

    // Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        asesoriaService.eliminar(id);
        return "redirect:/asesorias";
    }

    // Metodo auxiliar
    private void cargarCatalogos(Model model) {
        model.addAttribute("alumnos", alumnoService.listar());
        model.addAttribute("profesores", profesorService.listar());
        model.addAttribute("materias", materiaService.listar());
    }
}
