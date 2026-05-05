package mx.unam.aau.controller;

import mx.unam.aau.entities.Asesoria;
import mx.unam.aau.service.AsesoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AsesoriaService asesoriaService;

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
}
