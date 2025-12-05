package mx.unam.dgtic.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Usuario;

import java.util.List;

public class UsuarioRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("auu-pu");

    public Usuario guardar(Usuario usuario){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(usuario);
            tx.commit();
            return usuario;
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    private Usuario actualizar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Usuario actualizado = em.merge(usuario);
            tx.commit();
            return actualizado;
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public void eliminar(Integer id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Usuario buscarPorId(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public List<Usuario> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM Usuario u", Usuario.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
