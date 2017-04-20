package data.dao.view;

import java.util.List;

import data.Connector;
import data.DALException;
import data.dto.view.VForemanOperatorDTO;

public class SQLForemanOperatorDAO implements IVForemanOperatorDAO {

	/* Database Connector object */
	private final Connector connector;

	/* Constructor to retrieve the Database Connector object */
	public SQLForemanOperatorDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public VForemanOperatorDTO getVForemanOperator(int oprId) throws DALException {
		return null;
	}

	@Override
	public List<VForemanOperatorDTO> getVForemanOperatorList(int oprId) throws DALException {
		return null;
	}

}