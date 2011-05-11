package com.ezadyra.tools.daotesthelper.test;

import com.ezadyra.tools.daotesthelper.helper.DaoTestHelper;
import com.ezadyra.tools.daotesthelper.test.entity.CompactDisk;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.Query;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * @author eugene zadyra
 */
public abstract class TestEntityManager extends DaoTestHelper {

	public static void afterClass() {
		if (em != null) {
			em.close();
			em = null;
		}
	}

	@Test
	public void testLoadAndEntityManager() {
		CompactDisk cd = em.find(CompactDisk.class, "Jackson songs");
		assertNotNull(cd);
		assertEquals("Michael Jackson", cd.getArtist());
	}

	@Test
	public void testRollBack1() {
		CompactDisk cd = new CompactDisk();
		cd.setArtist("Robbie Williams");
		cd.setCompany("EMI");
		cd.setCountry("Canada");
		cd.setPrice(9.99);
		cd.setTitle("Robbie Songs");
		cd.setYear(2011);
		em.persist(cd);

		Query query = em.createQuery("SELECT cd FROM CompactDisk cd");
		List<CompactDisk> list = query.getResultList();
		assertNotNull(list);
		assertEquals(2, list.size());
	}


	@Test
	public void testRollBack2() {
		Query query = em.createQuery("SELECT cd FROM CompactDisk cd");
		List<CompactDisk> list = query.getResultList();
		assertNotNull(list);
		assertEquals(1, list.size());
	}
}
