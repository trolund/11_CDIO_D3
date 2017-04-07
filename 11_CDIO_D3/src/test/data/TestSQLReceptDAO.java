package test.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

	/* 
	 * Testing SQLReceptDAO.getRecept(receptId)
	 * Positive atomic test
	 */
	@Test
	public void testGetReceptPositive() {

	}

	/* 
	 * Testing SQLReceptDAO.getRecept(receptId)
	 * Negative atomic test
	 */
	@Test
	public void testGetReceptNegative() {

	}

	/* 
	 * Testing SQLReceptDAO.getReceptList()
	 * Positive atomic test
	 */
	@Test
	public void testGetReceptListPositive() {

	}

	/*
	 * Testing SQLReceptDAO.createRecept(receptDTO)
	 * Positive atomic test
	 */
	@Test
	public void testCreateReceptPositive() {

	}

	/*
	 * Testing SQLReceptDAO.createRecept(receptDTO)
	 * Negative atomic test
	 */
	@Test
	public void testCreateReceptNegative() {

	}

	/* 
	 * Testing SQLReceptDAO.updateRecept(receptDTO)
	 * Positive atomic test
	 */
	@Test
	public void testUpdateReceptPositive() {

	}

	/*
	 * Testing SQLReceptDAO.deleteRecept(receptId)
	 * Positive atomic test
	 */
	@Test
	public void testDeleteReceptPositive() {

	}

}