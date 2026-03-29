package mx.unam.aau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/materias")
public class MateriaController {
    @GetMapping
    public String materias(){
        return "paginas/materias";
    }
}
