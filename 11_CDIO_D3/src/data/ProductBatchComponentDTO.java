package data;

public class ProductBatchComponentDTO {

    private int productBatchId;
    private int raavareBatchId;
    private double tara;
    private double netto;
    private int operatorId;

    public int getProductBatchId() {
        return productBatchId;
    }

    public void setProductBatchId(int productBatchId) {
        this.productBatchId = productBatchId;
    }

    public int getRaavareBatchId() {
        return raavareBatchId;
    }

    public void setRaavareBatchId(int raavareBatchId) {
        this.raavareBatchId = raavareBatchId;
    }

    public double getTara() {
        return tara;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

}