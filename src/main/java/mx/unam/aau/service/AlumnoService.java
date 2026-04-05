package mx.unam.aau.service;

import mx.unam.aau.dao.entities.Alumno;
import mx.unam.aau.dao.repositories.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    public List<Alumno> listar(){
        return alumnoRepository.findAll();
    }
}
