package data.dto;

public class VOperatorRBDTO {

	private int raavareId;
	private int rbId;
	private double maengde;
	private String raavareName;
	private String supplier;

	public VOperatorRBDTO(int raavareId, int rbId, double maengde, String raavareName, String supplier) {
		super();
		this.raavareId = raavareId;
		this.rbId = rbId;
		this.maengde = maengde;
		this.raavareName = raavareName;
		this.supplier = supplier;
	}

	public int getRaavareId() {
		return raavareId;
	}

	public int getRbId() {
		return rbId;
	}

	public double getMaengde() {
		return maengde;
	}

	public String getRaavareName() {
		return raavareName;
	}

	public String getSupplier() {
		return supplier;
	}

}