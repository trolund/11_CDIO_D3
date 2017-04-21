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
import test.dao.view.TestSQLAdminForemanPBCDAO;
import test.dao.view.TestSQLAdminOperatorDAO;
import test.dao.view.TestSQLForemanOperatorDAO;
import test.dao.view.TestSQLOperatorRBDAO;
import test.dao.view.TestSQLOperatorRecipeDAO;
import test.dao.view.TestSQLPharmacistRecipeDAO;

/*
 * JUnit Test Suite used to run all JDBC unit tests at once.
 */
@RunWith(Suite.class)
@SuiteClasses({ TestSQLOperatorDAO.class, TestSQLProductBatchComponentDAO.class, TestSQLProductBatchDAO.class, TestSQLRaavareBatchDAO.class, TestSQLRaavareDAO.class, TestSQLReceptComponentDAO.class, TestSQLReceptDAO.class, TestSQLRoleDAO.class, TestSQLAdminForemanPBCDAO.class, TestSQLAdminOperatorDAO.class, TestSQLForemanOperatorDAO.class, TestSQLOperatorRBDAO.class, TestSQLOperatorRecipeDAO.class, TestSQLPharmacistRecipeDAO.class })
public class JDBCUnitTests {

}