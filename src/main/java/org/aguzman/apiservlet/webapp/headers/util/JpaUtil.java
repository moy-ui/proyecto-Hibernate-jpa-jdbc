package org.aguzman.apiservlet.webapp.headers.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("ejemplo");
    }

    public static EntityManager getEntityMangaer(){
        return entityManagerFactory.createEntityManager();
    }
}
