package data.dto;

public class ReceptDTO {

    private int receptId;
    private String receptNavn;

    public int getReceptId() {
        return receptId;
    }

    public void setReceptId(int receptId) {
        this.receptId = receptId;
    }

    public String getReceptNavn() {
        return receptNavn;
    }

    public void setReceptNavn(String receptNavn) {
        this.receptNavn = receptNavn;
    }

    @Override
    public String toString() {
        return "ReceptDTO{" +
                "receptId=" + receptId +
                ", receptNavn='" + receptNavn + '\'' +
                '}';
    }

}