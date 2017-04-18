package data.dao;

import java.util.List;

import data.dto.VAdminOperatorDTO;

public interface IVAdminOperatorDAO {
	VAdminOperatorDTO getVAdminOperator(int oprId) throws DALException;
	List<VAdminOperatorDTO> getVAdminOperatorList() throws DALException;
}