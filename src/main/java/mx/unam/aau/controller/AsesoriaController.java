package mx.unam.aau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asesorias")
public class AsesoriaController {
    @GetMapping
    public String asesorias(){
        return "asesorias";
    }
}
