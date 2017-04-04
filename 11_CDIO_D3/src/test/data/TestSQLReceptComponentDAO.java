package test.data;

import org.junit.After;
import org.junit.Before;

import data.Connector;
import data.dao.SQLReceptComponentDAO;

public class TestSQLReceptComponentDAO {

	/*
	 * Required objects.
	 */
	private SQLReceptComponentDAO rcDAO;
	private final String spr = "#############";
	private final String lspr = spr + spr + spr + spr + spr + spr;

	/*
	 * Setting up the ReceptComponentDAO.
	 */
	@Before
	public void setUp() {
		rcDAO = new SQLReceptComponentDAO(Connector.getInstance());
	}

	/*
	 * Resetting the ReceptComponentDAO.
	 */
	@After
	public void tearDown() {
		rcDAO = null;
	}

}