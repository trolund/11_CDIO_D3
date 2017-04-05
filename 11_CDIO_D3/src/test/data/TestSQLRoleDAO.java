package test.data;

import org.junit.After;
import org.junit.Before;

import data.Connector;
import data.dao.SQLRoleDAO;

public class TestSQLRoleDAO {

	/*
	 * Required objects.
	 */
	private SQLRoleDAO roleDAO;
	private final String spr = "#############";
	private final String lspr = spr + spr + spr + spr + spr + spr;

	/*
	 * Setting up the RoleDAO.
	 */
	@Before
	public void setUp() {
		roleDAO = new SQLRoleDAO(Connector.getInstance());
	}

	/*
	 * Resetting the RoleDAO.
	 */
	@After
	public void tearDown() {
		roleDAO = null;
	}

}