package test.data;

import org.junit.After;
import org.junit.Before;

import data.Connector;
import data.dao.SQLProductBatchComponentDAO;

public class TestSQLProductBatchComponentDAO {

	/*
	 * Required objects.
	 */
	private SQLProductBatchComponentDAO pbcDAO;
	private final String spr = "#############";
	private final String lspr = spr + spr + spr + spr + spr + spr;

	/*
	 * Setting up the PBC DAO.
	 */
	@Before
	public void setUp() {
		pbcDAO = new SQLProductBatchComponentDAO(Connector.getInstance());
	}

	/*
	 * Resetting the PBC DAO.
	 */
	@After
	public void tearDown() {
		pbcDAO = null;
	}

}