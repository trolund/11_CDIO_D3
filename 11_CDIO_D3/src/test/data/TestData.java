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
import data.dto.OperatorDTO;
import data.dto.ProductBatchComponentDTO;

import java.util.List;

public class TestData implements IData {

    private final Connector connector;

    public TestData() {
        this.connector = Connector.getInstance();
    }

    public void testSQLoperatorDAO() {
        SQLOperatorDAO operatorDao = new SQLOperatorDAO(connector);

        /* Testing SQLOperatorDAO.getOperator(oprId) */
        try {
            OperatorDTO oprDtoId1 = operatorDao.getOperator(1);
            System.out.println("\n##### Testing SQLOperatorDAO.getOperator(oprId) #####\n");
            System.out.println(oprDtoId1);
            System.out.println("\n#####################################################\n\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLOperatorDAO.getOperatorList() */
        try {
            List<OperatorDTO> list = operatorDao.getOperatorList();

            System.out.println("##### Testing SQLOperatorDAO.getOperatorList()  #####\n");
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
            System.out.println("\n#####################################################\n\n");

        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLOperatorDAO.createOperator() */
        System.out.println("##### Testing SQLOperatorDAO.createOperator(oprDto) #####");
        try {
            OperatorDTO oprDto = new OperatorDTO(666, "Arnold", "ASN", "234234", "hellokitty", null);
            operatorDao.createOperator(oprDto);
            System.out.println("#####################################################\n\n");
        } catch (DALException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }

        /* Testing SQLOperatorDAO.updateOperator() */
        System.out.println("##### Testing SQLOperatorDAO.updateOperator(oprDto) #####\n");
        try {
            OperatorDTO oprDto = new OperatorDTO(666, "Arnold", "ASN", "234234", "hellokittyunderwear", null);
            operatorDao.updateOperator(oprDto);
            System.out.println(operatorDao.getOperator(666));
            System.out.println("\n#########################################################\n\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

    }

    public void testSQLProductBatchComponentDAO() {
        SQLProductBatchComponentDAO SQLProductBatchCompDao = new SQLProductBatchComponentDAO(connector);

        /* Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId) */
        try {
            System.out.println("##### Testing SQLProductBatchComponentDAO.getProductBatchComponent(pbId, rbId) #####\n");
            ProductBatchComponentDTO pbcDTO = SQLProductBatchCompDao.getProductBatchComponent(1, 2);
            System.out.println(pbcDTO);
        } catch (DALException e) {
            e.printStackTrace();
        }
        System.out.println("\n####################################################################################\n\n");

        /* Testing SQLProductBatchComponentDAO.getProductBatchComponentList() */
        try {
            List<ProductBatchComponentDTO> list = SQLProductBatchCompDao.getProductBatchComponentList();
            System.out.println("\n##### Testing SQLProductBatchComponentDAO.getProductBatchComponentList() #####\n");
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
            System.out.println("\n#####################################################\n\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLProductBatchComponentDAO.createProductBatchComponent() */
        System.out.println("\n##### Testing SQLProductBatchComponentDAO.createPBC(pbcDTO) #####");
        try {
            ProductBatchComponentDTO pbcDTO = new ProductBatchComponentDTO(1, 6, 20.5, 10.5, 1);
            SQLProductBatchCompDao.createProductBatchComponent(pbcDTO);
            System.out.println("Created: " + pbcDTO);
            System.out.println("#####################################################\n\n");
        } catch (DALException e) {
            System.out.println("\n" + e.getMessage() + "\n");
        }

        /* Testing SQLProductBatchComponentDAO.updatePBC(pbcDTO) */
        System.out.println("##### Testing SQLProductBatchComponentDAO.updateProductBatchComponent(pbcDto) #####\n");
        try {
            ProductBatchComponentDTO pbcDTO = new ProductBatchComponentDTO(4, 6, 22.2, 22.2, 3);
            SQLProductBatchCompDao.updateProductBatchComponent(pbcDTO);
            System.out.println(SQLProductBatchCompDao.getProductBatchComponent(4, 6));
            System.out.println("\n#########################################################\n\n");
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
    }

}