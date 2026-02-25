package mx.unam.aau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("contenido", "Bienvenido al Sistema AAU");
        return "principal";
    }
}
