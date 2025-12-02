package mx.unam.dgtic.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mx.unam.dgtic.entities.Materia;
import mx.unam.dgtic.utils.JPAUtil;

import java.util.List;

public class MateriaRepository {

    public List<Materia> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Materia> query = em.createQuery("SELECT m FROM Materia m", Materia.class);
        return query.getResultList();
    }

    public Materia buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Materia.class, id);
    }

    public void guardar(Materia materia) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(materia);
        em.getTransaction().commit();
        em.close();
    }

    public void editar(Materia materia) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(materia);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Materia materia = em.find(Materia.class, id);
        if (materia != null) {
            em.getTransaction().begin();
            em.remove(materia);
            em.getTransaction().commit();
        }
        em.close();
    }

    // Consulta personalizada
    public List<Materia> buscarPorNombre(String nombre) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Materia> q = em.createQuery(
                "SELECT m FROM Materia m WHERE m.nombre LIKE :nom",
                Materia.class
        );
        q.setParameter("nom", "%" + nombre + "%");
        return q.getResultList();
    }
}
