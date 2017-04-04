package data.dao;

import data.dto.ProductBatchDTO;

import java.util.List;

public interface IProductBatchDAO {
    ProductBatchDTO getProductBatch(int pbId) throws DALException;
    List<ProductBatchDTO> getProductBatchList() throws DALException;
    void createProductBatch(ProductBatchDTO pbDTO) throws DALException;
    void updateProductBatch(ProductBatchDTO pbDTO) throws DALException;
    void deleteProductBatch(int pbId) throws DALException;
}