package test.dao;

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
			System.out.println("\n" + spr + " Testing ListOperatorDAO.getOperator(" + oprId + ") Negative " + spr);
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
	public void testGetOperatorListPositive() {
		try {
			System.out.println("\n" + spr + " Testing ListOperatorDAO.getOperatorList() Positive " + spr);
			for (OperatorDTO dto : oprDAO.getOperatorList()) {
				System.out.println(dto);
				if (dto == null) {
					fail("Failed: Null object returned!");
				}
			}
			System.out.println(lspr);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateOperatorPositive() {
		try {
			System.out.println("\n" + spr + " Testing ListOperatorDAO.createOperator() Positive " + spr);
			int oprId = 49;
			boolean expected = true;
			boolean actual = false;
			oprDAO.createOperator(new OperatorDTO(oprId, "Franco", "Francis", "6666-666-69", "666"));
			for (OperatorDTO dto : oprDAO.getOperatorList()) {
				if (dto.getOprId() == oprId) {
					actual = true;
					System.out.println("Found operator with id: " + oprId);
				}
			}
			assertEquals("Failed: Created Operator not found!", expected, actual);
			System.out.println(lspr);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateOperatorNegative() {
		try {
			System.out.println("\n" + spr + " Testing ListOperatorDAO.createOperator() Negative " + spr);
			int oprId = 101;
			oprDAO.createOperator(new OperatorDTO(oprId, "Franco", "Francis", "6666-666-69", "666"));
			fail("Failed: Managed to create existing operator!");
			System.out.println(lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr);
		}
	}

	@Test
	public void testUpdateOperatorPositive() {
		try {
			System.out.println("\n" + spr + " Testing ListOperatorDAO.updateOperator(oprDTO) Positive " + spr);
			int oprId = 99;
			oprDAO.createOperator(new OperatorDTO(oprId, "Jim", "JM", "999999-1122", "password"));
			System.out.println("Created: " + oprDAO.getOperator(oprId));

			oprDAO.updateOperator(new OperatorDTO(99, "Jim", "JIMMIE", "111111-4444", "nytpassword"));
			System.out.println("Updated: " + oprDAO.getOperator(oprId));
			System.out.println(lspr);

			String expected = "JIMMIE";
			String actual = oprDAO.getOperator(99).getOprIni();

			assertEquals("Failed: Did not update the DTO correctly.", expected, actual);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateOperatorNegative() {
		try {
			System.out.println("\n" + spr + " Testing ListOperatorDAO.updateOperator(oprDTO) Negative " + spr);
			int oprId = 99;
			oprDAO.createOperator(new OperatorDTO(oprId, "Jim", "JM", "999999-1122", "password"));
			System.out.println("Created: " + oprDAO.getOperator(oprId));

			oprDAO.updateOperator(new OperatorDTO(99, "Jim", "JIMMIE", "111111-4444", "nytpassword"));
			System.out.println("Updated: " + oprDAO.getOperator(oprId));
			System.out.println(lspr);

			String expected = "JIMMIE";
			String actual = oprDAO.getOperator(99).getOprIni();

			assertEquals("Failed: Did not update the DTO correctly.", expected, actual);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}