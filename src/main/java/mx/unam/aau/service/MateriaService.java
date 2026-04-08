package mx.unam.aau.service;

import mx.unam.aau.dao.dto.MateriaRequestDto;
import mx.unam.aau.dao.dto.MateriaResponseDto;
import mx.unam.aau.dao.entities.Materia;
import mx.unam.aau.dao.repositories.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    // Listar
    public List<MateriaResponseDto> listar(){
        return materiaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }
    // Buscar
    public MateriaResponseDto buscar(Long id){
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        return convertirADTO(materia);
    }

    // Crear
    public MateriaResponseDto crear(MateriaRequestDto materiaRequestDto){

        // Validación de nombre
        if(materiaRequestDto.getNombre() == null || materiaRequestDto.getNombre().isBlank()){
            throw new RuntimeException("El nombre es obligatorio");
        }

        Materia materia = new Materia();
        materia.setNombre(materiaRequestDto.getNombre());
        materia.setDescripcion(materiaRequestDto.getDescripcion());

        Materia guardada = materiaRepository.save(materia);

        return convertirADTO(guardada);
    }

    // Actualizar
    public MateriaResponseDto actualizar(Long id, MateriaRequestDto dto){

        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materia.setNombre(dto.getNombre());
        materia.setDescripcion(dto.getDescripcion());

        Materia guardada = materiaRepository.save(materia);

        return convertirADTO(guardada);
    }

    // Eliminar
    public void eliminar(Long id){
        materiaRepository.deleteById(id);
    }

    // MAPPER
    private MateriaResponseDto convertirADTO(Materia materia){
        MateriaResponseDto dto = new MateriaResponseDto();

        dto.setIdMateria(materia.getIdMateria());
        dto.setNombre(materia.getNombre());
        dto.setDescripcion(materia.getDescripcion());

        return dto;
    }
}
