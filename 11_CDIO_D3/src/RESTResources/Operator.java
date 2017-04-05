package RESTResources;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Connector;
import data.dao.DALException;
import data.dao.SQLOperatorDAO;
import data.dto.OperatorDTO;
import utils.SecUtils;

@Path("/opr")
public class Operator {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getUser() {
		return "If you see this, REST should be working correctly!";
	}

	@POST
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public String verify(@FormParam("oprId") String oprId, @FormParam("password") String password) {
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());
		SecUtils secUtil = SecUtils.getInstance();

		OperatorDTO oprDTO = null;
		try {
			oprDTO = oprDAO.getOperator(Integer.parseInt(oprId));
		} catch (DALException e) {
			e.printStackTrace();
			return "ID does not exist.";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "Invalid ID.";
		}

		if (secUtil.sha256(password).equals(oprDTO.getOprPassword())) {
			return "Correct password.";
		} else {
			return "Invalid credentials.";
		}
	}

	@GET
	@Path("/getname")
	@Produces(MediaType.TEXT_PLAIN)
	public String getname() {
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());
		OperatorDTO oprDTO = null;

		try {
			oprDTO = oprDAO.getOperator(1);
		} catch (DALException e) {
			e.printStackTrace();
			return "opr with that ID does not exist.";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "Invalid ID.";
		}
		return oprDTO.getOprName();
	}

	@GET
	@Path("/getOprList")
	@Produces(MediaType.TEXT_HTML)
	public String getopr() {
		SQLOperatorDAO oprDAO = new SQLOperatorDAO(Connector.getInstance());
		List<OperatorDTO> oprList = null;
		try {
			oprList = oprDAO.getOperatorList();
		} catch (DALException e) {
			e.printStackTrace();
		}

		StringBuilder returnString = new StringBuilder();

		for (Iterator iterator = oprList.iterator(); iterator.hasNext();) {
			OperatorDTO operatorDTO = (OperatorDTO) iterator.next();
			returnString.append("<table>");
			returnString.append("<tr>" + "<td>" + operatorDTO.getOprId() + "</td>" + "<td>" + operatorDTO.getOprIni() + "</td>" + "<td>" + operatorDTO.getOprName() + "</td>" + "<td>" + operatorDTO.getOprCpr() + "</td>" + "<td>" + operatorDTO.getOprPassword() + "</td>" + "</tr>");
			returnString.append("</table>");
		}
		return returnString.toString();
	}

}