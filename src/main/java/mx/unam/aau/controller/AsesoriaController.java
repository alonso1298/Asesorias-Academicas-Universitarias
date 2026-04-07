package mx.unam.aau.controller;

import mx.unam.aau.dao.dto.AsesoriaRequestDto;
import mx.unam.aau.dao.dto.AsesoriaResponseDto;
import mx.unam.aau.service.AsesoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/asesorias")
public class AsesoriaController {

    @Autowired
    private AsesoriaService asesoriaService;

    // GET - Listar
    @GetMapping
    public List<AsesoriaResponseDto> listar(){
        return asesoriaService.listar();
    }

    // GET - Obtener por ID
    @GetMapping("/{id}")
    public AsesoriaResponseDto obtener(@PathVariable Long id){
        return asesoriaService.buscarPorId(id);
    }

    // POST - Crear
    @PostMapping
    public AsesoriaResponseDto crear(@RequestBody AsesoriaRequestDto asesoriaRequestDto){
        return asesoriaService.guardar(asesoriaRequestDto);
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public AsesoriaResponseDto actualizar(@PathVariable Long id,
                                          @RequestBody AsesoriaRequestDto asesoriaRequestDto){
        return asesoriaService.actualizar(id, asesoriaRequestDto);
    }

    // Delete - eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        asesoriaService.eliminar(id);
    }
}
