package mx.unam.aau.service;

import mx.unam.aau.entities.Asesoria;
import mx.unam.aau.entities.repositories.IAsesoriasRepository;
import mx.unam.aau.enums.EstadoAsesorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    // Buscar por semana
    public List<Asesoria> obtenerPorSemana(LocalDate inicio, LocalDate fin){
        List<Asesoria> asesorias = asesoriasRepository.findByFechaBetween(inicio, fin);
        return asesorias;
    }

    // Busca asesorias de profesor por semana
    public List<Asesoria> obtenerPorProfesorYRango(Long id, LocalDate inicio, LocalDate fin){
        List<Asesoria> asesorias = asesoriasRepository.findByProfesorAndFechaBetween(id, inicio, fin);
        return asesorias;
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

    // Obtener todas las asesorias por un rango de fechas
    public List<Asesoria> obtenerPorRango(){
        return asesoriasRepository.
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

    // Cancelar asesoria
    public void cancelarAsesoria(Long id, Long alumnoId){
        Asesoria asesoria  = asesoriasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asesoria no encontrada"));

        // Va valida seguridad
        if (!asesoria.getAlumno().getIdAlumno().equals(alumnoId)){
            throw new RuntimeException("No autorizado");
        }
        // Impide cambiar una sesoria completada
        if (asesoria.getEstado() == EstadoAsesorias.completada){
            throw new RuntimeException("No se puedes cambiar una asesoria completada");
        }

        asesoria.setEstado(EstadoAsesorias.cancelada);
        asesoriasRepository.save(asesoria);
    }

    // Metodos para obtener las inicio/fin de semana
    public LocalDate getInicioSemana() {
        return LocalDate.now().with(DayOfWeek.MONDAY);
    }

    public LocalDate getFinSemana() {
        return LocalDate.now().with(DayOfWeek.FRIDAY);
    }

    // Realiza el conteo de las asesorias completadas, canceladas y pendientes.
    public Map<String, Object> generarReporteSemanal(List<Asesoria> asesorias){
        long total = asesorias.size();
        long completadas = asesorias.stream()
                .filter(a -> a.getEstado() == EstadoAsesorias.completada)
                .count();
        long canceladas = asesorias.stream()
                .filter(a -> a.getEstado() == EstadoAsesorias.cancelada)
                .count();
        long pendientes = asesorias.stream()
                .filter(a -> a.getEstado() == EstadoAsesorias.pendiente)
                .count();

        Map<String, Object> reporte = new HashMap<>();
        reporte.put("Total: ", total);
        reporte.put("Completadas", completadas);
        reporte.put("Canceladas", canceladas);
        reporte.put("Pendientes", pendientes);

        return reporte;
    }

    // Obtiene reportes por rango de fechas


}
