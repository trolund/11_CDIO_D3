package RESTResources;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import RESTResources.model.LoginForm;
import RESTResources.model.creatUserFormPOJO;
import data.Connector;
import data.DALException;
import data.dao.SQLOperatorDAO;
import data.dao.SQLRoleDAO;
import data.dto.OperatorDTO;
import data.dto.RoleDTO;
import utils.SecUtils;

@Path("/opr")
public class Operator {

	@POST
	@Path("/deleteOpr")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean delUser(String oprId) {
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());

		int id = -1;

		try {
			id = Integer.parseInt(oprId);
			oprDAO.deleteOperator(id);
			System.out.println("User [" + id + "] successfully deleted.");
			return true;
		} catch (DALException e) {
			e.printStackTrace();
			return false;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

	@POST
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String verify(LoginForm formData) throws JsonParseException, JsonMappingException, IOException {
		int id = formData.getOprId();
		String password = formData.getPassword();

		System.out.println("Id: " + id + ", Password: " + password);

		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());
		SecUtils secUtil = SecUtils.getInstance();

		OperatorDTO oprDTO = null;
		try {
			oprDTO = oprDAO.getOperator(id);
		} catch (DALException e) {
			e.printStackTrace();
			return "Id does not exist.";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "Invalid Id.";
		}

		if (secUtil.sha256(password).equals(oprDTO.getOprPassword())) {
			return "Logged in successfully.";
		} else {
			return "Invalid credentials.";
		}
	}

	@POST
	@Path("/addopr")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String Addopr(creatUserFormPOJO formData) throws DALException {
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());
		SQLRoleDAO roleDAO = new SQLRoleDAO(Connector.getInstance());

		OperatorDTO oprDTO = new OperatorDTO(formData.getOprId(), formData.getOprName(), formData.getOprIni(), formData.getOprCpr(), formData.getOprPassword());

		if (formData.getOprRole1().equals("None")) {
			RoleDTO roleDTO1 = new RoleDTO(formData.getOprId(), formData.getOprRole1());
			roleDAO.createRole(roleDTO1);
		}
		
		if (formData.getOprRole2().equals("None")) {
			RoleDTO roleDTO2 = new RoleDTO(formData.getOprId(), formData.getOprRole2());
			roleDAO.createRole(roleDTO2);
		}
		
		if (formData.getOprRole3().equals("None")) {
			RoleDTO roleDTO3 = new RoleDTO(formData.getOprId(), formData.getOprRole3());
			roleDAO.createRole(roleDTO3);
		}
		
		if (formData.getOprRole4().equals("None")) {
			RoleDTO roleDTO4 = new RoleDTO(formData.getOprId(), formData.getOprRole4());
			roleDAO.createRole(roleDTO4);
		}

		try {
			oprDAO.createOperator(oprDTO);
			System.out.println("User with Id: " + formData.getOprId() + ", Name: " + formData.getOprName() + " successfully added.");
			return "User: id: " + formData.getOprId() + ", Name: " + formData.getOprName() + " successfully added.";
		} catch (DALException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return "Encountered failure.";
	}

	@GET
	@Path("/{oprId}")
	@Produces(MediaType.APPLICATION_JSON)
	public OperatorDTO getName(@PathParam("oprId") String oprId) {
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());

		int id = Integer.parseInt(oprId);

		List<OperatorDTO> oprList = null;
		try {
			oprList = oprDAO.getOperatorList();
		} catch (DALException e) {
			e.printStackTrace();
		}

		for (OperatorDTO oprDTO : oprList) {
			if (oprDTO.getOprId() == id) return oprDTO;
		}

		return null;
	}

	@GET
	@Path("/getOprList")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OperatorDTO> getopr() {
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());

		List<OperatorDTO> oprList = null;

		try {
			oprList = oprDAO.getOperatorList();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return oprList;
	}

	@GET
	@Path("/getOprRoleList/{OprId}")
	@Produces(MediaType.TEXT_HTML)
	public String getoprRoleList(@PathParam("OprId") String OprId) {
		SQLRoleDAO oprDAO = new SQLRoleDAO(Connector.getInstance());

		StringBuilder returnString = new StringBuilder();
		List<RoleDTO> oprRoleList = null;
		
		try {
			oprRoleList = oprDAO.getOprRoles(Integer.parseInt(OprId));
		} catch (DALException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			e.printStackTrace();
		}

		for (Iterator<RoleDTO> iterator = oprRoleList.iterator(); iterator.hasNext();) {
			RoleDTO roleDTO = (RoleDTO) iterator.next();
			if (iterator.hasNext())
				returnString.append(roleDTO.getRoleName() + ", ");
			else
				returnString.append(roleDTO.getRoleName());
		}

		return returnString.toString();
	}

}