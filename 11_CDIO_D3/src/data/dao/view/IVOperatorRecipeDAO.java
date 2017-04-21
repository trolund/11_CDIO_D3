package data.dao.view;

import java.util.List;

import data.DALException;
import data.dto.view.VOperatorRecipeDTO;

public interface IVOperatorRecipeDAO {
	List<VOperatorRecipeDTO> getVOperatorRecipe(int receptId) throws DALException;
	List<VOperatorRecipeDTO> getVOperatorRecipeList() throws DALException;
}