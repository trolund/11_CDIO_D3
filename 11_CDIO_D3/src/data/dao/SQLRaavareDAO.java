package data.dao;

import java.util.List;

import data.Connector;
import data.dto.RaavareDTO;

public class SQLRaavareDAO implements IRaavareDAO {

	private final Connector connector;

	public SQLRaavareDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public RaavareDTO getRaavare(int raavareId) throws DALException {
		return null;
	}

	@Override
	public List<RaavareDTO> getRaavareList() throws DALException {
		return null;
	}

	@Override
	public void createRaavare(RaavareDTO raavare) throws DALException {

	}

	@Override
	public void updateRaavare(RaavareDTO raavare) throws DALException {

	}

	@Override
	public void deleteRaavare(int raavareId) throws DALException {

	}

}