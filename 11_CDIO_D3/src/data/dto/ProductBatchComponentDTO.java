package data.dto;

public class ProductBatchComponentDTO {

    private int pBId;
    private int rBId;
    private double tara;
    private double netto;
    private int oprId;

    public ProductBatchComponentDTO(int pBId, int rBId, double tara, double netto, int oprId) {
        this.pBId = pBId;
        this.rBId = rBId;
        this.tara = tara;
        this.netto = netto;
        this.oprId = oprId;
    }

    public int getpBId() {
        return pBId;
    }

    public int getrBId() {
        return rBId;
    }

    public double getTara() {
        return tara;
    }

    public double getNetto() {
        return netto;
    }

    public int getOprId() {
        return oprId;
    }

    @Override
    public String toString() {
        return "ProductBatchComponentDTO [" + pBId + ", " + rBId + ", " + tara + ", " + netto + ", " + oprId + "]";
    }

}