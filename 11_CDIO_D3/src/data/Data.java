package data;

import data.dao.DALException;
import data.dao.SQLOperatorDAO;
import data.dto.OperatorDTO;

public class Data implements IData {

    private final Connector conn;

    public Data() {
        this.conn = new Connector();

        SQLOperatorDAO operatorDAO = new SQLOperatorDAO(conn);
        try {
            OperatorDTO testDTO = operatorDAO.getOperator(1);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }

}