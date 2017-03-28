package data.dao;

import data.Connector;
import data.dto.RaavareBatchDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLRaavareBatchDAO implements IRaavareBatchDAO {

    private final Connector connector;

    public SQLRaavareBatchDAO(Connector connector) {
        this.connector = connector;
    }

    @Override
    public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {
        String getRBSql = "SELECT * FROM raavarebatch WHERE rb_id = ?";
        PreparedStatement getRBStmt = null;
        ResultSet rs = null;
        try {
            getRBStmt = connector.getConnection().prepareStatement(getRBSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            getRBStmt.setInt(1, rbId);
            rs = getRBStmt.executeQuery();

            if (!rs.first())
                throw new DALException("RaavareBatch with rbId [" + rbId + "] does not exist!");

            return new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde"));
        } catch (SQLException e) {
            throw new DALException(e.getMessage(), e);
        } finally {
            try {
                connector.cleanup(getRBStmt, rs);
            } catch (SQLException e) {
                throw new DALException(e.getMessage(), e);
            }
        }
    }

    @Override
    public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
        String getRBListSql = "SELECT * FROM raavarebatch";
        List<RaavareBatchDTO> rbList = new ArrayList<>();
        PreparedStatement getRBListStmt = null;
        ResultSet rs = null;
        try {
            getRBListStmt = connector.getConnection().prepareStatement(getRBListSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = getRBListStmt.executeQuery();
            while (rs.next()) {
                rbList.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
            }
            return rbList;
        } catch (SQLException e) {
            throw new DALException(e.getMessage(), e);
        } finally {
            try {
                connector.cleanup(getRBListStmt, rs);
            } catch (SQLException e) {
                throw new DALException(e.getMessage(), e);
            }
        }
    }

    @Override
    public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
        return null;
    }

    @Override
    public void createRaavareBatch(RaavareBatchDTO rb) throws DALException {

    }

    @Override
    public void updateRaavareBatch(RaavareBatchDTO rb) throws DALException {

    }

    @Override
    public void deleteRaavareBatch(int rbId) throws DALException {

    }

}