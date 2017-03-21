package data.dao;

import data.dto.ProductBatchComponentDTO;

import java.util.List;

public interface IProductBatchComponentDAO {
    ProductBatchComponentDTO getProductBatchComponent(int pbId, int rbId) throws DALException;
    List<ProductBatchComponentDTO> getProductBatchComponentList(int pbId) throws DALException;
    List<ProductBatchComponentDTO> getProductBatchComponentList() throws DALException;
    void createProductBatchComponent(ProductBatchComponentDTO pbc) throws DALException;
    void updateProductBatchComponent(ProductBatchComponentDTO pbc) throws DALException;
    void deleteProductBatchComponent(int pbID) throws DALException;
}