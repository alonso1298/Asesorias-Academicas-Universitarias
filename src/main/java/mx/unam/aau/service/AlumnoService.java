package mx.unam.aau.service;

import mx.unam.aau.dao.dto.AlumnoRequestDto;
import mx.unam.aau.dao.dto.AlumnoResponseDto;
import mx.unam.aau.dao.entities.Alumno;
import mx.unam.aau.dao.entities.Usuario;
import mx.unam.aau.dao.repositories.IAlumnoRepository;
import mx.unam.aau.dao.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    // Listar
    public List<AlumnoResponseDto> listar(){
        return alumnoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // Buscar
    public AlumnoResponseDto buscar(Long id){
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        return convertirADTO(alumno);
    }

    // Crear
    public AlumnoResponseDto crear(AlumnoRequestDto alumnoRequestDto){

        Usuario usuario = usuarioRepository.findById(alumnoRequestDto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Alumno alumno = new Alumno();
        alumno.setMatricula(alumnoRequestDto.getMatricula());
        alumno.setCarrera(alumnoRequestDto.getCarrera());
        alumno.setSemestre(alumnoRequestDto.getSemestre());
        alumno.setUsuario(usuario);

        Alumno guardado = alumnoRepository.save(alumno);

        return convertirADTO(guardado);
    }

    // Actualizar
    public AlumnoResponseDto actualizar(Long id, AlumnoRequestDto alumnoRequestDto){
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        alumno.setMatricula(alumnoRequestDto.getMatricula());
        alumno.setCarrera(alumnoRequestDto.getCarrera());
        alumno.setSemestre(alumnoRequestDto.getSemestre());

        if(alumnoRequestDto.getUsuarioId() != null){
            Usuario usuario = usuarioRepository.findById(alumnoRequestDto.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            alumno.setUsuario(usuario);
        }

        Alumno guardado = alumnoRepository.save(alumno);

        return convertirADTO(guardado);
    }

    // Eliminar
    public void eliminar(Long id){
        alumnoRepository.deleteById(id);
    }

    // Entity -> DTO
    private AlumnoResponseDto convertirADTO(Alumno alumno){

        AlumnoResponseDto dto = new AlumnoResponseDto();

        dto.setId(alumno.getIdAlumno());
        dto.setMatricula(alumno.getMatricula());
        dto.setCarrera(alumno.getCarrera());
        dto.setSemestre(alumno.getSemestre());

        dto.setNombreUsuario(alumno.getUsuario().getNombre());
        dto.setEmailUsuario(alumno.getUsuario().getEmail());

        return dto;
    }

    // DTO -> Entity
    private Alumno convertirAEntidad(AlumnoRequestDto dto){

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Alumno alumno = new Alumno();
        alumno.setMatricula(dto.getMatricula());
        alumno.setCarrera(dto.getCarrera());
        alumno.setSemestre(dto.getSemestre());
        alumno.setUsuario(usuario);

        return alumno;
    }
}
