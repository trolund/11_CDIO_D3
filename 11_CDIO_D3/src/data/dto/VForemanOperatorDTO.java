package data.dto;

import java.util.List;

public class VForemanOperatorDTO {

	private int oprId;
	private String oprName;
	private String oprIni;
	private String oprCpr;
	private List<RoleDTO> oprRoles;

	public VForemanOperatorDTO(int oprId, String oprName, String oprIni, String oprCpr, List<RoleDTO> oprRoles) {
		this.oprId = oprId;
		this.oprName = oprName;
		this.oprIni = oprIni;
		this.oprCpr = oprCpr;
		this.oprRoles = oprRoles;
	}

	public int getOprId() {
		return oprId;
	}

	public String getOprName() {
		return oprName;
	}

	public String getOprIni() {
		return oprIni;
	}

	public String getOprCpr() {
		return oprCpr;
	}

	public List<RoleDTO> getOprRoles() {
		return oprRoles;
	}

}