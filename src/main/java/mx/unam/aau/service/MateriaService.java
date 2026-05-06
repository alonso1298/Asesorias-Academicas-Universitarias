package mx.unam.aau.service;

import mx.unam.aau.entities.Materia;
import mx.unam.aau.entities.repositories.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    public List<Materia> listar(){
        return materiaRepository.findAll();
    }

    public Materia guardar(Materia materia){
        return materiaRepository.save(materia);
    }

    public Optional<Materia> buscarPorId(Long id){
        return materiaRepository.findById(id);
    }

    public void eliminar(Long id){
        materiaRepository.deleteById(id);
    }
}
