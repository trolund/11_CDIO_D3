package data.dao;

import data.dto.OperatorDTO;

import java.util.List;

public interface IOperatorDAO {
    OperatorDTO getOperator(int oprId) throws DALException;
    List<OperatorDTO> getOperatorList() throws DALException;
    void createUser(OperatorDTO opr) throws DALException;
    void updateUser(OperatorDTO opr) throws DALException;
    void deleteUser(int oprId) throws DALException; // I stedet for at slette operatoren, saa set den til at vaere inaktiv.
                                                    // True eller false, hvorvidt den er aktiv eller ikke.

    class DALException extends Exception {
        private static final long serialVersionUID = 1L;

        public DALException(String msg, Throwable e) {
            super(msg, e);
        }

        public DALException(String msg) {
            super(msg);
        }
    }

}