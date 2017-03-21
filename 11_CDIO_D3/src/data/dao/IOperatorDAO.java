package data.dao;

import data.dto.OperatorDTO;

import java.util.List;

public interface IOperatorDAO {
    OperatorDTO getOperator(int oprId) throws DALException;
    List<OperatorDTO> getOperatorList() throws DALException;
    void createOperator(OperatorDTO opr) throws DALException;
    void updateOperator(OperatorDTO opr) throws DALException;
    void deleteOperator(int oprId) throws DALException; // I stedet for at slette operatoren, saa set den til at vaere inaktiv.
}