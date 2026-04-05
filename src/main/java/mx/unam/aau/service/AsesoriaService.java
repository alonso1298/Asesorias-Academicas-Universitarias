package mx.unam.aau.service;

import mx.unam.aau.dao.dto.AsesoriaRequestDto;
import mx.unam.aau.dao.dto.AsesoriaResponseDto;
import mx.unam.aau.dao.entities.Alumno;
import mx.unam.aau.dao.entities.Asesoria;
import mx.unam.aau.dao.entities.Materia;
import mx.unam.aau.dao.entities.Profesor;
import mx.unam.aau.dao.repositories.IAlumnoRepository;
import mx.unam.aau.dao.repositories.IAsesoriasRepository;
import mx.unam.aau.dao.repositories.IMateriaRepository;
import mx.unam.aau.dao.repositories.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AsesoriaService {

    @Autowired
    private IAsesoriasRepository asesoriasRepository;

    @Autowired
    private IProfesorRepository profesorRepository;

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private IMateriaRepository materiaRepository;

    // Listar
    public List<Asesoria> listar(){
        return asesoriasRepository.findAll();
    }

    // Buscar por ID
    public Asesoria buscarPorId(Long id){
        return asesoriasRepository.findById(id).orElse(null);
    }

    // Guardar
    public void guardar(AsesoriaRequestDto asesoriaRequestDto){

        Asesoria asesoria = convertirAEntidad(asesoriaRequestDto);

        // Valida fecha pasada
        if (asesoria.getFecha().isBefore(LocalDate.now())){
            throw new RuntimeException("No puedes agendar en una fecha pasada");
        }

        // Valida hora nula
        if (asesoria.getHora() == null){
            throw new RuntimeException("La hora es obligatoria");
        }

        // Valida alumno/profesor/materia
        if (asesoria.getAlumno() == null){
            throw new RuntimeException("Debe seleccionar un alumno");
        }

        if (asesoria.getProfesor() == null){
            throw new RuntimeException("Debe seleccionar un profesor");
        }

        if (asesoria.getMateria() == null){
            throw new RuntimeException("Debe seleccionar una materia");
        }

        // Valida duplicidad
        boolean existe = asesoriasRepository.existsByProfesorIdProfesorAndFechaAndHora(
                asesoria.getProfesor().getIdProfesor(),
                asesoria.getFecha(),
                asesoria.getHora()
        );

        if (existe){
            throw new RuntimeException("El profesor ya tiene una asesoria en ese horario");
        }

        // Estado por defecto
        if (asesoria.getEstado() == null){
            asesoria.setEstado("pendiente");
        }

        asesoriasRepository.save(asesoria);

    }

    // Eliminar
    public void eliminar(Long id){
        asesoriasRepository.deleteById(id);
    }

    // Metodo DTO -> Entity
    private Asesoria convertirAEntidad(AsesoriaRequestDto aseroriaRequestDto) {

        Alumno alumno = alumnoRepository.findById(aseroriaRequestDto.getAlumnoId())
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Profesor profesor = profesorRepository.findById(aseroriaRequestDto.getProfesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Materia materia = materiaRepository.findById(aseroriaRequestDto.getMateriaId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        Asesoria asesoria = new Asesoria();
        asesoria.setAlumno(alumno);
        asesoria.setProfesor(profesor);
        asesoria.setMateria(materia);
        asesoria.setFecha(aseroriaRequestDto.getFecha());
        asesoria.setHora(aseroriaRequestDto.getHora());
        asesoria.setEstado(aseroriaRequestDto.getEstado());
        asesoria.setNotas(aseroriaRequestDto.getNotas());

        return asesoria;
    }

    // Metodo Entity -> DTO
    private AsesoriaResponseDto convertirADTO(Asesoria asesoria) {

        AsesoriaResponseDto asesoriaResponseDto = new AsesoriaResponseDto();

        asesoriaResponseDto.setId(asesoria.getId());
        asesoriaResponseDto.setAlumnoNombre(asesoria.getAlumno().getUsuario().getNombre());
        asesoriaResponseDto.setProfesorNombre(asesoria.getProfesor().getNombre());
        asesoriaResponseDto.setMateriaNombre(asesoria.getMateria().getNombre());
        asesoriaResponseDto.setFecha(asesoria.getFecha());
        asesoriaResponseDto.setHora(asesoria.getHora());
        asesoriaResponseDto.setEstado(asesoria.getEstado());
        asesoriaResponseDto.setNotas(asesoria.getNotas());

        return asesoriaResponseDto;
    }

}
