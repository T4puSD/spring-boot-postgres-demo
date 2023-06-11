package com.tapusd.postgresdemo.repository.support;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

public class ExtendedRepositoryBase {

    private final EntityManager entityManager;

    public ExtendedRepositoryBase(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Session getSession() {
        return (Session) entityManager.getDelegate();
    }
}
