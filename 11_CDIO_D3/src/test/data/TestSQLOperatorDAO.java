package test.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Connector;
import data.dao.DALException;
import data.dao.SQLOperatorDAO;
import data.dto.OperatorDTO;

public class TestSQLOperatorDAO {

	/*
	 * Required objects.
	 */
	private SQLOperatorDAO oprDAO;
	private Connector connector;

	/*
	 * Helper Strings to make the test prettier visually.
	 */
	private final String spr = "########";
	private final String lspr = spr + spr + spr + spr;

	/*
	 * Constructor used for Database connection initialization.
	 */
	public TestSQLOperatorDAO() {
		connector = Connector.getInstance();
	}

	/*
	 * Initial setup for the JUnit test.
	 */
	@Before
	public void setUp() {
		oprDAO = new SQLOperatorDAO(connector);
	}

	/*
	 * Reseting the DAO after each and every test below.
	 */
	@After
	public void tearDown() {
		oprDAO = null;
	}

	/* 
	 * Testing SQLOperatorDAO.getOperator(oprId)
	 * Positive test
	 */
	@Test
	public void testGetOperatorPositive() {
		try {
			int oprId = 1;
			int expected = oprId;

			System.out.println("\n" + spr + " Testing SQLOperatorDAO.getOperator(" + oprId + ") " + spr);
			System.out.println("Receiving OperatorDTO with oprId: " + oprId + ".");

			OperatorDTO oprDTO = oprDAO.getOperator(oprId);

			int actual = oprDTO.getOprId();

			assertEquals("Failed: Wrong OperatorDTO received!", actual, expected);

			System.out.println("Received: " + oprDTO);
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			fail("Failed: Failed to get existing OperatorDTO!");
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLOperatorDAO.getOperator(oprId)
	 * Negative test 
	 */
	@Test
	public void testGetOperatorNegative() {
		try {
			int oprId = 342;

			System.out.println("\n" + spr + " Testing SQLOperatorDAO.getOperator(" + oprId + ") " + spr);
			System.out.println("Receiving OperatorDTO with oprId: " + oprId + ".");

			OperatorDTO oprDTO = oprDAO.getOperator(oprId);

			System.out.println("Received: " + oprDTO);
			fail("Failed: Received non-existent OperatorDTO!");
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLOperatorDAO.getOperatorList()
	 * Positive test
	 */
	@Test
	public void testGetOperatorListPositive() {
		try {
			List<OperatorDTO> oprList = oprDAO.getOperatorList();
			System.out.println("\n" + spr + " Testing SQLOperatorDAO.getOperatorList() " + spr);

			for (int i = 0; i < oprList.size(); i++) {
				System.out.println(i + ": " + oprList.get(i));
			}

			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			fail("Failed: Failed to get OperatorDTO list!");
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLOperatorDAO.createOperator(oprDTO)
	 * Positive test
	 */
	@Test
	public void testCreateOperatorPositive() {
		try {
			int oprId = 321;
			System.out.println("\n" + spr + " Testing SQLOperatorDAO.createOperator(oprDTO) " + spr);

			OperatorDTO oprDTO = new OperatorDTO(oprId, "Arnold", "ASN", "234234", "hellokitty");
			oprDAO.createOperator(oprDTO);

			if (oprDAO.getOperator(oprId) != null) {
				System.out.println("Created: " + oprDAO.getOperator(oprId));
			}
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			fail("Failed: Failed to create OperatorDTO!");
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLOperatorDAO.createOperator(oprDTO)
	 * Negative test
	 */
	@Test
	public void testCreateOperatorNegative() {
		try {
			System.out.println("\n" + spr + " Testing SQLOperatorDAO.createOperator(oprDTO) " + spr);
			OperatorDTO oprDTO = new OperatorDTO(1, "Arnold", "ASN", "543876", "hellokitty");

			System.out.println("Creating: " + oprDTO);
			oprDAO.createOperator(oprDTO);
			System.out.println("Created: " + oprDTO);

			fail("Failed: Created already existing OperatorDTO!");
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLOperatorDAO.updateOperator()
	 * Positive test
	 */
	@Test
	public void testUpdateOperatorPositive() {
		System.out.println("\n" + spr + " Testing SQLOperatorDAO.updateOperator(oprDTO) " + spr);
		try {
			String oprName = "ArnoldSchwarz";
			String expected = oprName;

			OperatorDTO oprDTO = new OperatorDTO(321, oprName, "ASN", "1111111", "byekitty");
			oprDAO.updateOperator(oprDTO);

			String actual = oprDAO.getOperator(321).getOprName();
			assertEquals(expected, actual);
			System.out.println("Updated: " + oprDAO.getOperator(321));

			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}
	}

	/*
	 * Testing SQLOperatorDAO.updateOperator()
	 * Negative test 
	 */
	@Test
	public void testUpdateOperatorNegative() {
		System.out.println("\n" + spr + " Testing SQLOperatorDAO.updateOperator(oprDTO)" + spr);
		try {
			String oprName = "ArnoldSchwarz";

			OperatorDTO oprDTO = new OperatorDTO(500, oprName, "ASN", "1111111", "byekitty");
			oprDAO.updateOperator(oprDTO);
			System.out.println("Updated: " + oprDAO.getOperator(500));

			fail("Failed: Updated non-existent OperatorDTO!");
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLOperatorDAO.deleteOperator(oprId)
	 * Positive test
	 */
	@Test
	public void testDeleteOperatorPositive() {
		try {
			int oprId = 321;
			System.out.println("\n" + spr + " SQLOperatorDAO.deleteOperator(" + oprId + ") " + spr);

			System.out.println("Deleting: " + oprDAO.getOperator(oprId));
			oprDAO.deleteOperator(oprId);
			System.out.println("Deleted!");

			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			fail("Failed: Did not delete existing operator!");
			System.out.println(lspr + lspr);
		}
	}

}