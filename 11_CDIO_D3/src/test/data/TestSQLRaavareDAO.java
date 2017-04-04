package test.data;

import org.junit.After;
import org.junit.Before;

import data.Connector;
import data.dao.SQLRaavareDAO;

public class TestSQLRaavareDAO {

	/*
	 * Required objects.
	 */
	private SQLRaavareDAO raavareDAO;
	private final String spr = "#############";
	private final String lspr = spr + spr + spr + spr + spr + spr;

	/*
	 * Setting up the RaavareDAO.
	 */
	@Before
	public void setUp() {
		raavareDAO = new SQLRaavareDAO(Connector.getInstance());
	}

	/*
	 * Resetting the RaavareDAO.
	 */
	@After
	public void tearDown() {
		raavareDAO = null;
	}

}