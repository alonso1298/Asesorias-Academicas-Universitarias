package mx.unam.dgtic.service;

import mx.unam.dgtic.entities.Materia;
import mx.unam.dgtic.repository.MateriaRepository;

import java.util.List;

public class MateriaService {
    private final MateriaRepository repository = new MateriaRepository();

    public Materia buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public List<Materia> listar() {
        return repository.listar();
    }

    public void guardar(Materia materia) {
        repository.guardar(materia);
    }

    public void editar(Materia materia) {
        repository.editar(materia);
    }

    public void eliminar(Long id) {
        repository.eliminar(id);
    }

}
