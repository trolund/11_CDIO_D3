package data.dao;

import java.util.List;

import data.Connector;
import data.dto.ReceptDTO;

public class SQLReceptDAO implements IReceptDAO {

	private final Connector connector;

	public SQLReceptDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public ReceptDTO getRecept(int receptId) throws DALException {
		return null;
	}

	@Override
	public List<ReceptDTO> getReceptList() throws DALException {
		return null;
	}

	@Override
	public void createRecept(ReceptDTO recept) throws DALException {

	}

	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {

	}

	@Override
	public void deleteRecept(int receptId) throws DALException {

	}

}