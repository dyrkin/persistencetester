Some tools that simplifies testing of java DAOs. **For now library includes only dump uploader for mysql and postgresql.**

Maven repository which contains latest build is: **[http://dyrkin.github.com/repo/](http://dyrkin.github.com/repo/ "Dyrkin's maven repo")**

Simple using. Just put same piece of code to you **@BeforeClass** method:

> `new DumpLoadHelper("connection.properties", "dump.sql").load();`

or if you want to use few dumps:

> `new DumpLoadHelper("connection.properties", new String[]{"dump1.sql", "dump2.sql", "dump3.sql"}).load();`

or in case if your connection.properties file name is **"connection.properties"** you can remove this parameter because application use it as default file name:

> `new DumpLoadHelper("dump.sql").load();`

**Dump file should be in the classpath.**

Connection properties file looks like this:

> `connection.url=jdbc:postgresql://localhost:5432/daotesthelper`  
> `connection.username=postgres`  
> `connection.password=root`  

For now should be full connection url including host, port, dbname and engine identifier.

**Of course you must have preinstalled software like psql, createdb, dropdb - for pasgres and mysql, mysqladmin - for mysql. These application should be available from the $PATH**

To use transactional **entityManager** just extend your test class from **PesistenceTester** and simply put

> `setupEntityManager(persistenceUnitName);`

to **@BeforeClass** method after dump loader helper initialization.