package test.data;

import data.Connector;
import data.dao.*;
import org.junit.jupiter.api.Test;

class TestJDBC {

    SQLOperatorDAO oprDAO;
    SQLProductBatchComponentDAO pbcDAO;
    SQLProductBatchDAO pbDAO;
    SQLRaavareBatchDAO rbDAO;
    SQLRaavareDAO raavareDAO;
    SQLReceptComponentDAO rcDAO;
    SQLReceptDAO receptDAO;
    SQLRoleDAO roleDAO;
    private final Connector connector = Connector.getInstance();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        oprDAO = new SQLOperatorDAO(connector);
        pbcDAO = new SQLProductBatchComponentDAO(connector);
        pbDAO = new SQLProductBatchDAO(connector);
        rbDAO = new SQLRaavareBatchDAO(connector);
        raavareDAO = new SQLRaavareDAO(connector);
        rcDAO = new SQLReceptComponentDAO(connector);
        receptDAO = new SQLReceptDAO(connector);
        roleDAO = new SQLRoleDAO(connector);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        oprDAO = null;
        pbcDAO = null;
        pbDAO = null;
        rbDAO = null;
        raavareDAO = null;
        rcDAO = null;
        receptDAO = null;
        roleDAO = null;
    }

    @Test
    public void testSQLOperatorDAO() {

    }

    @Test
    public void testSQLProductBatchComponentDAO() {

    }

    @Test
    public void testSQLProductBatchDAO() {

    }

    @Test
    public void testSQLRaavareBatchDAO() {

    }

    @Test
    public void testSQLRaavareDAO() {

    }

    @Test
    public void testSQLReceptComponentDAO() {

    }

    @Test
    public void testSQLReceptDAO() {

    }

    @Test
    public void testSQLRoleDAO() {

    }

}