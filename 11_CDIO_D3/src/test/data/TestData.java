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
import data.dto.OperatorDTO;

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
            System.out.println("\n##### Testing SQLOperatorDAO.getOperator(oprId) #####");
            System.out.println("##### Retrieving OperatorDTO from database... #####");
            System.out.println(oprDtoId1);
            System.out.println("###################################################\n");
        } catch (DALException e) {
            e.printStackTrace();
        }

        /* Testing SQLOperatorDAO.getOperatorList() */
        try {
            List<OperatorDTO> list = operatorDao.getOperatorList();

            System.out.println("##### Testing SQLOperatorDAO.getOperatirList() #####");
            System.out.println("##### Retrieving OperatorDTO from database... #####");
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
            System.out.println("###################################################\n");

        } catch (DALException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        TestData testData = new TestData();
        testData.testSQLoperatorDAO();
    }

}