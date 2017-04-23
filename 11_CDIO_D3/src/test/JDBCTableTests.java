package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.dao.TestSQLOperatorDAO;
import test.dao.TestSQLProductBatchComponentDAO;
import test.dao.TestSQLProductBatchDAO;
import test.dao.TestSQLRaavareBatchDAO;
import test.dao.TestSQLRaavareDAO;
import test.dao.TestSQLReceptComponentDAO;
import test.dao.TestSQLReceptDAO;
import test.dao.TestSQLRoleDAO;

/*
 * JUnit Test Suite used to run all Table unit tests at once.
 */
@RunWith(Suite.class)
@SuiteClasses({ TestSQLOperatorDAO.class, TestSQLProductBatchComponentDAO.class, TestSQLProductBatchDAO.class, TestSQLRaavareBatchDAO.class, TestSQLRaavareDAO.class, TestSQLReceptComponentDAO.class, TestSQLReceptDAO.class, TestSQLRoleDAO.class })
public class JDBCTableTests {

}