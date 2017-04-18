package data.dao;

import java.util.List;

import data.Connector;
import data.dto.VOperatorRBDTO;

public class SQLOperatorRBDAO implements IVOperatorRBDAO {

	/* Database Connector object */
	private final Connector connector;

	/* Constructor to retrieve the Database Connector object */
	public SQLOperatorRBDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public VOperatorRBDTO getVOperatorRBDTO(int raavareId) throws DALException {
		return null;
	}

	@Override
	public List<VOperatorRBDTO> getVOperatorRBDTOList() throws DALException {
		return null;
	}

}