package mx.unam.dgtic.service;

import mx.unam.dgtic.entities.Profesor;
import mx.unam.dgtic.repository.ProfesorRepository;

import java.util.List;

public class ProfesorService {
    private final ProfesorRepository rep = new ProfesorRepository();

    public List<Profesor> listar(){
        return rep.listar();
    }

    public Profesor buscarPorId(Long id) {
        return rep.buscarPorId(id);
    }

    public void guardar(Profesor p){
        rep.guardar(p);
    }

    public void editar(Profesor p){
        rep.editar(p);
    }

    public void eliminar(Long id){
        rep.eliminar(id);
    }
}
