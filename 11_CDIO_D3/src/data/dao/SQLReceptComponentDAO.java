package data.dao;

import data.dto.ReceptComponentDTO;

import java.util.List;

public class SQLReceptComponentDAO implements IReceptComponentDAO {

    @Override
    public ReceptComponentDTO getReceptComponent(int receptId, int raavareId) throws DALException {
        return null;
    }

    @Override
    public List<ReceptComponentDTO> getReceptComponentList(int receptId) throws DALException {
        return null;
    }

    @Override
    public List<ReceptComponentDTO> getReceptComponentList() throws DALException {
        return null;
    }

    @Override
    public void createReceptComponent(ReceptComponentDTO rc) throws DALException {

    }

    @Override
    public void updateReceptComponent(ReceptComponentDTO rc) throws DALException {

    }

    @Override
    public void deleteReceptComponent(int receptId, int raavareId) throws DALException {

    }

}