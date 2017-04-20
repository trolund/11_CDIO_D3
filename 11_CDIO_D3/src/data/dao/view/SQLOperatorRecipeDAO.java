package data.dao.view;

import java.util.List;

import data.Connector;
import data.DALException;
import data.dto.view.VOperatorRecipeDTO;

public class SQLOperatorRecipeDAO implements IVOperatorRecipeDAO {

	/* Database Connector object */
	private final Connector connector;

	/* Constructor to retrieve the Database Connector object */
	public SQLOperatorRecipeDAO(Connector connector) {
		this.connector = connector;
	}

	@Override
	public VOperatorRecipeDTO getVOperatorRecipe(int receptId) throws DALException {
		return null;
	}

	@Override
	public List<VOperatorRecipeDTO> getVOperatorRecipeList() throws DALException {
		return null;
	}

}