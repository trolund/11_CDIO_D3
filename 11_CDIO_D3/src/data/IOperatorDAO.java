package data;

import java.util.List;

public interface IOperatorDAO {
    OperatorDTO getOperator(int oprId) throws DALException;
    List<OperatorDTO> getOperatorList() throws DALException;
    void createUser(OperatorDTO opr) throws DALException;
    void updateUser(OperatorDTO opr) throws DALException;
    void deleteUser(int oprId) throws DALException;

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