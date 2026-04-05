package mx.unam.aau.service;

import mx.unam.aau.dao.entities.Usuario;
import mx.unam.aau.dao.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;

    // Retorna un usuario por ID
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    // Retorna un usuario default
    public Usuario obtenerUsuarioDefault() {
        return usuarioRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No hay usuarios disponibles"));
    }
}
