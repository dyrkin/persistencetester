package com.eugenezadyra.tools.daotesthelper.test.postgres;

import com.eugenezadyra.tools.daotesthelper.helper.DumpLoadHelper;
import com.eugenezadyra.tools.daotesthelper.test.TestEntityManager;
import org.junit.BeforeClass;

/**
 * @author eugene zadyra
 */
public class TestPostgreSqlLoadHelper extends TestEntityManager{

	static DumpLoadHelper loadHelper = new DumpLoadHelper("postgresql_connection.properties", "postgres_testapp.sql");

	@BeforeClass
	public static void beforeClass(){
		loadHelper.load();
		setupEntityManager("postgres");
	}
}
