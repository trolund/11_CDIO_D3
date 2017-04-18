package data.dao;

import java.util.List;

import data.dto.VOperatorRecipeDTO;

public interface IVOperatorRecipeDAO {
	VOperatorRecipeDTO getVOperatorRecipe(int receptId) throws DALException;
	List<VOperatorRecipeDTO> getVOperatorRecipeList() throws DALException;
}