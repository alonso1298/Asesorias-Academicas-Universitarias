package mx.unam.dgtic.dao;

import mx.unam.dgtic.model.Materia;

import java.util.List;

public interface ICrudDAO<T> {
    List<T> listar();
    T buscarPorId(int id);
    int guardar(T entidad);
    void editar(T entidad);
    void eliminar(int id);
}
