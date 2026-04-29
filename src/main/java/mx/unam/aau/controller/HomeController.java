package mx.unam.aau.controller;

import org.springframework.security.core.Authentication;
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
    @GetMapping("/home")
    public String home(Authentication auth){
        String rol = auth.getAuthorities().iterator().next().getAuthority();
        if (rol.equals("ROLE_ADMIN")) {
            return "redirect:/admin";
        } else if (rol.equals("ROLE_PROFESOR")){
            return "redirect:/profesor";
        } else if (rol.equals("ROLE_ALUMNO")) {
            return "redirect:/alumno";
        }
        return "redirect:/login";
    }
}
