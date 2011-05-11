package com.ezadyra.tools.daotesthelper.helper;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author eugene zadyra
 */
public class DaoTestHelper{

	protected static EntityManager em;
 	private EntityTransaction tx;

	protected static void setupEntityManager(String persistenceUnit) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
				persistenceUnit);
        em = entityManagerFactory.createEntityManager();
    }

    public void tearDown() throws Exception {
    }

    protected void begin() {
        beginTx();
    }

    @Before
    public void beginTx() {
        if (tx == null) {
            tx = em.getTransaction();
            tx.begin();
        }
    }

    protected void rollback() {
        rollbackTx();
    }

    @After
    public void rollbackTx() {
        if (tx != null && tx.isActive()) {
            em.flush();
            tx.rollback();
        }
        tx = null;
        em.clear();
    }
}
