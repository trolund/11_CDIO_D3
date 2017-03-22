package data.dao;

import data.Connector;
import data.dto.OperatorDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLOperatorDAO implements IOperatorDAO {

    private final Connector connector;

    public SQLOperatorDAO(Connector connector) {
        this.connector = connector;
    }

    @Override
    public OperatorDTO getOperator(int oprId) throws DALException {
        String getOprSql = "SELECT * FROM operatoer WHERE opr_id = ?";
        PreparedStatement getOprStmt = null;
        ResultSet rs = null;
        try {
            getOprStmt = connector.getConnection().prepareStatement(getOprSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            getOprStmt.setInt(1, oprId);
            rs = getOprStmt.executeQuery();

            if (!rs.first()) throw new DALException("Operator id [" + oprId + "] does not exist!");

            // ROLES SKAL IKKE VAERE NULL! FIND EN FIX.
            return new OperatorDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), null);
        } catch (SQLException e) {
            throw new DALException(e.getMessage(), e);
        } finally {
            try {
                connector.cleanup(getOprStmt, rs);
            } catch (SQLException e) {
                throw new DALException(e.getMessage(), e);
            }
        }
    }

    @Override
    public List<OperatorDTO> getOperatorList() throws DALException {
        String getOprListSql = "SELECT * FROM operatoer";
        List<OperatorDTO> oprList = new ArrayList<>();
        PreparedStatement getOprListStmt = null;
        ResultSet rs = null;
        try {
            getOprListStmt = connector.getConnection().prepareStatement(getOprListSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = getOprListStmt.executeQuery();
            while (rs.next()) {
                // ROLES SKAL IKKE VAERE NULL!!!!!!!!!!!!!!!
                oprList.add(new OperatorDTO(rs.getInt("opr_id"), rs.getString("opr_navn"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), null));
            }
            return oprList;
        } catch (SQLException e) {
            throw new DALException(e.getMessage(), e);
        } finally {
            try {
                connector.cleanup(getOprListStmt, rs);
            } catch (SQLException e) {
                throw new DALException(e.getMessage(), e);
            }
        }
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