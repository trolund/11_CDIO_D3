package data.dao.view;

import java.util.List;

import data.DALException;
import data.dto.view.VOperatorRBDTO;

public interface IVOperatorRBDAO {
	VOperatorRBDTO getVOperatorRBDTO(int raavareId) throws DALException;
	List<VOperatorRBDTO> getVOperatorRBDTOList() throws DALException;
}