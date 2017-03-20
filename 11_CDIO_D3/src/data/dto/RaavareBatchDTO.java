package data.dto;

public class RaavareBatchDTO {

    private int raavareBatchId;
    private int raavareId;
    private double amount;

    public int getRaavareBatchId() {
        return raavareBatchId;
    }

    public void setRaavareBatchId(int raavareBatchId) {
        this.raavareBatchId = raavareBatchId;
    }

    public int getRaavareId() {
        return raavareId;
    }

    public void setRaavareId(int raavareId) {
        this.raavareId = raavareId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}