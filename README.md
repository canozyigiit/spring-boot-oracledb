## SPRİNG-BOOT-ORACLE-DB

1 - ) docker pull container-registry.oracle.com/database/enterprise:19.3.0.0

2 - ) docker run -d p 1521:1521 --name oracle container-registry.oracle.com/database/enterprise:19.3.0.0

3 - ) docker exec -u root --workdir / -ti oracle /bin/sh

4 - ) yum install vim

5 - )/opt/oracle/product/19c/dbhome_1/network/admin dizinizdeki tnsnames.ora ve listener.ora dosyalarını vim ile açıp
host kısımlarını "localhost" yapın.

6 - )docker exec oracle ./setPassword.sh oracle
- Username	SID/Container	Password
- SYS		    ORCLCDB		    oracle
- SYSTEM	  ORCLCDB	    	oracle
- PDBADMIN	ORCLPDB1    	oracle

7 - )docker exec oracle bash -c "sqlplus sys/oracle@ORCLCDB as sysdba"

8- )  alter session set "_ORACLE_SCRIPT"=true;

9 - ) create user dummy identified by dummy;

10 - )  GRANT ALL PRIVILEGES TO dummy;

- application.properties :
#### ===============================
#### = DATA SOURCE
#### ===============================
#### Set here configurations for the database connection
-- spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCLCDB
-- spring.datasource.username=dummy
-- spring.datasource.password=dummy
#### Keep the connection alive if idle for a long time (needed in production)
-- spring.datasource.testWhileIdle=true
-- spring.datasource.validationQuery=SELECT 1
#### ===============================
#### = JPA / HIBERNATE
#### ===============================
#### Show or not log for each sql query
-- spring.jpa.show-sql=true
#### Hibernate ddl auto (create, create-drop, update): with "create-drop" the database
#### schema will be automatically created afresh for every start of application
-- spring.jpa.hibernate.ddl-auto=create-drop
#### Naming strategy
-- spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyHbmImpl
-- spring.jpa.hibernate.naming.physical-strategy=org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
#### Allows Hibernate to generate SQL optimized for a particular DBMS
-- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle10gDialect

