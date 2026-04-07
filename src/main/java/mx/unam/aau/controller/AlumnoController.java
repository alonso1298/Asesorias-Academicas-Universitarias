package mx.unam.aau.controller;

import mx.unam.aau.dao.dto.AlumnoRequestDto;
import mx.unam.aau.dao.dto.AlumnoResponseDto;
import mx.unam.aau.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // Get - Listar
    @GetMapping
    public List<AlumnoResponseDto> listar(){
        return alumnoService.listar();
    }

    // Get por ID
    @GetMapping("/{id}")
    public AlumnoResponseDto obtener(@PathVariable Long id){
        return alumnoService.buscar(id);
    }

    // Post - crear
    @PostMapping
    public AlumnoResponseDto crear(@RequestBody AlumnoRequestDto alumnoRequestDto){
        return alumnoService.crear(alumnoRequestDto);
    }

    // Put - actualizar
    @PutMapping("/{id}")
    public AlumnoResponseDto actualizar(@PathVariable Long id,
                                        @RequestBody AlumnoRequestDto alumnoRequestDto){
        return alumnoService.actualizar(id, alumnoRequestDto);
    }
}
