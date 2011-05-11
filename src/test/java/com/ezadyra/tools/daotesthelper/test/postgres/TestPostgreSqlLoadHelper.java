package com.ezadyra.tools.daotesthelper.test.postgres;

import com.ezadyra.tools.daotesthelper.helper.DaoTestHelper;
import com.ezadyra.tools.daotesthelper.helper.DumpLoadHelper;
import com.ezadyra.tools.daotesthelper.test.TestEntityManager;
import org.junit.BeforeClass;
import org.junit.Test;

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
