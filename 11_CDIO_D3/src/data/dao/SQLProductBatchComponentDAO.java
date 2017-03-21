package data.dao;

import data.dto.ProductBatchComponentDTO;

import java.util.List;

public class SQLProductBatchComponentDAO implements IProductBatchComponentDAO {

    @Override
    public ProductBatchComponentDTO getProductBatchComponent(int pbId, int rbId) throws DALException {
        return null;
    }

    @Override
    public List<ProductBatchComponentDTO> getProductBatchComponentList(int pbId) throws DALException {
        return null;
    }

    @Override
    public List<ProductBatchComponentDTO> getProductBatchComponentList() throws DALException {
        return null;
    }

    @Override
    public void createProductBatchComponent(ProductBatchComponentDTO pbc) throws DALException {

    }

    @Override
    public void updateProductBatchComponent(ProductBatchComponentDTO pbc) throws DALException {

    }

    @Override
    public void deleteProductBatchComponent(int pbID) throws DALException {

    }

}