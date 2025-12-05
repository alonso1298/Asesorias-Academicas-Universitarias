package mx.unam.dgtic.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mx.unam.dgtic.entities.Profesor;
import mx.unam.dgtic.utils.JPAUtil;

import java.util.List;

public class ProfesorRepository {

    public List<Profesor> listar(){
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();
    }

    public Profesor buscarPorId(Integer id){
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Profesor.class, id);
    }

    public void guardar(Profesor profesor){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(profesor);
        em.getTransaction().commit();
        em.close();
    }

    public void editar(Profesor profesor){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(profesor);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(Integer id){
        EntityManager em = JPAUtil.getEntityManager();
        Profesor p = em.find(Profesor.class, id);
        if (p != null){
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }
        em.close();
    }

    // Consulta vanzada de negocio: profesores por experiencia
    public List<Profesor> buscarPorExperiencia(String exp){
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Profesor> q = em.createQuery(
                "SELECT p FROM Profesor p WHERE p.experiencia LIKE :exp",
                Profesor.class
        );
        q.setParameter("exp", "%" + exp + "%");
        return q.getResultList();
    }
}