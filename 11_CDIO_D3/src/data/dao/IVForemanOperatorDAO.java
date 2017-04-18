package data.dao;

import java.util.List;

import data.dto.VForemanOperatorDTO;

public interface IVForemanOperatorDAO {
	VForemanOperatorDTO getVForemanOperator(int oprId) throws DALException;
	List<VForemanOperatorDTO> getVForemanOperatorList(int oprId) throws DALException;
}