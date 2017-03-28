package test.data;

/*
 * The only purpose of this class is to test the ongoing development of the data access layer.
 * This will not be a real data layer class, but only a temporary class where we can experiment
 * with the results and the data that we receive frorm the database.
 */

import data.Connector;
import data.IData;
import data.dao.DALException;
import data.dao.SQLOperatorDAO;
import data.dao.SQLProductBatchComponentDAO;
import data.dao.SQLProductBatchDAO;
import data.dto.OperatorDTO;
import data.dto.ProductBatchComponentDTO;
import data.dto.ProductBatchDTO;

import java.sql.SQLException;
import java.util.List;

public class TestData implements IData {

    private static Connector connector;

    public TestData() {
        this.connector = Connector.getInstance();
    }

    public static void testSQLoperatorDAO() {
        SQLOperatorDAO operatorDao = new SQLOperatorDAO(connector);

        /* Testing SQLOperatorDAO.getOperator(oprId) */
        try {
            OperatorDTO oprDTO = operatorDao.getOperator(1);
            System.out.println("\n##### Testing SQLOperatorDAO.getOperator(oprId) #####");
            System.out.println("Getting OperatorDTO with id 1.");
            System.out.println("Got: " + oprDTO);
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLOperatorDAO.getOperatorList() */
        try {
            List<OperatorDTO> list = operatorDao.getOperatorList();
            System.out.println("##### Testing SQLOperatorDAO.getOperatorList()  #####");
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLOperatorDAO.createOperator() */
        System.out.println("##### Testing SQLOperatorDAO.createOperator(oprDto) #####");
        try {
            OperatorDTO oprDTO = new OperatorDTO(666, "Arnold", "ASN", "234234", "hellokitty");
            operatorDao.createOperator(oprDTO);
            System.out.println("Created: " + oprDTO);
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }

        /* Testing SQLOperatorDAO.updateOperator() */
        System.out.println("##### Testing SQLOperatorDAO.updateOperator(oprDto) #####");
        try {
            OperatorDTO oprDto = new OperatorDTO(666, "Arnold", "ASN", "234234", "byekitty");
            operatorDao.updateOperator(oprDto);
            System.out.println("Updated: " + operatorDao.getOperator(666));
            System.out.println("#########################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLOperatorDAO.deleteOperator(oprId) */
        System.out.println("##### Testing SQLOperatorDAO.deleteOperator(oprId) #####");
        try {
            operatorDao.deleteOperator(666);
            System.out.println("Deleted operator with ID 666.");
            System.out.println("#########################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLOperatorDAO.getOperatorList() */
        try {
            List<OperatorDTO> list = operatorDao.getOperatorList();
            System.out.println("##### Testing SQLOperatorDAO.getOperatorList()  #####");
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

    }

    public static void testSQLProductBatchComponentDAO() {
        SQLProductBatchComponentDAO SQLProductBatchCompDao = new SQLProductBatchComponentDAO(connector);

        /* Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId) */
        try {
            System.out.println("##### Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId) #####");
            System.out.println("Getting ProductBatchComponent with pbId 1 and rbId 2.");
            ProductBatchComponentDTO pbcDTO = SQLProductBatchCompDao.getProductBatchComponent(1, 2);
            System.out.println("Got: " + pbcDTO);
        } catch (DALException e) {
            e.printStackTrace();
        }
        System.out.println("####################################################################################\n");

        /* Testing SQLProductBatchComponentDAO.getProductBatchComponentList() */
        try {
            List<ProductBatchComponentDTO> list = SQLProductBatchCompDao.getProductBatchComponentList();
            System.out.println("##### Testing SQLProductBatchComponentDAO.getProductBatchComponentList() #####");
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLProductBatchComponentDAO.getProductBatchComponentList(pbId) */
        try {
            List<ProductBatchComponentDTO> list = SQLProductBatchCompDao.getProductBatchComponentList(4);
            System.out.println("##### Testing SQLProductBatchComponentDAO.getProductBatchComponentList(pbId) #####");
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLProductBatchComponentDAO.createProductBatchComponent() */
        System.out.println("##### Testing SQLProductBatchComponentDAO.createPBC(pbcDTO) #####");
        try {
            ProductBatchComponentDTO pbcDTO = new ProductBatchComponentDTO(1, 6, 20.5, 10.5, 1);
            SQLProductBatchCompDao.createProductBatchComponent(pbcDTO);
            System.out.println("Created: " + pbcDTO);
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }

        /* Testing SQLProductBatchComponentDAO.updatePBC(pbcDTO) */
        System.out.println("##### Testing SQLProductBatchComponentDAO.updateProductBatchComponent(pbcDTO) #####");
        try {
            ProductBatchComponentDTO pbcDTO = new ProductBatchComponentDTO(1, 6, 30.2, 50.2, 1);
            SQLProductBatchCompDao.updateProductBatchComponent(pbcDTO);
            System.out.println("Updated: " + SQLProductBatchCompDao.getProductBatchComponent(1, 6));
            System.out.println("#########################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLProductBatchComponentDAO.deletePBC(pbId, rbId) */
        System.out.println("##### SQLProductBatchComponentDAO.deletePBC(pbId, rbId) #####");
        try {
            SQLProductBatchCompDao.deleteProductBatchComponent(1, 6);
            System.out.println("Deleted ProductBatchComponent with pbId 1 and rbId 6.");
            System.out.println("#########################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLProductBatchComponentDAO.getProductBatchComponentList() */
        try {
            List<ProductBatchComponentDTO> list = SQLProductBatchCompDao.getProductBatchComponentList();
            System.out.println("##### Testing SQLProductBatchComponentDAO.getProductBatchComponentList() #####");
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

    }

    public static void testSQLProductBatch() {
        SQLProductBatchDAO pbDAO = new SQLProductBatchDAO(connector);

        /* Testing SQLProductBatchDAO.getProductBatch(pbId) */
        try {
            System.out.println("##### Testing SQLProductBatchDAO.getProductBatch(pbId) #####");
            ProductBatchDTO pbDTO = pbDAO.getProductBatch(3);
            System.out.println("Got: " + pbDTO);
        } catch (DALException e) {
            e.printStackTrace();
        }
        System.out.println("####################################################################################\n");

        /* Testing SQLProductBatchDAO.getProductBatchList() */
        try {
            List<ProductBatchDTO> list = pbDAO.getProductBatchList();
            System.out.println("##### Testing SQLProductBatchDAO.getProductBatchList() #####");
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLProductBatchDAO.createProductBatch() */
        System.out.println("##### Testing SQLProductBatchDAO.createPB(pbDTO) #####");
        try {
            ProductBatchDTO pbDTO = new ProductBatchDTO(9, 4, 3);
            pbDAO.createProductBatch(pbDTO);
            System.out.println("Created: " + pbDTO);
            System.out.println("#####################################################\n");
        } catch (DALException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }

        /* Testing SQLProductBatchDAO.updatePB(pbDTO) */
        System.out.println("##### Testing SQLProductBatchDAO.updateProductBatch(pbDTO) #####");
        try {
            ProductBatchDTO pbDTO = new ProductBatchDTO(9, 10, 3);
            pbDAO.updateProductBatch(pbDTO);
            System.out.println("Updated: " + pbDAO.getProductBatch(9));
            System.out.println("#########################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLProductBatchDAO.deletePB(pbId) */
        System.out.println("##### SQLProductBatchDAO.deletePB(pbId) #####");
        try {
            pbDAO.deleteProductBatch(9);
            System.out.println("Deleted ProductBatch with id 9.");
            System.out.println("#########################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestData testData = new TestData();
        System.out.println("\n################### Testing SQLOperatorDAO ###################");
        testData.testSQLoperatorDAO();
        System.out.println("\n\n\n################### Testing SQLProductBatchComponentDAO ###################\n");
        testData.testSQLProductBatchComponentDAO();
        System.out.println("\n\n\n################### Testing SQLProductBatchDAO ###################\n");
        testData.testSQLProductBatch();
        try {
            connector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}