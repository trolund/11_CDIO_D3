package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.dao.view.TestSQLAdminForemanPBCDAO;
import test.dao.view.TestSQLAdminOperatorDAO;
import test.dao.view.TestSQLForemanOperatorDAO;
import test.dao.view.TestSQLOperatorRBDAO;
import test.dao.view.TestSQLOperatorRecipeDAO;
import test.dao.view.TestSQLPharmacistRecipeDAO;

/*
 * JUnit Test Suite used to run all View unit tests at once.
 */
@RunWith(Suite.class)
@SuiteClasses({ TestSQLAdminForemanPBCDAO.class, TestSQLAdminOperatorDAO.class, TestSQLForemanOperatorDAO.class, TestSQLOperatorRBDAO.class, TestSQLOperatorRecipeDAO.class, TestSQLPharmacistRecipeDAO.class })
public class JDBCViewTests {

}