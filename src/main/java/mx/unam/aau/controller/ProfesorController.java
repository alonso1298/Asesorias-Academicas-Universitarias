package mx.unam.aau.controller;

import mx.unam.aau.dao.dto.ProfesorRequestDto;
import mx.unam.aau.dao.dto.ProfesorResponseDto;
import mx.unam.aau.dao.entities.Profesor;
import mx.unam.aau.dao.entities.Usuario;
import mx.unam.aau.service.ProfesorService;
import mx.unam.aau.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    //Get
    @GetMapping
    public List<ProfesorResponseDto> listar(){
        return profesorService.listar();
    }

    // GET por Id
    @GetMapping("/{id}")
    public ProfesorResponseDto obtener(@PathVariable Long id){
        return profesorService.buscarPorId(id);
    }

    // POST

    @PostMapping
    public ProfesorResponseDto crear(@PathVariable Long id,
                                          @RequestBody ProfesorRequestDto profesorRequestDto){
        return profesorService.guardar(profesorRequestDto);
    }

    // PUT
    @PutMapping("/{id}")
    public ProfesorResponseDto actualizar(@PathVariable Long id,
                                          @RequestBody ProfesorRequestDto profesorRequestDto){
        return profesorService.actualizar(id, profesorRequestDto);
    }

    // DELETE
    public void eliminar(@PathVariable Long id){
        profesorService.eliminar(id);
    }

}
