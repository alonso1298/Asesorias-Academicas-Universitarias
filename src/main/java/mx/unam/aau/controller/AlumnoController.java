package mx.unam.aau.controller;

import mx.unam.aau.entities.Alumno;
import mx.unam.aau.service.AlumnoService;
import mx.unam.aau.service.AsesoriaService;
import mx.unam.aau.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/asesorias")
    public String verAsesorias(Model model, Authentication auth){

        String email = auth.getName();

    }
}
