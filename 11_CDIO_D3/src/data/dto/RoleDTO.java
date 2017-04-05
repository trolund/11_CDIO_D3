package data.dto;

public class RoleDTO {

	private int oprId;
	private String roleName;

	public RoleDTO(int oprId, String roleName) {
		this.oprId = oprId;
		this.roleName = roleName;
	}

	public int getOprId() {
		return oprId;
	}

	public String getRoleName() {
		return roleName;
	}

	@Override
	public String toString() {
		return "RoleDTO [" + oprId + ", " + roleName + "]";
	}

}