package mx.unam.aau.controller;

import mx.unam.aau.dao.dto.MateriaRequestDto;
import mx.unam.aau.dao.dto.MateriaResponseDto;
import mx.unam.aau.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    // GET
    @GetMapping
    public List<MateriaResponseDto> listar(){
        return materiaService.listar();
    }

    // GET por Id
    @GetMapping("/{id}")
    public MateriaResponseDto obtener(@PathVariable Long id){
        return materiaService.buscar(id);
    }

    // POST
    @PostMapping
    public MateriaResponseDto crear(@RequestBody MateriaRequestDto dto){
        return materiaService.crear(dto);
    }

    // PUT
    @PutMapping("/{id}")
    public MateriaResponseDto actualizar(@PathVariable Long id,
                                         @RequestBody MateriaRequestDto dto){
        return materiaService.actualizar(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        materiaService.eliminar(id);
    }
}
