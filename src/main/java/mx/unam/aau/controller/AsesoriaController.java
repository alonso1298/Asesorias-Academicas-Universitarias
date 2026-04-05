package mx.unam.aau.controller;

import mx.unam.aau.dao.entities.Asesoria;
import mx.unam.aau.service.AlumnoService;
import mx.unam.aau.service.AsesoriaService;
import mx.unam.aau.service.MateriaService;
import mx.unam.aau.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/asesoria")
public class AsesoriaController {

    @Autowired
    private AsesoriaService asesoriaService;

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private MateriaService materiaService;

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
    public String guardar(@ModelAttribute Asesoria asesoria, Model model) {
        try {
            asesoriaService.guardar(asesoria);
            return "redirect:/asesorias";
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
