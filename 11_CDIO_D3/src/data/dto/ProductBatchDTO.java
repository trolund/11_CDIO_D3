package data.dto;

public class ProductBatchDTO {

    private int productBatchId;
    private int status;
    private int receptId;

    public int getProductBatchId() {
        return productBatchId;
    }

    public void setProductBatchId(int productBatchId) {
        this.productBatchId = productBatchId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getReceptId() {
        return receptId;
    }

    public void setReceptId(int receptId) {
        this.receptId = receptId;
    }

    @Override
    public String toString() {
        return "ProductBatchDTO{" +
                "productBatchId=" + productBatchId +
                ", status=" + status +
                ", receptId=" + receptId +
                '}';
    }

}