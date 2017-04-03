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
import data.dao.SQLProductBatchComponentDAO;
import data.dao.SQLProductBatchDAO;
import data.dao.SQLRaavareBatchDAO;
import data.dao.SQLRaavareDAO;
import data.dao.SQLReceptComponentDAO;
import data.dao.SQLReceptDAO;
import data.dao.SQLRoleDAO;
import data.dto.OperatorDTO;
import data.dto.ProductBatchComponentDTO;

public class TestJDBC {

	/*
	 * Objects of the tested DAO's.
	 */
	private SQLOperatorDAO oprDAO;
	private SQLProductBatchComponentDAO pbcDAO;
	private SQLProductBatchDAO pbDAO;
	private SQLRaavareBatchDAO rbDAO;
	private SQLRaavareDAO raavareDAO;
	private SQLReceptComponentDAO rcDAO;
	private SQLReceptDAO receptDAO;
	private SQLRoleDAO roleDAO;

	/*
	 * Database connector object.
	 * Needed for the DAO's.
	 */
	private final Connector connector = Connector.getInstance();

	/*
	 * Helper Strings to make the test prettier visually..
	 */
	private final String spr = "########";
	private final String lspr = spr + spr + spr + spr;

	/*
	 * Initial setup for the JUnit5 test.
	 */
	@Before
	public void setUp() {
		oprDAO = new SQLOperatorDAO(connector);
		pbcDAO = new SQLProductBatchComponentDAO(connector);
		pbDAO = new SQLProductBatchDAO(connector);
		rbDAO = new SQLRaavareBatchDAO(connector);
		raavareDAO = new SQLRaavareDAO(connector);
		rcDAO = new SQLReceptComponentDAO(connector);
		receptDAO = new SQLReceptDAO(connector);
		roleDAO = new SQLRoleDAO(connector);
	}

	/*
	 * Reseting the DAO's after each and every test below.
	 */
	@After
	public void tearDown() {
		oprDAO = null;
		pbcDAO = null;
		pbDAO = null;
		rbDAO = null;
		raavareDAO = null;
		rcDAO = null;
		receptDAO = null;
		roleDAO = null;
	}

	/*
	 * All these tests have the same goal in common, to test
	 * the backend SQL implementation to see whether they work
	 * as intended or not.
	 */
	public TestJDBC() {

	}

	/*
	 * Test for the SQLOperatorDAO object.
	 */
	@Test
	public void testSQLOperatorDAO() {
		System.out.println("\n\n" + lspr + " Testing SQLOperatorDAO " + lspr);

		/* Prereqs */
		try {
			oprDAO.deleteOperator(321);
		} catch (DALException e) {
			e.printStackTrace();
		}

		/* Testing SQLOperatorDAO.getOperator(oprId) */
		try {
			/* Positive test */
			int oprId = 1;
			int expected = oprId;

			System.out.println("\n" + spr + " Testing SQLOperatorDAO.getOperator(" + oprId + ") " + spr);
			System.out.println("Receiving OperatorDTO with oprId: " + oprId + ".");

			OperatorDTO oprDTO = oprDAO.getOperator(oprId);

			int actual = oprDTO.getOprId();

			assertEquals(actual, expected);

			System.out.println("Received: " + oprDTO);
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			fail("Failed: Failed to get existing OperatorDTO!");
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}

		/* Testing SQLOperatorDAO.getOperator(oprId) */
		try {
			/* Negative test */
			int oprId = 342;
			int expected = oprId;

			System.out.println("\n" + spr + " Testing SQLOperatorDAO.getOperator(" + oprId + ") " + spr);
			System.out.println("Receiving OperatorDTO with oprId: " + oprId + ".");

			OperatorDTO oprDTO = oprDAO.getOperator(oprId);
			int actual = oprDTO.getOprId();

			System.out.println("Received: " + oprDTO);
			fail("Failed: Received non-existent OperatorDTO!");
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}

		/* Testing SQLOperatorDAO.getOperatorList() */
		try {
			/* Positive test */
			List<OperatorDTO> oprList = oprDAO.getOperatorList();
			System.out.println("\n" + spr + " Testing SQLOperatorDAO.getOperatorList() " + spr);

			for (int i = 0; i < oprList.size(); i++) {
				System.out.println(i + ": " + oprList.get(i));
			}

			System.out.println(lspr + lspr);
		} catch (DALException e) {
			fail("Failed: Failed to get OperatorDTO list!");
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}

		/* Testing SQLOperatorDAO.createOperator() */
		try {
			/* Positive test */
			System.out.println("\n" + spr + " Testing SQLOperatorDAO.createOperator() " + spr);

			OperatorDTO oprDTO = new OperatorDTO(321, "Arnold", "ASN", "234234", "hellokitty");
			oprDAO.createOperator(oprDTO);

			System.out.println("Created: " + oprDTO);
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			fail("Failed: Failed to create OperatorDTO!");
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}

		/* Testing SQLOperatorDAO.createOperator() */
		try {
			/* Negative test */
			System.out.println("\n" + spr + " Testing SQLOperatorDAO.createOperator() " + spr);
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

		/* Testing SQLOperatorDAO.updateOperator() */
		System.out.println("\n" + spr + " Testing SQLOperatorDAO.updateOperator(oprDTO)" + spr);
		try {
			/* Positive test */
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

		/* Testing SQLOperatorDAO.updateOperator() */
		System.out.println("\n" + spr + " Testing SQLOperatorDAO.updateOperator(oprDTO)" + spr);
		try {
			/* Negative test */
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

		/* Testing SQLOperatorDAO.deleteOperator(oprId) */
		try {
			/* Positive test */
			int oprId = 321;
			System.out.println("\n" + spr + " SQLOperatorDAO.deleteOperator(" + oprId + ") " + spr);

			System.out.println("Deleting: " + oprDAO.getOperator(oprId));
			oprDAO.deleteOperator(oprId);
			System.out.println("Deleted!");

			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}

		System.out.println("\n" + lspr + lspr + lspr);
	}

	/*
	 * Test for the SQLProductBatchComponentDAO object.
	 */
	@Test
	public void testSQLProductBatchComponentDAO() {
		System.out.println("\n\n" + lspr + " Testing SQLProductBatchComponentDAO " + lspr);

		/* Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId) */
		try {
			/* Positive test */
			int pbId = 1;
			int rbId = 2;
			System.out.println(
					"\n" + spr + " Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId) " + spr);

			System.out.println("Getting ProductBatchComponent with pbId " + pbId + " and rbId " + rbId + ".");
			ProductBatchComponentDTO pbcDTO = pbcDAO.getProductBatchComponent(pbId, rbId);
			System.out.println("Received: " + pbcDTO);

			System.out.println(lspr + lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}
		System.out.println("\n" + lspr + lspr + lspr);
	}

	/*
	 * Test for the SQLProductBatchDAO object.
	 */
	@Test
	public void testSQLProductBatchDAO() {
		System.out.println("\n\n" + lspr + " Testing SQLProductBatchDAO " + lspr);
		System.out.println("\n" + lspr + lspr + lspr);
	}

	/*
	 * Test for the SQLRaavareBatchDAO object.
	 */
	@Test
	public void testSQLRaavareBatchDAO() {
		System.out.println("\n\n" + lspr + " Testing SQLRaavareBatchDAO " + lspr);
		System.out.println("\n" + lspr + lspr + lspr);
	}

	/*
	 * Test for the SQLRaavareDAO object.
	 */
	@Test
	public void testSQLRaavareDAO() {
		System.out.println("\n\n" + lspr + " Testing SQLRaavareDAO " + lspr);
		System.out.println("\n" + lspr + lspr + lspr);
	}

	/*
	 * Test for the SQLReceptComponentDAO object.
	 */
	@Test
	public void testSQLReceptComponentDAO() {
		System.out.println("\n\n" + lspr + " Testing SQLReceptComponentDAO " + lspr);
		System.out.println("\n" + lspr + lspr + lspr);
	}

	/*
	 * Test for the SQLReceptDAO object.
	 */
	@Test
	public void testSQLReceptDAO() {
		System.out.println("\n\n" + lspr + " Testing SQLReceptDAO " + lspr);
		System.out.println("\n" + lspr + lspr + lspr);
	}

	/*
	 * Test for the SQLRoleDAO object.
	 */
	@Test
	public void testSQLRoleDAO() {
		System.out.println("\n\n" + lspr + " Testing SQLRoleDAO " + lspr);
		System.out.println(lspr + lspr + lspr);
	}

}