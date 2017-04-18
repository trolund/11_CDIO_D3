package data.dao;

import java.util.List;

import data.dto.VOperatorRBDTO;

public interface IVOperatorRBDAO {
	VOperatorRBDTO getVOperatorRBDTO(int raavareId) throws DALException;
	List<VOperatorRBDTO> getVOperatorRBDTOList() throws DALException;
}