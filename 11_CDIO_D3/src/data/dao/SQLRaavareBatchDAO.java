package data.dao;

import data.Connector;
import data.dto.RaavareBatchDTO;

import java.util.List;

public class SQLRaavareBatchDAO implements IRaavareBatchDAO {

    private final Connector connector;

    public SQLRaavareBatchDAO(Connector connector) {
        this.connector = connector;
    }

    @Override
    public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {
        return null;
    }

    @Override
    public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
        return null;
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