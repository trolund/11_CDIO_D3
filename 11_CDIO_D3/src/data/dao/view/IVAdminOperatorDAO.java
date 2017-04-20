package data.dao.view;

import java.util.List;

import data.DALException;
import data.dto.view.VAdminOperatorDTO;

public interface IVAdminOperatorDAO {
	VAdminOperatorDTO getVAdminOperator(int oprId) throws DALException;
	List<VAdminOperatorDTO> getVAdminOperatorList() throws DALException;
}