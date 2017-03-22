package data.dao;

import data.Connector;
import data.dto.OperatorDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLOperatorDAO implements IOperatorDAO {

    private final Connector conn;

    public SQLOperatorDAO(Connector conn) {
        this.conn = conn;
    }

    @Override
    public OperatorDTO getOperator(int oprId) throws DALException {
        String getOperatorSql = "SELECT * FROM operatoer WHERE opr_id = ?";
        PreparedStatement getOperatorStmt = null;
        ResultSet rs = null;
        try {
            getOperatorStmt = conn.getConnection().prepareStatement(getOperatorSql);
            getOperatorStmt.setInt(1, oprId);
            rs = getOperatorStmt.executeQuery();
            // TEMPORARY CODE FOR TESTING PURPOSES!!!!!
            List<String> tempList = new ArrayList<String>();
            tempList.add("user");
            return new OperatorDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), tempList);
        } catch (SQLException e) {
            throw new DALException(e.getMessage(), e);
        } finally {
            try {
                if (getOperatorStmt != null)
                    getOperatorStmt.close();
            } catch (SQLException e) {
                throw new DALException(e.getMessage(), e);
            }
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new DALException(e.getMessage(), e);
            }
        }
    }

    @Override
    public List<OperatorDTO> getOperatorList() throws DALException {
        return null;
    }

    @Override
    public void createOperator(OperatorDTO opr) throws DALException {

    }

    @Override
    public void updateOperator(OperatorDTO opr) throws DALException {

    }

    @Override
    public void deleteOperator(int oprId) throws DALException {

    }

}