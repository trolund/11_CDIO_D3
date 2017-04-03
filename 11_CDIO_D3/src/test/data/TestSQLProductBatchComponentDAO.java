package test.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Connector;
import data.dao.DALException;
import data.dao.SQLProductBatchComponentDAO;
import data.dto.ProductBatchComponentDTO;

public class TestSQLProductBatchComponentDAO {

	/*
	 * Required objects.
	 */
	private SQLProductBatchComponentDAO pbcDAO;
	private Connector connector;

	/*
	 * Helper Strings to make the test prettier visually.
	 */
	private final String spr = "########";
	private final String lspr = spr + spr + spr + spr;

	/*
	 * Constructor used for Database connection initialization.
	 */
	public TestSQLProductBatchComponentDAO() {
		connector = Connector.getInstance();
	}

	/*
	 * Initial setup for the JUnit test.
	 */
	@Before
	public void setUp() {
		pbcDAO = new SQLProductBatchComponentDAO(connector);
	}

	/*
	 * Reseting the DAO after each and every test below.
	 */
	@After
	public void tearDown() {
		pbcDAO = null;
	}

	/* 
	 * Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId)
	 * Positive test
	 */
	@Test
	public void testGetPBCPositive() {
		try {
			int pbId = 1;
			int rbId = 2;
			System.out.println(
					"\n" + spr + " Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId) " + spr);

			System.out.println("Getting ProductBatchComponent with pbId " + pbId + " and rbId " + rbId + ".");
			ProductBatchComponentDTO pbcDTO = pbcDAO.getProductBatchComponent(pbId, rbId);
			System.out.println("Received: " + pbcDTO);

			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			fail("Failed: Failed to get existing ProductBatchComponentDTO!");
			System.out.println(lspr + lspr);
		}
	}

	/*
	 * Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId)
	 * Negative test 
	 */
	@Test
	public void testGetPBCNegative() {
		try {
			int pbId = 1234;
			int rbId = 254;
			System.out.println(
					"\n" + spr + " Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId) " + spr);

			System.out.println("Getting ProductBatchComponent with pbId " + pbId + " and rbId " + rbId + ".");
			ProductBatchComponentDTO pbcDTO = pbcDAO.getProductBatchComponent(pbId, rbId);
			System.out.println("Received: " + pbcDTO);

			fail("Failed: Received non-existent ProductBatchComponentDTO!");
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLProductBatchComponentDAO.getPBCList()
	 * Positive test
	 */
	@Test
	public void testGetPBCListPositive() {
		try {
			List<ProductBatchComponentDTO> pbcList = pbcDAO.getProductBatchComponentList();
			System.out
					.println("\n" + spr + " Testing SQLProductBatchComponentDAO.getProductBatchComponentList() " + spr);

			for (int i = 0; i < pbcList.size(); i++) {
				System.out.println(i + ": " + pbcList.get(i));
			}

			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			fail("Failed: Failed to get ProductBatchComponentlist!");
			System.out.println(lspr + lspr);
		}
	}

	/*
	 * Testing SQLProductBatchComponentDAO.createPBC(pbcDTO)
	 * Positive test
	 */
	@Test
	public void testCreatePBCPositive() {
		try {
			System.out.println("\n" + spr + " SQLProductBatchComponentDAO.createPBC(pbcDTO) " + spr);

			ProductBatchComponentDTO pbcDTO = new ProductBatchComponentDTO(5, 2, 12.34, 43.21, 1);
			pbcDAO.createProductBatchComponent(pbcDTO);

			System.out.println("Created: " + pbcDTO);
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			fail("Failed: Failed to create ProductBatchComponentDTO!");
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLProductBatchComponentDAO.createPBC(pbcDTO)
	 * Negative test
	 */
	@Test
	public void testCreatePBCNegative() {
		try {
			System.out.println("\n" + spr + " SQLProductBatchComponentDAO.createPBC(pbcDTO) " + spr);

			ProductBatchComponentDTO pbcDTO = new ProductBatchComponentDTO(1, 1, 12.34, 43.21, 1);
			pbcDAO.createProductBatchComponent(pbcDTO);

			System.out.println("Created: " + pbcDTO);
			fail("Failed: Created already existing ProductBatchComponentDTO!");
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLProductBatchComponentDAO.updatePBC(pbcDTO)
	 * Positive test
	 */
	@Test
	public void testUpdatePBCPositive() {
		System.out.println("\n" + spr + " TSQLProductBatchComponentDAO.updatePBC(pbcDTO) " + spr);
		try {
			double newTara = 1000.433;
			double expected = newTara;

			ProductBatchComponentDTO pbcDTO = new ProductBatchComponentDTO(5, 2, newTara, 999.99, 1);
			pbcDAO.updateProductBatchComponent(pbcDTO);

			double actual = pbcDAO.getProductBatchComponent(5, 2).getTara();
			assertEquals("Failed: PBC Tara was not updated succesfully!", expected, actual, 0);

			System.out.println("Updated: " + pbcDAO.getProductBatchComponent(5, 2));
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLProductBatchComponentDAO.updatePBC(pbcDTO)
	 * Negative test
	 */
	@Test
	public void testUpdatePBCNegative() {
		System.out.println("\n" + spr + " TSQLProductBatchComponentDAO.updatePBC(pbcDTO) " + spr);
		try {
			ProductBatchComponentDTO pbcDTO = new ProductBatchComponentDTO(32, 2, 1000.433, 999.99, 1);
			pbcDAO.updateProductBatchComponent(pbcDTO);

			System.out.println("Updated: " + pbcDAO.getProductBatchComponent(32, 2));
			fail("Failed: Updated non-existent ProductBatchComponentDTO!");
			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			System.out.println(lspr + lspr);
		}
	}

	/* 
	 * Testing SQLProductBatchComponentDAO.deletePBC() 
	 * Positive test
	 */
	@Test
	public void testDeletePBCPositive() {
		try {
			int pbId = 5;
			int rbId = 2;
			System.out.println("\n" + spr + " SQLProductBatchComponent.deletePBC(" + pbId + ", " + rbId + ")" + spr);

			System.out.println("Deleting: " + pbcDAO.getProductBatchComponent(pbId, rbId));
			pbcDAO.deleteProductBatchComponent(pbId, rbId);
			System.out.println("Deleted!");

			System.out.println(lspr + lspr);
		} catch (DALException e) {
			System.out.println(e.getMessage());
			fail("Failed: Did not delete existing ProductBatchComponentDTO!");
			System.out.println(lspr + lspr);
		}
	}

}