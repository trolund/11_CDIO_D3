package test.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

	/* 
	 * Testing SQLReceptComponentDAO.getRC(receptId, raavareId)
	 * Positive atomic test
	 */
	@Test
	public void testGetRCPositive() {

	}

	/* 
	 * Testing SQLReceptComponentDAO.getRC(receptId, raavareId)
	 * Negative atomic test
	 */
	@Test
	public void testGetRCNegative() {

	}

	/* 
	 * Testing SQLReceptComponentDAO.getRCList()
	 * Positive atomic test
	 */
	@Test
	public void testGetRCListPositive() {

	}

	/* 
	 * Testing SQLReceptComponentDAO.getRCList(receptId)
	 * Positive atomic test
	 */
	@Test
	public void testGetRCListParameterPositive() {

	}

	/*
	 * Testing SQLReceptComponentDAO.createRC(rcDTO)
	 * Positive atomic test
	 */
	@Test
	public void testCreateRCPositive() {

	}

	/*
	 * Testing SQLReceptComponentDAO.createRC(rcDTO)
	 * Negative atomic test
	 */
	@Test
	public void testCreateRCNegative() {

	}

	/* 
	 * Testing SQLReceptComponentDAO.updateRC(rcDTO)
	 * Positive atomic test
	 */
	@Test
	public void testUpdateRCPositive() {

	}

	/*
	 * Testing SQLReceptComponentDAO.deleteRC(receptId, raavareId)
	 * Positive atomic test
	 */
	@Test
	public void testDeletePBCPositive() {

	}

}