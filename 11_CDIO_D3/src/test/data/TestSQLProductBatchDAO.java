package test.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Connector;
import data.dao.SQLProductBatchDAO;

public class TestSQLProductBatchDAO {

	/*
	 * Required objects.
	 */
	private SQLProductBatchDAO pbDAO;
	private Connector connector;

	/*
	 * Helper Strings to make the test prettier visually.
	 */
	private final String spr = "########";
	private final String lspr = spr + spr + spr + spr;

	/*
	 * Constructor used for Database connection initialization.
	 */
	public TestSQLProductBatchDAO() {
		connector = Connector.getInstance();
	}

	/*
	 * Initial setup for the JUnit test.
	 */
	@Before
	public void setUp() {
		pbDAO = new SQLProductBatchDAO(connector);
	}

	/*
	 * Reseting the DAO after each and every test below.
	 */
	@After
	public void tearDown() {
		pbDAO = null;
	}

	@Test
	public void testGetPBPositive() {

	}

	@Test
	public void testGetPBNegative() {

	}

}