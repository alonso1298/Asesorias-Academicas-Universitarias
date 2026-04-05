package mx.unam.aau.service;

import mx.unam.aau.dao.entities.Asesoria;
import mx.unam.aau.dao.repositories.IAsesoriasRepository;
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
            asesoria.setEstado("pendiente");
        }

        return asesoriasRepository.save(asesoria);

    }

    // Eliminar
    public void eliminar(Long id){
        asesoriasRepository.deleteById(id);
    }

}
