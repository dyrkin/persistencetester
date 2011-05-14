package com.eugenezadyra.tools.persistencetester.test.postgres;

import com.eugenezadyra.tools.persistencetester.helper.DumpLoadHelper;
import com.eugenezadyra.tools.persistencetester.test.TestEntityManager;
import org.junit.BeforeClass;

/**
 * @author eugene zadyra
 */
public class TestPostgreSqlLoadHelper extends TestEntityManager {

	static DumpLoadHelper loadHelper = new DumpLoadHelper("postgresql_connection.properties", "postgres_testapp.sql");

	@BeforeClass
	public static void beforeClass() {
		loadHelper.load();
		setupEntityManager("postgres");
	}
}
