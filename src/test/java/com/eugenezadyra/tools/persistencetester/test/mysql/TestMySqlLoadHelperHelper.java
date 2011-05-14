package com.eugenezadyra.tools.persistencetester.test.mysql;

import com.eugenezadyra.tools.persistencetester.helper.DumpLoadHelper;
import com.eugenezadyra.tools.persistencetester.test.TestEntityManager;
import org.junit.BeforeClass;

/**
 * @author eugene zadyra
 */
public class TestMySqlLoadHelperHelper extends TestEntityManager {
	static DumpLoadHelper loadHelper = new DumpLoadHelper("mysql_connection.properties", "mysql_testapp.sql");

	@BeforeClass
	public static void beforeClass() {
		loadHelper.load();
		setupEntityManager("mysql");
	}
}
