package test.data;

import org.junit.After;
import org.junit.Before;

import data.Connector;
import data.dao.SQLRaavareBatchDAO;

public class TestSQLRaavareBatchDAO {

	/*
	 * Required objects.
	 */
	private SQLRaavareBatchDAO rbDAO;
	private final String spr = "#############";
	private final String lspr = spr + spr + spr + spr + spr + spr;

	/*
	 * Setting up the RaavareBatchDAO.
	 */
	@Before
	public void setUp() {
		rbDAO = new SQLRaavareBatchDAO(Connector.getInstance());
	}

	/*
	 * Resetting the RaavareBatchDAO.
	 */
	@After
	public void tearDown() {
		rbDAO = null;
	}

}