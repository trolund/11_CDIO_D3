package test.data;

import org.junit.After;
import org.junit.Before;

import data.Connector;
import data.dao.SQLProductBatchDAO;

public class TestSQLProductBatchDAO {

	/*
	 * Required objects.
	 */
	private SQLProductBatchDAO pbDAO;
	private final String spr = "#############";
	private final String lspr = spr + spr + spr + spr + spr + spr;

	/*
	 * Setting up the ProductBatchDAO.
	 */
	@Before
	public void setUp() {
		pbDAO = new SQLProductBatchDAO(Connector.getInstance());
	}

	/*
	 * Resetting the ProductBatchDAO.
	 */
	@After
	public void tearDown() {
		pbDAO = null;
	}

}