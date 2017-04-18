package data.dto;

import java.util.List;

public class VAdminOperatorDTO {

	private int oprId;
	private String oprName;
	private String oprIni;
	private String oprCpr;
	private String oprPassword;
	List<RoleDTO> oprRoles;

	public VAdminOperatorDTO(int oprId, String oprName, String oprIni, String oprCpr, String oprPassword, List<RoleDTO> oprRoles) {
		this.oprId = oprId;
		this.oprName = oprName;
		this.oprIni = oprIni;
		this.oprCpr = oprCpr;
		this.oprPassword = oprPassword;
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

	public String getOprPassword() {
		return oprPassword;
	}

	public List<RoleDTO> getOprRoles() {
		return oprRoles;
	}

}