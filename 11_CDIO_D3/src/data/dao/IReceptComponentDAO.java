package data.dao;

import data.dto.ReceptComponentDTO;

import java.util.List;

public interface IReceptComponentDAO {
    ReceptComponentDTO getReceptComponent(int receptId, int raavareId) throws DALException;
    List<ReceptComponentDTO> getReceptComponentList(int receptId) throws DALException;
    List<ReceptComponentDTO> getReceptComponentList() throws DALException;
    void createReceptComponent(ReceptComponentDTO rc) throws DALException;
    void updateReceptComponent(ReceptComponentDTO rc) throws DALException;
    void deleteReceptComponent(int receptId, int raavareId) throws DALException;
}