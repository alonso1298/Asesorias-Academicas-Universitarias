package mx.unam.aau.controller;

import mx.unam.aau.dao.dto.AsesoriaResponseDto;
import mx.unam.aau.service.AsesoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/asesoria")
public class AsesoriaController {

    @Autowired
    private AsesoriaService asesoriaService;

    // GET Listar
    @GetMapping
    public List<AsesoriaResponseDto> listar(){
        return asesoriaService.listar();
    }

}
