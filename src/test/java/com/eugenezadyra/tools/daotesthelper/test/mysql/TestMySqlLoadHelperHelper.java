package com.eugenezadyra.tools.daotesthelper.test.mysql;

import com.eugenezadyra.tools.daotesthelper.helper.DumpLoadHelper;
import com.eugenezadyra.tools.daotesthelper.test.TestEntityManager;
import org.junit.BeforeClass;

import static junit.framework.Assert.assertEquals;

/**
 * @author eugene zadyra
 */
public class TestMySqlLoadHelperHelper extends TestEntityManager{
	static DumpLoadHelper loadHelper = new DumpLoadHelper("mysql_connection.properties", "mysql_testapp.sql");

	@BeforeClass
	public static void beforeClass(){
		loadHelper.load();
		setupEntityManager("mysql");
	}
}
