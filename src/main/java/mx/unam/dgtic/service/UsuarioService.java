package mx.unam.dgtic.service;

import mx.unam.dgtic.entities.Usuario;
import mx.unam.dgtic.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.guardar(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.actualizar(usuario);
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.eliminar(id);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.buscarPorId(id);
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.obtenerTodos();
    }
}
