package mx.unam.aau.service;

import mx.unam.aau.entities.Materia;
import mx.unam.aau.entities.repositories.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private IMateriaRepository materiaRepository;

    public List<Materia> listar(){
        return materiaRepository.findAll();
    }
}
