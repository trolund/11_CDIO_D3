package data.dao;

import java.util.List;

import data.dto.VPharmacistRecipeDTO;

public interface IVPharmacistRecipeDAO {
	VPharmacistRecipeDTO getVPharmacistRecipe(int receptId) throws DALException;
	List<VPharmacistRecipeDTO> getVPharmacistRecipeList() throws DALException;
}