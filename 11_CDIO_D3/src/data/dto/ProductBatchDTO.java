package data.dto;

public class ProductBatchDTO {

    private int pBId;
    private int status;
    private int receptId;

    public ProductBatchDTO(int pBId, int status, int receptId) {
        this.pBId = pBId;
        this.status = status;
        this.receptId = receptId;
    }

    public int getpBId() {
        return pBId;
    }

    public int getStatus() {
        return status;
    }

    public int getReceptId() {
        return receptId;
    }

    @Override
    public String toString() {
        return "ProductBatchDTO [" + pBId + ", " + status + ", " + receptId + "]";
    }

}