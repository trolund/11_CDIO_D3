package data.dao.view;

import java.util.List;

import data.DALException;
import data.dto.view.VAdminForemanPBCDTO;

public interface IVAdminForemanPBCDAO {
	List<VAdminForemanPBCDTO> getVAdminForemanPBC(int oprId) throws DALException;
	List<VAdminForemanPBCDTO> getVAdminForemanPBCList() throws DALException;
}