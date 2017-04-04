package test.data;

import org.junit.After;
import org.junit.Before;

import data.Connector;
import data.dao.SQLReceptDAO;

public class TestSQLReceptDAO {

	/*
	 * Required objects.
	 */
	private SQLReceptDAO receptDAO;
	private final String spr = "#############";
	private final String lspr = spr + spr + spr + spr + spr + spr;

	/*
	 * Setting up the ReceptDAO.
	 */
	@Before
	public void setUp() {
		receptDAO = new SQLReceptDAO(Connector.getInstance());
	}

	/*
	 * Resetting the ReceptDAO.
	 */
	@After
	public void tearDown() {
		receptDAO = null;
	}

}