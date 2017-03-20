package data.dto;

public class ReceptComponentDTO {

    private int receptId;
    private int raavareId;
    private double nomNetto;
    private double tolerance;

    public int getReceptId() {
        return receptId;
    }

    public void setReceptId(int receptId) {
        this.receptId = receptId;
    }

    public int getRaavareId() {
        return raavareId;
    }

    public void setRaavareId(int raavareId) {
        this.raavareId = raavareId;
    }

    public double getNomNetto() {
        return nomNetto;
    }

    public void setNomNetto(double nomNetto) {
        this.nomNetto = nomNetto;
    }

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

}