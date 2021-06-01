package com.alessandra.webnotes.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBManager {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if(entityManager==null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("webnotes");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}
