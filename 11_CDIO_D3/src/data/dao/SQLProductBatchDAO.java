package data.dao;

import data.dto.ProductBatchDTO;

import java.util.List;

public class SQLProductBatchDAO implements IProductBatchDAO {

    @Override
    public ProductBatchDTO getProductBatch(int pbId) throws DALException {
        return null;
    }

    @Override
    public List<ProductBatchDTO> getProductBatchList() throws DALException {
        return null;
    }

    @Override
    public void createProductBatch(ProductBatchDTO pb) throws DALException {

    }

    @Override
    public void updateProductBatch(ProductBatchDTO pb) throws DALException {

    }

    @Override
    public void deleteProductBatch(int pbId) throws DALException {

    }

}