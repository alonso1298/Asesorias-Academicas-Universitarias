package mx.unam.aau.service;

import mx.unam.aau.entities.Asesoria;
import mx.unam.aau.entities.repositories.IAsesoriasRepository;
import mx.unam.aau.enums.EstadoAsesorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AsesoriaService {

    @Autowired
    private IAsesoriasRepository asesoriasRepository;

    // Listar
    public List<Asesoria> listar(){
        return asesoriasRepository.findAll();
    }

    // Buscar por ID
    public Asesoria buscarPorId(Long id){
        return asesoriasRepository.findById(id).orElse(null);
    }

    // Guardar
    public Asesoria guardar(Asesoria asesoria){

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
            asesoria.setEstado(EstadoAsesorias.pendiente);
        }

        return asesoriasRepository.save(asesoria);

    }

    // Eliminar
    public void eliminar(Long id){
        asesoriasRepository.deleteById(id);
    }

    // Obtener asesoria de alumno
    public List<Asesoria> obtenerPorAlumno(Long alumnoId){
        return asesoriasRepository.findByAlumnoIdAlumno(alumnoId);
    }

    // Obtener por asesoria por profesor
    public  List<Asesoria> obtenerPorProfesor(Long profesorId){
        return asesoriasRepository.findByProfesorIdProfesor(profesorId);
    }

    // Actualizar estado
    public  void actualizarEstado(Long id, String estado, Long profesorId){
        Asesoria asesoria = asesoriasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asesoria no encontrada"));
        if (!asesoria.getProfesor().getIdProfesor().equals(profesorId)){
            throw new RuntimeException("No autorizado");
        }
        asesoria.setEstado(EstadoAsesorias.valueOf(estado));
        asesoriasRepository.save(asesoria);
    }

}
