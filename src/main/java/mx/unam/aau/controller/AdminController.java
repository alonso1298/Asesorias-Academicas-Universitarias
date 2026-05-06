package mx.unam.aau.controller;

import mx.unam.aau.entities.Asesoria;
import mx.unam.aau.entities.Materia;
import mx.unam.aau.service.AsesoriaService;
import mx.unam.aau.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AsesoriaService asesoriaService;
    @Autowired
    private MateriaService materiaService;

    @GetMapping("")
    public String adminHome() {
        return "redirect:/admin/asesorias";
    }

    @GetMapping("/asesorias")
    public String verTodas(Model model) {
        List<Asesoria> asesorias = asesoriaService.listar();
        model.addAttribute("asesorias", asesorias);
        return "paginas/asesorias";

    }

    // Endpoint para crear una nueva materia
    @GetMapping("/nueva")
    public String nuevaMateria(Model model){
        model.addAttribute("materia", new Materia());
        return "paginas/materia-form";
    }

    // Endpoint para guardar materia
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Materia materia){
        materiaService.guardar(materia);
        return "redirect:/materias";
    }

    // Editar materia
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        model.addAttribute("materia", materiaService.buscarPorId(id));
        return "paginas/materia-form";
    }

    // Eliminar materia
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        materiaService.eliminar(id);
        return "redirect:/materias";
    }
}
