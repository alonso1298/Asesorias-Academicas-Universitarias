package mx.unam.aau.service;

import mx.unam.aau.entities.Profesor;
import mx.unam.aau.entities.repositories.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private IProfesorRepository profesorRepository;

    public List<Profesor> listar(){
        return profesorRepository.findAll();
    }
}
