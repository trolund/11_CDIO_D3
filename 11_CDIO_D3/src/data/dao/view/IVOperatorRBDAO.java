package data.dao.view;

import java.util.List;

import data.DALException;
import data.dto.view.VOperatorRBDTO;

public interface IVOperatorRBDAO {
	List<VOperatorRBDTO> getVOperatorRB(int raavareId) throws DALException;
	List<VOperatorRBDTO> getVOperatorRBList() throws DALException;
}