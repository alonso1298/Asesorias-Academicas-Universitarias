package mx.unam.dgtic.repository;

import jakarta.persistence.EntityManager;
import mx.unam.dgtic.entities.ProfesorMateria;
import mx.unam.dgtic.utils.JPAUtil;

import java.util.List;

public class ProfesorMateriaRepository {

    public void guardar(ProfesorMateria pm){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(pm);
        em.getTransaction().commit();
        em.close();
    }

    public List<ProfesorMateria> listar(){
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery("SELECT pm FROM ProfesorMateria pm", ProfesorMateria.class)
                .getResultList();
    }

    // Consulta avanzada: obtener profesores por materia
    public List<ProfesorMateria> buscarPorMateria(Long materiaId){
        EntityManager em = JPAUtil.getEntityManager();
        return em.createQuery(
                "SELECT pm FROM ProfesorMateria pm WHERE pm.materia.id = :id",
                ProfesorMateria.class
        ).setParameter("id", materiaId)
                .getResultList();
    }
}
