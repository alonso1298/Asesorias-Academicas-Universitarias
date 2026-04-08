package mx.unam.aau.service;

import mx.unam.aau.dao.dto.ProfesorRequestDto;
import mx.unam.aau.dao.dto.ProfesorResponseDto;
import mx.unam.aau.dao.entities.Profesor;
import mx.unam.aau.dao.entities.Usuario;
import mx.unam.aau.dao.repositories.IProfesorRepository;
import mx.unam.aau.dao.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private IProfesorRepository profesorRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<ProfesorResponseDto> listar(){
        return profesorRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public ProfesorResponseDto buscarPorId(Long id){
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        return convertirADTO(profesor);
    }

    // Crear
    public ProfesorResponseDto guardar(ProfesorRequestDto profesorRequestDto){

        Usuario usuario = usuarioRepository.findById(profesorRequestDto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Profesor profesor = new Profesor();
        profesor.setNombre(profesorRequestDto.getNombre());
        profesor.setNumeroEmpleado(profesorRequestDto.getNumeroEmpleado());
        profesor.setExperiencia(profesorRequestDto.getExperiencia());
        profesor.setEspecialidad(profesorRequestDto.getEspecialidad());
        profesor.setUsuario(usuario);

        Profesor guardado = profesorRepository.save(profesor);

        return convertirADTO(guardado);
    }

    // Actualizar
    public ProfesorResponseDto actualizar(Long id, ProfesorRequestDto profesorRequestDto){

        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        profesor.setNombre(profesorRequestDto.getNombre());
        profesor.setNumeroEmpleado(profesorRequestDto.getNumeroEmpleado());
        profesor.setExperiencia(profesorRequestDto.getExperiencia());
        profesor.setEspecialidad(profesorRequestDto.getEspecialidad());

        if (profesorRequestDto.getUsuarioId() != null){
            Usuario usuario = usuarioRepository.findById(profesorRequestDto.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            profesor.setUsuario(usuario);
        }
        
        Profesor guardado = profesorRepository.save(profesor);
        return convertirADTO(guardado);
    }
    public void eliminar(Long id){
        profesorRepository.deleteById(id);
    }

    // Mapper
    private ProfesorResponseDto convertirADTO(Profesor profesor){
        ProfesorResponseDto dto = new ProfesorResponseDto();

        dto.setIdProfesor(profesor.getIdProfesor());
        dto.setNombre(profesor.getNombre());
        dto.setNumeroEmpleado(profesor.getNumeroEmpleado());
        dto.setExperiencia(profesor.getExperiencia());
        dto.setEspecialidad(profesor.getEspecialidad());

        dto.setNombreUsuario(profesor.getUsuario().getNombre());
        dto.setEmailUsuario(profesor.getUsuario().getEmail());

        return dto;
    }
}
