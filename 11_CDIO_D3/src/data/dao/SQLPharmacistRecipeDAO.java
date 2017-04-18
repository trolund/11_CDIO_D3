package data.dao;

import java.util.List;

import data.Connector;
import data.dto.VPharmacistRecipeDTO;

public class SQLPharmacistRecipeDAO implements IVPharmacistRecipeDAO {

	/* Database Connector object */
	private final Connector connector;

	/* Constructor to retrieve the Database Connector object */
	public SQLPharmacistRecipeDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public VPharmacistRecipeDTO getVPharmacistRecipe(int receptId) throws DALException {
		return null;
	}

	@Override
	public List<VPharmacistRecipeDTO> getVPharmacistRecipeList() throws DALException {
		return null;
	}

}