package mx.unam.aau.controller;

import mx.unam.aau.entities.Asesoria;
import mx.unam.aau.entities.repositories.IAlumnoRepository;
import mx.unam.aau.entities.repositories.IAsesoriasRepository;
import mx.unam.aau.entities.repositories.IMateriaRepository;
import mx.unam.aau.entities.repositories.IProfesorRepository;
import mx.unam.aau.service.AlumnoService;
import mx.unam.aau.service.AsesoriaService;
import mx.unam.aau.service.MateriaService;
import mx.unam.aau.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Lista
    @GetMapping
    public String listar(Model model){
        model.addAttribute("asesorias", new Asesoria());

        // selects
        model.addAttribute("alumnos", alumnoService.listar());
        model.addAttribute("profesores", profesorService.listar());
        model.addAttribute("materias", materiaService.listar());

        return "asesorias/formulario";
    }

    // Guardar
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Asesoria asesoria, Model model){
        try {
            asesoriaService.guardar(asesoria);
            return "redirect:/asesorias";
        }catch (Exception e){
            // Se regresan datos del formulario
            model.addAttribute("error", e.getMessage());
            model.addAttribute("alumnos", alumnoService.listar());
            model.addAttribute("profesores", profesorService.listar());
            model.addAttribute("materias", materiaService.listar());
            return "asesorias/formulario";
        }
    }

    // Editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){

        Asesoria asesoria = asesoriaService.buscarPorId(id);

        model.addAttribute("asesoria", asesoria);
        model.addAttribute("alumnos", alumnoService.listar());
        model.addAttribute("profesores", profesorService.listar());
        model.addAttribute("materias", materiaService.listar());

        return "asesorias/formulario";
    }

    // Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        asesoriaService.eliminar(id);
        return "redirect:/asesorias";
    }

}
