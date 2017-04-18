package data.dto;

public class VPharmacistRecipeDTO {

	private int raavareId;
	private int receptId;
	private String raavareName;
	private String receptName;

	public VPharmacistRecipeDTO(int raavareId, int receptId, String raavareName, String receptName) {
		super();
		this.raavareId = raavareId;
		this.receptId = receptId;
		this.raavareName = raavareName;
		this.receptName = receptName;
	}

	public int getRaavareId() {
		return raavareId;
	}

	public int getReceptId() {
		return receptId;
	}

	public String getRaavareName() {
		return raavareName;
	}

	public String getReceptName() {
		return receptName;
	}

}