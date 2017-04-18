package data.dao;

import java.util.List;

import data.Connector;
import data.dto.VAdminOperatorDTO;

public class SQLAdminOperatorDAO implements IVAdminOperatorDAO {

	/* Database Connector object */
	private final Connector connector;

	/* Constructor to retrieve the Database Connector object */
	public SQLAdminOperatorDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public VAdminOperatorDTO getVAdminOperator(int oprId) throws DALException {
		return null;
	}

	@Override
	public List<VAdminOperatorDTO> getVAdminOperatorList() throws DALException {
		return null;
	}

}