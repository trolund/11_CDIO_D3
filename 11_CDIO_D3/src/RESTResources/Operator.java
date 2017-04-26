package RESTResources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	/*
	 * I stedet for at have en oprDAO i hver metode, hvorfor saa ikke
	 * have en final global oprDAO?
	 */
	
	@POST
	@Path("/deleteOpr")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String delUser(String oprId){
		
		int id = Integer.parseInt(oprId);
		
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());
	
		try {
			oprDAO.deleteOperator(id);
			System.out.println("User with" + id + "deleted");
			return "User deleted.";
		} catch (DALException e) {
			e.printStackTrace();
			return "ID does not exist." + "id: " + id;
		} catch (NumberFormatException e) {
			e.printStackTrace(); 
			return "Invalid ID.";
		}
	}
	
	@POST
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String verify(LoginForm data) throws JsonParseException, JsonMappingException, IOException {
		
		int id = data.getOprId();
		String pass = data.getPassword(); 
		
		System.out.println(id + pass);
		
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());
		SecUtils secUtil = SecUtils.getInstance();

		OperatorDTO oprDTO = null;
		try {
			oprDTO = oprDAO.getOperator(id);
		} catch (DALException e) {
			e.printStackTrace();
			return "ID does not exist.";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "Invalid ID.";
		}
		
//		try {
//			oprDAO.closeConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		if (secUtil.sha256(pass).equals(oprDTO.getOprPassword())) {
			return "Correct password.";
		} else {
			return "Invalid credentials.";
		}
	}

	@POST
	@Path("/addopr")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String Addopr(creatUserFormPOJO data) throws DALException {

		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());
		SQLRoleDAO roleDAO = new SQLRoleDAO(Connector.getInstance());
		
		OperatorDTO oprDTO = new OperatorDTO(data.getOprId(), data.getOprName(), data.getOprIni(), data.getOprCpr(), data.getOprPassword());


		if(data.getOprRole1().equals("None")){
			RoleDTO roleDTO1 = new RoleDTO(data.getOprId(), data.getOprRole1());
			roleDAO.createRole(roleDTO1);
		}
		if(data.getOprRole2().equals("None")){
			RoleDTO roleDTO2 = new RoleDTO(data.getOprId(), data.getOprRole2());
			roleDAO.createRole(roleDTO2);
		}
		if(data.getOprRole3().equals("None")){
			RoleDTO roleDTO3 = new RoleDTO(data.getOprId(), data.getOprRole3());
			roleDAO.createRole(roleDTO3);
		}
		if(data.getOprRole4().equals("None")){
			RoleDTO roleDTO4 = new RoleDTO(data.getOprId(), data.getOprRole4());
			roleDAO.createRole(roleDTO4);
		}

		try {
			oprDAO.createOperator(oprDTO);
			System.out.println("User - id: " + data.getOprId() + ", Name: " + data.getOprName() + " added!");
			return "User - id: " + data.getOprId() + ", Name: " + data.getOprName() + " added!";

		} catch (DALException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		try {
			oprDAO.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "UPS! - Der skete en fejl";
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
		
		try {
			oprDAO.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/getOprList")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<OperatorDTO> getopr() {
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