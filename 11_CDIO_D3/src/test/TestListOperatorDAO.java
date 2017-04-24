package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.DALException;
import data.dao.ListOperatorDAO;
import data.dto.OperatorDTO;

public class TestListOperatorDAO {

	/*
	 * Required objects.
	 */
	private ListOperatorDAO oprDAO;
	private final String spr = "#############";
	private final String lspr = spr + spr + spr + spr + spr + spr;

	/*
	 * Setting up the operator DAO.
	 */
	@Before
	public void setUp() {
		oprDAO = new ListOperatorDAO();
	}

	/*
	 * Resetting the operator DAO.
	 */
	@After
	public void tearDown() {
		oprDAO = null;
	}

	@Test
	public void testGetOperatorPositive() {
		OperatorDTO dto = null;
		int oprId = 101;

		try {
			System.out.println("\n" + spr + " Testing ListOperatorDAO.getOperator(" + oprId + ") Positive " + spr);
			dto = oprDAO.getOperator(oprId);
			System.out.println(dto);
			System.out.println(lspr);
		} catch (DALException e) {
			e.printStackTrace();
		} finally {
			int actual = dto.getOprId();
			int expected = oprId;
			assertEquals("Failed: Got wrong oprId number.", expected, actual);
		}
	}

	@Test
	public void testGetOperatorNegative() {
		int oprId = 2342;
		try {
			System.out.println("\n" + spr + " Testing ListOperatorDAO.getOperator(" + oprId + ") Positive " + spr);
			OperatorDTO dto = oprDAO.getOperator(oprId);
			int expected = oprId;
			int actual = dto.getOprId();
			assertEquals("Failed: Received non-existing operator!", expected, actual);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr);
		}
	}

	@Test
	public void testGetOperatorList() {
		try {
			System.out.println("\n" + spr + " Testing ListOperatorDAO.getOperatorList() " + spr);
			for (OperatorDTO dto : oprDAO.getOperatorList()) {
				if (dto == null) {
					fail("Failed: Null object returned!");
				}
			}
			System.out.println(lspr);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}