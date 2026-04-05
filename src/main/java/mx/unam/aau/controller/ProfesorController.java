package mx.unam.aau.controller;

import mx.unam.aau.dao.entities.Profesor;
import mx.unam.aau.dao.entities.Usuario;
import mx.unam.aau.service.ProfesorService;
import mx.unam.aau.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private UsuarioService usuarioService;

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
}
