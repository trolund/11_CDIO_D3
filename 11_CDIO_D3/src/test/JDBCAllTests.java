package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.dao.TestListOperatorDAO;

/*
 * JUnit Test Suite used to run all unit tests at once.
 */
@RunWith(Suite.class)
@SuiteClasses({ JDBCTableTests.class, JDBCViewTests.class, TestListOperatorDAO.class })
public class JDBCAllTests {

}