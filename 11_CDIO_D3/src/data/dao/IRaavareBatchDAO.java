package data.dao;

import data.dto.RaavareBatchDTO;

import java.util.List;

public interface IRaavareBatchDAO {
    RaavareBatchDTO getRaavareBatch(int rbId) throws DALException;
    List<RaavareBatchDTO> getRaavareBatchList() throws DALException;
    List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException;
    void createRaavareBatch(RaavareBatchDTO rb) throws DALException;
    void updateRaavareBatch(RaavareBatchDTO rb) throws DALException;
    void deleteRaavareBatch(int rbId) throws DALException;
}