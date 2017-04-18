package data.dao;

import java.util.List;

import data.dto.VAdminForemanPBCDTO;

public interface IVAdminForemanPBCDAO {
	VAdminForemanPBCDTO getVAdminForemanPBC(int oprId) throws DALException;
	List<VAdminForemanPBCDTO> getVAdminForemanPBCList() throws DALException;
}