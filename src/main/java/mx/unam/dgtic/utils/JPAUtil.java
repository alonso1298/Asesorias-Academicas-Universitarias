package mx.unam.dgtic.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("auu-pu");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
