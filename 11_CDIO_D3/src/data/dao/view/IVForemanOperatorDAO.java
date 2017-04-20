package data.dao.view;

import java.util.List;

import data.DALException;
import data.dto.view.VForemanOperatorDTO;

public interface IVForemanOperatorDAO {
	VForemanOperatorDTO getVForemanOperator(int oprId) throws DALException;
	List<VForemanOperatorDTO> getVForemanOperatorList(int oprId) throws DALException;
}