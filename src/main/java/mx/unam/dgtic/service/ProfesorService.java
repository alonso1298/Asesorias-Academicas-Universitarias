package mx.unam.dgtic.service;

import mx.unam.dgtic.entities.Profesor;
import mx.unam.dgtic.repository.ProfesorRepository;

import java.util.List;

public class ProfesorService {
    private final ProfesorRepository rep = new ProfesorRepository();

    public List<Profesor> listar(){
        return rep.listar();
    }

    public Profesor buscarPorId(Integer id) {
        return rep.buscarPorId(id);
    }

    public void guardar(Profesor p){
        rep.guardar(p);
    }

    public void editar(Profesor p){
        rep.editar(p);
    }

    public void eliminar(Integer id) {
        Profesor p = rep.buscarPorId(id);
        if (p != null) {
            p.setUsuario(null);  // previene cascadas no deseadas
            rep.eliminar(id);
        }
    }
}
