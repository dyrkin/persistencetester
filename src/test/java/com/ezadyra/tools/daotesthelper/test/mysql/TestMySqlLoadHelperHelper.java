package com.ezadyra.tools.daotesthelper.test.mysql;

import com.ezadyra.tools.daotesthelper.helper.DaoTestHelper;
import com.ezadyra.tools.daotesthelper.helper.DumpLoadHelper;
import com.ezadyra.tools.daotesthelper.test.TestEntityManager;
import com.ezadyra.tools.daotesthelper.test.entity.CompactDisk;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.Query;

import java.util.List;

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
