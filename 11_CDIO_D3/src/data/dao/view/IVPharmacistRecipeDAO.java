package data.dao.view;

import java.util.List;

import data.DALException;
import data.dto.view.VPharmacistRecipeDTO;

public interface IVPharmacistRecipeDAO {
	VPharmacistRecipeDTO getVPharmacistRecipe(int receptId) throws DALException;
	List<VPharmacistRecipeDTO> getVPharmacistRecipeList() throws DALException;
}