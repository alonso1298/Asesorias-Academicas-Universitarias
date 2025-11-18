package mx.unam.dgtic.dao;

public interface CrudDAO<T> {
    void listar();
    void agregar(T entidad);
    void editar(T entidad);
    void eliminar(int id);
}
